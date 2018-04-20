package bca.batch2011.project1.ha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class SRD_DB
{
	/**
	 * This function insert the data into the database.
	 **/
	public void insert(SRD s) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "insert into SRD_Master_Table(SRD_Name) values (?);";
		ps= conn.prepareStatement(com);
		ps.setString(1,s.getSrd_Name());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 * this function is to get the data from the database and captures these values in ArrayList object of this class
	 * */
	public ArrayList<SRD> select() throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		ArrayList<SRD> srd1= new ArrayList<SRD>();
		SRD srd= new SRD();
		String com= "select * from SRD_Master_Table;";
		Connection conn= null;
		conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(com);
		while(rs.next())
		{
			srd.setSrd_Id(rs.getInt("SRD_Id"));
			srd.setSrd_Name(rs.getString("SRD_Name"));
			srd1.add(srd);
			srd= new SRD();
		}
		Database.freeConnection(conn);
		return srd1;
	}
	/**
	 * this function is to get the data from the database and captures these values in ArrayList object of this class
	 * */
	public SRD selectbyid(String srdId,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs=null;
		SRD srd= new SRD();
		PreparedStatement ps= null;
		String com="select * from SRD_Master_Table where SRD_Id= ?;";
		Connection conn= null;
		conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1, srdId);
		rs= ps.executeQuery();
		while(rs.next())
		{
			srd.setSrd_Id(rs.getInt("SRD_Id"));
			srd.setSrd_Name(rs.getString("SRD_Name"));
		}
		Database.freeConnection(conn);
		return srd;
	}
	
	/**
	 * This function updates the data in the database.
	**/
	public SRD updatesrd(SRD srd,int id) throws IOException,SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps=null;
		String com="update SRD_Master_Table set SRD_Name= ? where SRD_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setString(1,srd.getSrd_Name());
		ps.setInt(2, id);
		ps.executeUpdate();
		Database.freeConnection(conn);
		return srd;
	}
	/**
	 * this function will check whether the particular data is there in the database.
    * */
	public boolean checkIfExist(SRD srd, ArrayList<SRD> s)
	{
		for(int i= 0;i < s.size();i++)
		{
			if(srd.getSrd_Name().trim().equalsIgnoreCase(s.get(i).getSrd_Name()))
				return false;
		}
		return true;
	}
	
    /**
     * This function deletes the data from the database.
    **/
	public void deletesrd(String srdId,PrintWriter out) throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		String com= "Delete from SRD_Master_Table where SRD_Id in ("+srdId+");";
		Statement stmt=null;
		stmt= conn.createStatement();
		stmt.executeUpdate(com);
		Database.freeConnection(conn);
	}
}