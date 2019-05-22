package com.company.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");*/
        //用户是上传了背景图片
        //把用户上传的图片下载到本地
        Part part = request.getPart("filedb");
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."), disposition.length() - 1);
        //随机的生存一个32的字符串
        String filename = UUID.randomUUID() + suffix;
        //System.out.println(filename);
        //获取上传的文件名
        InputStream is = part.getInputStream();
        //动态获取服务器的路径
        String serverpath = request.getServletContext().getRealPath("img/mood_img");
        FileOutputStream fos = new FileOutputStream(serverpath + "/" + filename);
        byte[] bty = new byte[1024];
        int length = 0;
        while ((length = is.read(bty)) != -1) {
            fos.write(bty, 0, length);
        }
        fos.close();
        is.close();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String weather = request.getParameter("weather");
        request.setAttribute("title",title);
        request.setAttribute("content",content);
        request.setAttribute("weather",weather);

        //把上传的图片放到request域中，转发到writeDiary.jsp
        request.setAttribute("filename",filename);
        request.getRequestDispatcher("/writeDiary.jsp").forward(request,response);


    }
}
