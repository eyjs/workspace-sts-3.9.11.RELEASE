package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddressInsertMain {

	public static void main(String[] args)  throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String insertSql="insert into address values(address_no_seq.nextval,'xxx'||address_no_seq.currval,'±Ë∞Ê»£','010-123-4567','∞Ê±‚µµπŒ')";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(insertSql);
		int insertRowCount=pstmt.executeUpdate();
		System.out.println("insert row count:"+insertRowCount);
		
		pstmt.close();
		con.close();
	}

}
