package isa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_ads_db", "root", "");
		return conn;
	}
	
	public static void close(ResultSet rs, Statement st, Connection conn) throws SQLException {
		
		if(rs != null)
			rs.close();
		if(st != null)
			st.close();
		if(conn != null)
			conn.close();
	}
}
