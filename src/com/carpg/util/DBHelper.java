package com.carpg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBHelper {
	
	// �������
    private final static String driver = "com.mysql.jdbc.Driver";
    // URLָ��Ҫ���ʵ���ݿ���scutcs
    private final static String url = "jdbc:mysql://localhost:3306/carpg?useUnicode=true&characterEncoding=utf-8";
    // MySQL����ʱ���û���
    private final static String user = "root"; 
    // MySQL����ʱ������
    private final static String password = "carpg";
    private static Connection conn = null;
    
    // һ��l�Ӷ���
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user,
					password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("l��ʧ��");
		}
		return conn;
	}
	
	// �ر�l��
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
