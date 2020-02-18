package connection;

public class AccountABSQL {
	public final static String updateSqlA=
			"update accountA set acc_balance = acc_balance - ? where acc_no = ?";
	public final static String updateSqlB=
			"update accountB set acc_balance = acc_balance + ? where acc_no = ?";
	public final static String selectSqlA=
			"select acc_balance from accountA where acc_no=?";
	public final static String selectSqlB=
			"select acc_balance from accountB where acc_no=?";
}
