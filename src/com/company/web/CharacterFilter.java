package com.company.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CharacterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        String spath = req.getServletPath();
        if(spath.contains(".js")||spath.contains(".css")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            req.setCharacterEncoding("UTF-8");
            res.setContentType("text/html;charset=UTF-8");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        //不需要过滤的url
        /*String[] urls = {"/login","/json",".js",".css",".ico",".jpg",".png"};*/
        /*for (String str : urls) {
            if (spath.contains(str)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                req.setCharacterEncoding("UTF-8");
                res.setContentType("text/html;charset=UTF-8");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }*/
    }

    @Override
    public void destroy() {

    }
}
