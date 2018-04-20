package bca.batch2011.project1.sac;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
public class EventDB {
	/**
	 * this function is to insert the data into event master table in the database//
	 */
	public void insert(EventBean real) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		String query= "insert into Event_Master_Table(Event_Name,Group_Individual,Sports_Cultural_Athletic)values(?,?,?);";
		Connection conn = Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, real.getEventname());
		ps.setInt(2,real.getGroup_individual());
		ps.setInt(3, real.getSports_cultural_athletic());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 *  the function is to delete the data from event master table in the database//
	 */
	public  void delete(String eid) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		String query1= "delete from Event_Master_Table where Event_Id in("+eid+");";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query1);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 *  the function is to modify the contents of the event master table in the database//
	 */
	public EventBean modify(EventBean real) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		ResultSet rs= null;
		String query3= "select * from Event_Master_Table where Event_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query3);
		ps.setInt(1, real.getEventid());
		rs= ps.executeQuery();
		rs.next();
        real.setEventid(rs.getInt("Event_Id"));
        real.setEventname(rs.getString("Event_Name"));
        real.setGroup_individual(rs.getInt("Group_Individual"));
        real.setSports_cultural_athletic(rs.getInt("Sports_Cultural_Athletic"));
        Database.freeConnection(conn);
		return real;
    }
	/**
	 *  the function is to update the contents of the event master table in the database//
	 */
	public void update(EventBean real) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps=null;
		String query="update Event_Master_Table set Event_Name= ?,Group_Individual= ?,Sports_Cultural_Athletic= ? where Event_Id= ?;";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query);	
		ps.setString(1,real.getEventname());
		ps.setInt(2,real.getGroup_individual());
		ps.setInt(3,real.getSports_cultural_athletic());
		ps.setInt(4,real.getEventid());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 * this function is to get the data from the database and captures these values in 
	 * ArrayList object of this class//
	*/
	public ArrayList<EventBean> select() throws ClassNotFoundException, IOException, SQLException       
	{
    	PreparedStatement ps = null;
		ResultSet rs= null;
		EventBean event= new EventBean();
		ArrayList<EventBean> eventarray1= new ArrayList<EventBean>();
		String query3= "select * from Event_Master_Table order by Group_Individual,Sports_Cultural_Athletic,Event_Name";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement(); 
	    rs= stmt.executeQuery(query3);
		while(rs.next())
		{
		   event.setEventid(rs.getInt("Event_Id"));
		   event.setEventname(rs.getString("Event_Name"));
	       event.setGroup_individual(rs.getInt("Group_Individual"));
           event.setSports_cultural_athletic(rs.getInt("Sports_Cultural_Athletic"));
	       eventarray1.add(event);
	       event= new EventBean();
		}			
		Database.freeConnection(conn);
		return eventarray1;	 
	}
	
	/**This function select the event from the existing database
	 */
	public  ArrayList<EventBean> selectevent() throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
	    ArrayList<EventBean>houseevent= new ArrayList<EventBean>();
		EventBean event= new EventBean();
    	String query= "select * from Event_Master_Table where Group_Individual= 0";
    	Connection conn= Database.getConnection();
    	Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{
			event.setEventid(rs.getInt(("Event_Id")));
			event.setEventname(rs.getString(("Event_Name")));
			event.setGroup_individual(rs.getInt("Group_Individual"));
			event.setSports_cultural_athletic(rs.getInt("Sports_Cultural_Athletic"));
			houseevent.add(event);
			event= new EventBean();
		}	
		Database.freeConnection(conn);
		return houseevent;
	}
}