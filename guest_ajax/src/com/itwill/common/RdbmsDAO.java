package com.itwill.common;



import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class RdbmsDAO{
	InitialContext ic;
	DataSource ds;
	Connection con;
	public Connection getConnection(){
		try{
			ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
			con=ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void releaseConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










