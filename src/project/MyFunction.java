package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class MyFunction {
	public static int countData(String tableName)
	{
		int total = 0;
		Connection conn = MyConnection.getConnection();
		Statement statement;
		try {
			statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tableName);
		while (rs.next()) {
			total = rs.getInt(1);
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return total;
	}
}
