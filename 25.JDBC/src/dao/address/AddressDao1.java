package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
Dao(Data Access Object)
 - Address들의 데이터를 저장하고있는 Address 테이블에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스
 - AddressService객체의 요청(메쏘드호출)을 받아서 
   Data Access(DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
public class AddressDao1 {
	public void insert() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String insertSql="insert into address values(address_no_seq.nextval,'xxx'||address_no_seq.currval,'김경호','010-123-4567','경기도민')";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(insertSql);
		int insertRowCount=pstmt.executeUpdate();
		System.out.println("insert row count:"+insertRowCount);
		
		pstmt.close();
		con.close();
	}
	public void delete()throws Exception {
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
	public void update() throws Exception{
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
	public void selectByPk()throws Exception {
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
	public void selectAll() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String selectOneSql="select no,id,name,phone,address from address";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=con.prepareStatement(selectOneSql);
		ResultSet rs=pstmt.executeQuery();
		
		while (rs.next()) {
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
