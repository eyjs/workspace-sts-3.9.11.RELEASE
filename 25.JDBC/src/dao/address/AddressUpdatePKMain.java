package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddressUpdatePKMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String updateSql="update address set name='고소미',phone=8888,address='경기도민' where no = 1";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(updateSql);
		int updateRowCounts=pstmt.executeUpdate();
		System.out.println("update row count:"+updateRowCounts);
		pstmt.close();
		con.close();
	}

}
