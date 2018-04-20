package bca.batch2011.project1.sac;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
public class PositionDB {
	// this function is to insert the data into position master table in the database//
	public void insert(PositionBean real, PrintWriter out) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		ResultSet rs= null;
		String query= "insert into Position_Master_Table(Position_Title,Points)values(?,?);";
		Connection conn = Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1,real.getPositiontitle());
		ps.setInt(2,real.getPoints());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	// this function is to delete the contents from the position master table in the database//
	public  void delete(String pid) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		String query1= "delete from Position_Master_Table where Position_Id in("+pid+");";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query1);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	// this function is to modify the contents of position master table in the database//
	public PositionBean modify(PositionBean real,PrintWriter out) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		ResultSet rs= null;
		String query3= "select * from Position_Master_Table where Position_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query3);
		ps.setInt(1, real.getPositionid());
		rs= ps.executeQuery();
		rs.next();
        real.setPositionid(rs.getInt("Position_Id"));
        real.setPositiontitle(rs.getString("Position_Title"));
        real.setPoints(rs.getInt("Points"));
        Database.freeConnection(conn);
		return real;
	    }
	// this function is to update the contents of the position master table int he database//
	public void update(PositionBean real,PrintWriter out) throws ClassNotFoundException, IOException, SQLException
	{
		 PreparedStatement ps=null;
		 String query="update Position_Master_Table set Position_Title= ?,Points= ? where Position_Id= ?;";
		 Connection conn= Database.getConnection();
		 ps=conn.prepareStatement(query);	
		 ps.setString(1,real.getPositiontitle());
		 ps.setInt(2,real.getPoints());
		 ps.setInt(3,real.getPositionid());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	// this function is to get the data from the database and captures these values into ArrayList object of this class//
	public ArrayList<PositionBean> select() throws IOException,ClassNotFoundException, SQLException 
	{
    	PreparedStatement ps = null;
		ResultSet rs= null;
		PositionBean position= new PositionBean();
		ArrayList<PositionBean> positionarray1= new ArrayList<PositionBean>();
		String query3= "select * from Position_Master_Table order by  Position_Id";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement(); 
	    rs= stmt.executeQuery(query3);
		while(rs.next())
		{
		   position.setPositionid(rs.getInt("Position_Id"));
		   position.setPositiontitle(rs.getString("Position_Title"));
	       position.setPoints(rs.getInt("Points"));
	       positionarray1.add(position);
	       position= new PositionBean();
		}
		Database.freeConnection(conn);
		return positionarray1;	 
	 }
}