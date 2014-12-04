package com.carpg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBHelper {
	
	// 驱动程序名
    private final static String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名scutcs
    private final static String url = "jdbc:mysql://localhost:3306/carpg?useUnicode=true&characterEncoding=utf-8";
    // MySQL配置时的用户名
    private final static String user = "root"; 
    // MySQL配置时的密码
    private final static String password = "123456";
    private static Connection conn = null;
    
    // 一个连接对象
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user,
					password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
		return conn;
	}
	
	// 关闭连接
	public static void close(ResultSet rs, PreparedStatement pstmt) {
		if (null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
