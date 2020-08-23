package examples.pubhub.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class ConnectionUtility {
	
	public static java.sql.Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/pubhub100db";
		java.sql.Connection con = DriverManager.getConnection(url, "root", "root");
		return con;
	}
}
