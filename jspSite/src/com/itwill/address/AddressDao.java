package com.itwill.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
Dao(Data Access Object)
 - Address들의 데이터를 저장하고있는 Address 테이블에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스
 - AddressService객체의 요청(메쏘드호출)을 받아서 
   Data Access(DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
public class AddressDao {
	public int insert(Address address) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_INSERT);
		pstmt.setString(1, address.getId());
		pstmt.setString(2, address.getName());
		pstmt.setString(3, address.getPhone());
		pstmt.setString(4, address.getAddress());
		int insertRowCount=pstmt.executeUpdate();
		System.out.println("insert row count:"+insertRowCount);
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}
	public int insert(String id, String name, String phone, String address) throws Exception{
		String insertSql=
	"insert into address values(address_no_seq.nextval,'"+id+"'||address_no_seq.currval,'"+name+"','"+phone+"','"+address+"')";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(insertSql);
		int insertRowCount=pstmt.executeUpdate();
		System.out.println("insert row count:"+insertRowCount);
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}
	public int delete(int no)throws Exception {
		
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_DELETE);
		pstmt.setInt(1, no);
		int deleteRowCounts=pstmt.executeUpdate();
		System.out.println("delete row count:"+deleteRowCounts);
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deleteRowCounts;
	}
	public int update(Address updateAddress) throws Exception{
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_UPDATE);
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		int updateRowCounts=pstmt.executeUpdate();
		System.out.println("update row count:"+updateRowCounts);
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return updateRowCounts;
	}
	public Address selectByPk(int no)throws Exception {
		Address findAddress=null;
		
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_PK);
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			findAddress=
					new Address(rs.getInt("no"),
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("phone"),
								rs.getString("address"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return findAddress;
	}
	public ArrayList<Address> selectAll() throws Exception{
		ArrayList<Address> addressList=new ArrayList<Address>();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AddressSQL.ADDRESS_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			addressList.add(
					new Address(rs.getInt("no"),
								rs.getString("id"),
								rs.getString("name"),
								rs.getString("phone"),
								rs.getString("address")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return addressList;
	}
	
}
