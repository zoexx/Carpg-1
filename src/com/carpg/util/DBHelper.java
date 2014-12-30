package com.carpg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBHelper {
	
	//数据库连接驱动
    private final static String driver = "com.mysql.jdbc.Driver";
    // 数据库连接url
    private final static String url = "jdbc:mysql://localhost:3306/carpg?useUnicode=true&characterEncoding=utf-8";
    // 用户名
    private final static String user = "root"; 
    // 密码
    private final static String password = "123456";
    private static Connection conn = null;
    
    // 创建数据库连接（单例模式）
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return conn;
	}
	
	// 关闭连接
	public static void close() {
		if (null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    

}
