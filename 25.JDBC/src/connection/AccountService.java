package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itwill.dao.common.ConnectionFactory;

public class AccountService {
	
	public void transfer() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=ConnectionFactory.getConnection();
			/*
			 * 1. con.setAutoCommit(false);
			 */
			con.setAutoCommit(false);
			/*
			 * transaction start
			 */
			pstmt=con.prepareStatement(AccountABSQL.updateSqlA);
			int acc_no = 10000;
			int money  = 100000;
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			int rowCount=pstmt.executeUpdate();
			System.out.println("1.accountA"+ acc_no+" °èÁÂÀÜ°í "+money+"¿ø °¨¼Ò(update):"+rowCount);
			pstmt.close();
			pstmt=con.prepareStatement(AccountABSQL.updateSqlB);
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			rowCount=pstmt.executeUpdate();
			System.out.println("2.accountB"+ acc_no+" °èÁÂÀÜ°í "+money+"¿ø °¨¼Ò(update):"+rowCount);
			pstmt.close();
			
			pstmt=con.prepareStatement(AccountABSQL.selectSqlA);
			pstmt.setInt(1, acc_no);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int balanceA = rs.getInt("acc_balance");
				if(balanceA < 0) {
					/*
					 * transaction end[rollback]
					 */
					con.rollback();
					System.out.println("3-1.A°èÁÂÀÜ°í "+ balanceA+ " À½¼ö-->rollback");
				}else {
					con.commit();
					System.out.println("3-2.A°èÁÂÀÜ°í "+ balanceA+ " ¾ç¼ö-->commit");
				}
			}else {
				throw new Exception("unknown error!!");
			}
		}catch (Exception e) {
			
			try {
				/*
				 * transaction end[rollback]
				 */
				con.rollback();
				System.out.println("99.rollback(Exception)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}
}
