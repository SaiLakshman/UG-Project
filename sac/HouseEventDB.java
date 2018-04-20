package bca.batch2011.project1.sac;
import java.io.*;
import java.sql.*;
import java.util.*;
//the following class is to retrieve some data from database//
public class HouseEventDB 
{
    //this function is to get data from database and captures these values in ArrayList object of this class//
	public  ArrayList<HouseBean> select() throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs= null;
		ArrayList<HouseBean>housearray= new ArrayList<HouseBean>();
		HouseBean house= new HouseBean();
		String query="select * from House_Event_Table";
	    Connection conn= Database.getConnection();
	    Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{
		    house.setEventid(rs.getInt(("Event_Id")));
			house.setHouseid(rs.getInt(("House_Id")));
			house.setPositionid(rs.getInt(("Position_Id")));
			house.setYear(rs.getInt("Year"));
			housearray.add(house);
			house= new HouseBean();
		}
		Database.freeConnection(conn);
		return housearray;
	}
	//this function is to get data from the database and captures these values in ArrayList object of this class//
	public  ArrayList<HouseBean> selecthouse() throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs= null;
		ArrayList<HouseBean>housearray= new ArrayList<HouseBean>();
		HouseBean house= new HouseBean();
		String query="select * from House_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt=conn.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{		
			house.setHouseid(rs.getInt(("House_Id")));
			house.setHouseName(rs.getString(("House_Name")));
			housearray.add(house);
			house= new HouseBean();
		}
		Database.freeConnection(conn);
		return housearray;
	}
	
	/**This is function for House_Event_Table*/
	// this function is to insert the data into House event table in the database//	
	public void insert(HouseBean housebean)throws SQLException,ClassNotFoundException, IOException
	{
		PreparedStatement ps=null;
		String query="insert into House_Event_Table(House_Id,Event_Id,Year,Position_Id)values(?,?,?,?);";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1,housebean.getHouseid());
		ps.setInt(2,housebean.getEventid());
		ps.setInt(3,housebean.getYear());
		ps.setInt(4,housebean.getPositionid());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	// this function is to get the data from the database and captures the values in ArrayList object of this class//
	public  ArrayList<HouseBean> printnames(HouseBean house) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<HouseBean>housearray= new ArrayList<HouseBean>();
		String query="select a.House_Id,a.House_Name,b.Event_Id,b.Event_Name,c.Position_Id,c.Position_Title,d.Year from House_Master_Table a,Event_Master_Table b,"
			 		+ "Position_Master_Table c,House_Event_Table d where d.House_Id= a.House_Id && d.Event_Id= b.Event_Id"
					 + " && d.Position_Id= c.Position_Id && Year= ? order by Event_Id,House_Id asc;";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query);
		ps.setInt(1,house.getYear());
		rs= ps.executeQuery();
		while(rs.next())
		{
			house.setYear(rs.getInt("Year"));
			house.setHouseid(rs.getInt(("House_Id")));
			house.setHouseName(rs.getString(("House_Name")));
			house.setEventid(rs.getInt("Event_Id"));
			house.setEventname(rs.getString("Event_Name"));
			house.setPositionid(rs.getInt("Position_Id"));
			house.setPositionname(rs.getString("Position_Title"));
			housearray.add(house);
			house= new HouseBean();
		}
		Database.freeConnection(conn);
		return housearray;
	}
	// this function is to modify the data of house event table  in the database//
	public HouseBean modifyhouse(HouseBean house) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		PreparedStatement ps= null;
		String query= "select  * from House_Event_Table where Year= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1, house.getYear());
		rs= ps.executeQuery();
		rs.next();
		house.setYear(rs.getInt("Year"));
		house.setHouseid(rs.getInt(("House_Id")));
		house.setHouseName(rs.getString(("House_Name")));
		house.setEventid(rs.getInt("Event_Id"));
		house.setEventname(rs.getString("Event_Name"));
		house.setPositionid(rs.getInt("Position_Id"));
		house.setPositionname(rs.getString("Position_Title"));
		Database.freeConnection(conn);
		return house;
	}
	// this function is to delete the data from House event table from the database//	
	public void delete(HouseBean house)throws SQLException,ClassNotFoundException, IOException
	{
		 PreparedStatement ps=null;
		 String query="delete from House_Event_Table where Year= ?;";
		 Connection conn= Database.getConnection();
		 ps=conn.prepareStatement(query);
		 ps.setInt(1,house.getYear());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	public boolean isexists(HouseBean house,ArrayList<HouseBean>housearray)throws SQLException
	{
		for(int i= 0;i< housearray.size();i++)
		{
			if(house.getYear() == housearray.get(i).getYear())
		   	  return true;
		}
		return false;
	}
}