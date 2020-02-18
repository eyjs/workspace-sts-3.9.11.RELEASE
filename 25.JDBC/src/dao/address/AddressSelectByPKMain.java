package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressSelectByPKMain {

	public static void main(String[] args)throws Exception {
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String selectOneSql="select no,id,name,phone,address from address where no = 1";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(selectOneSql);
		ResultSet rs=pstmt.executeQuery();
		
		if (rs.next()) {
			System.out.println(rs.getInt("no")+"\t"+
							  rs.getString("id")+"\t"+
							  rs.getString("name")+"\t"+
							  rs.getString("phone")+"\t"+
							  rs.getString("address"));
			
		}
		rs.close();
		pstmt.close();
		con.close();
		
	}

}










