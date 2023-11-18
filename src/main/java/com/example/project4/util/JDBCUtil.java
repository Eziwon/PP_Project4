package com.example.project4.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con= DriverManager.getConnection("jdbc:mariadb://walab.handong.edu:3306/p233_22100574","p233_22100574","Yogh8o");
	    }catch(Exception e){
	    	System.out.println(e);
	    }  
	    return con;  
	}  
	
//	public static void main(String ars[]) {
//		Connection conn = getConnection();
//		if(conn != null)
//			System.out.println("DB 연결됨!");
//		else
//			System.out.println("DB 연결중 오류 !");
//	}
}