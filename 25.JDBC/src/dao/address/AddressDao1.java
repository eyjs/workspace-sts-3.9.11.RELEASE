package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
Dao(Data Access Object)
 - Address���� �����͸� �����ϰ��ִ� Address ���̺�
   CRUD(Create, Read, Update, Delete) �۾��� �Ҽ��ִ�
   �����޽�带 �������ִ� Ŭ����
 - AddressService��ü�� ��û(�޽��ȣ��)�� �޾Ƽ� 
   Data Access(DB)�� ���õ� �������(CRUD)��
   �����ϴ� ��ü
 */
public class AddressDao1 {
	public void insert() throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		String insertSql="insert into address values(address_no_seq.nextval,'xxx'||address_no_seq.currval,'���ȣ','010-123-4567','��⵵��')";
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
		
		String updateSql="update address set name='��ҹ�',phone=8888,address='��⵵��' where no = 1";
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
