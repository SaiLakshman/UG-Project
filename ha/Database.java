package bca.batch2011.project1.ha;
import java.io.IOException;
import java.sql.*;

public class Database
{
	private Database()
	{
	}
	/* This function helps us to get the connection from database
	*/
	public static synchronized Connection getConnection() throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= null;
		if(conn == null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost/SIMS","root","sairam");
		}
		return conn;   
	}
	/* This function helps us to free the connection from database
	*/
	public static void freeConnection(Connection conn) throws SQLException
	{
		if(conn != null)
			conn.close();
	}
}
