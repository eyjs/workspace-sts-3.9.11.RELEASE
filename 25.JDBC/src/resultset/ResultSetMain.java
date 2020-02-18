package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.itwill.dao.common.ConnectionFactory;

public class ResultSetMain {

	public static void main(String[] args) throws Exception{
		/*
		이름         널?       유형            
		---------- -------- ------------- 
		NO         NOT NULL NUMBER(7)     
		NAME                VARCHAR2(50)  
		SHORT_DESC          VARCHAR2(255) 
		PRICE               NUMBER(10,3)  
		IPGO_DATE           DATE 
		 */
		String selectSql="select no,name,price,short_desc,ipgo_date from s_product";
		Connection con = ConnectionFactory.getConnection();
		//PreparedStatement pstmt = con.prepareStatement(selectSql);
		PreparedStatement pstmt =
				con.prepareStatement(selectSql);
		
		ResultSet rs=pstmt.executeQuery();
		
		boolean isExist = rs.next();
		System.out.println("---------------rs.getXXX(컬럼이름)-------------");
		if(isExist) {
			do{
				
				int no=rs.getInt("no");
				String name = rs.getString("name");
				double price=rs.getDouble("price");
				String desc = rs.getString("short_desc");
				Date ipgo_date=rs.getDate("ipgo_date");
				System.out.println(no+"\t"+name+"\t"+desc+"\t"+price+"\t"+ipgo_date);
			}while(rs.next());
			
		}else {
			System.out.println("상품없다..");
		}
		rs.close();
		rs = pstmt.executeQuery();
		
		System.out.println("---------------rs.getXXX(컬럼index)-------------");
		while (rs.next()) {
			int no=rs.getInt(1);
			String name = rs.getString(2);
			double price=rs.getDouble(3);
			String desc = rs.getString(4);
			Date ipgo_date=rs.getDate(5);
			System.out.println(no+"\t"+name+"\t"+desc+"\t"+price+"\t"+ipgo_date);
		}
		rs.close();
		rs = pstmt.executeQuery();
		System.out.println("---------------rs.getObject(컬럼이름)-------------");
		while (rs.next()) {
			Object no=rs.getObject(1);
			Object name = rs.getObject(2);
			Object price=rs.getObject(3);
			Object desc = rs.getObject(4);
			Object ipgo_date=rs.getObject(5);
			System.out.println(no+"\t"+name+"\t"+desc+"\t"+price+"\t"+ipgo_date);
		}
		rs.close();
		rs = pstmt.executeQuery();
		System.out.println("---------------rs.getString(컬럼이름)-------------");
		while (rs.next()) {
			String no=rs.getString("no");
			String name = rs.getString("name");
			String price=rs.getString("price");
			String desc = rs.getString("short_desc");
			String ipgo_date=rs.getString("ipgo_date");
			System.out.println(no+"\t"+name+"\t"+desc+"\t"+price+"\t"+ipgo_date);
		}
		rs.close();
	}

}






