package sqlminus;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;
import com.itwill.dao.common.ConnectionFactory;
public class SQLMinus {
	public static void main(String[] args) throws Exception{
		Connection con = ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		System.out.println();
		System.out.println("SQL*Minus: Release 11.2.0.2.0 Production on "+new Date().toLocaleString());
		System.out.println("Copyright (c) 1982, 2014, Oracle.  All rights reserved.");
		System.out.println();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("SQL>");
			String readSql = br.readLine();
			if(readSql.equalsIgnoreCase("EXIT")) {
				System.out.println("Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0");
				break;
			}
			try {
				boolean isResultset = stmt.execute(readSql);
				if(isResultset) {
					//ResultSet
					ResultSet rs=stmt.getResultSet();
					ResultSetMetaData rsmd=rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					String headerStr="";
					for (int i = 1; i <= columnCount; i++) {
						headerStr+=rsmd.getColumnName(i)+"\t";
					}
					System.out.println("--------------------------");
					System.out.println(headerStr);
					System.out.println("--------------------------");
					
					while (rs.next()) {
						String rowString="";
						for (int i = 1; i <= columnCount; i++) {
							rowString+= rs.getString(i)+"\t";
						}
						System.out.println(rowString);
					}
				}else {
					//UpdateCount
					int rowCount = stmt.getUpdateCount();
					System.out.println(rowCount+" row(s) change...");
				}
			}catch (Exception e) {
				System.out.println(""+e.getMessage());
			}
			
		}

	}

}
