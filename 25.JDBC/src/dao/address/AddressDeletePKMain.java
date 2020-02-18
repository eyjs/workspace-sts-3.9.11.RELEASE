package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddressDeletePKMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String deleteSql="delete from address where no = 5";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(deleteSql);
		int deleteRowCounts=pstmt.executeUpdate();
		System.out.println("delete row count:"+deleteRowCounts);
		
		pstmt.close();
		con.close();

	}

}
