package com.company.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class jdbcUtil {

	public static DataSource ds=null;
	static {
		try {
			Properties p=new Properties();
			//获取字节码目录
			String path = jdbcUtil.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream in=new FileInputStream(path);
			p.load(in);
			ds=new DruidDataSourceFactory().createDataSource(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return ds;
	}
	public static QueryRunner getQueryRunner() {
		QueryRunner qr=new QueryRunner(ds);
		return qr;
	}



}
