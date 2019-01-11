package com.biz.oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection dbConn;
	
	static {
		
		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		// Maven Dependencies -> ojar6 > oracle driver > copy quailified name
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		// 상단의 window > show view > DataSource Exploer myBTs만들고 xe로 만들고하기
		String user = "mybts";
		String password = "1234";
		
		try {
			Class.forName(oracleDriver);
			dbConn = DriverManager.getConnection(url, user, password);
			
			// add catch로 바꿔주기
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
