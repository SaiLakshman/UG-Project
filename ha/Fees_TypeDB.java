package bca.batch2011.project1.ha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class Fees_TypeDB
{
	/**
	* This function insert the data into database
	* */
	public void insert(Fees_Type fee) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "insert into Fees_Type_Master_Table(Fees_Name) values (?);";
		ps= conn.prepareStatement(com);
		ps.setString(1,fee.getfees_Name());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
         * this function is to get the data from the database and captures these values in ArrayList
         *  object of this class
        * */
	public ArrayList<Fees_Type> select() throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		ArrayList<Fees_Type> fees1= new ArrayList<Fees_Type>();
		Fees_Type fees= new Fees_Type();
		String com= "select * from Fees_Type_Master_Table;";
		Connection conn= null;
		conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(com);
		while(rs.next())
		{
			fees.setfees_Id(rs.getInt("Fees_Id"));
			fees.setfees_Name(rs.getString("Fees_Name"));
			fees1.add(fees);
			fees= new Fees_Type();
		}
		Database.freeConnection(conn);
		return fees1;
	}
	/**
         * this function is to get the ArrayList of feesIds from the database and captures
         *  these values in the ArrayList object of this class
         * */ 
	public Fees_Type selectbyid(String feesId,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs=null;
		Fees_Type fee= new Fees_Type();
		PreparedStatement ps= null;
		String com="select * from Fees_Type_Master_Table where Fees_Id= ?;";
		Connection conn= null;
		conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1, feesId);
		rs= ps.executeQuery();
		while(rs.next())
		{
			fee.setfees_Id(rs.getInt("Fees_Id"));
			fee.setfees_Name(rs.getString("Fees_Name"));
		}
		Database.freeConnection(conn);
		return fee;
	}
	/**
         * this function update the data in the database.
        * */
	public Fees_Type updatefees(Fees_Type fee,int id) throws IOException,SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps=null;
		String com="update Fees_Type_Master_Table set Fees_Name= ? where Fees_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setString(1,fee.getfees_Name());
		ps.setInt(2, id);
		ps.executeUpdate();
		Database.freeConnection(conn);
		return fee;
	}
	/**
         * this function will check whether the particular data is there in the database.
         * */
	public boolean checkIfExist(Fees_Type fees, ArrayList<Fees_Type> fee)
	{
		for(int i= 0;i < fee.size();i++)
		{
			if(fees.getfees_Name().trim().equalsIgnoreCase(fee.get(i).getfees_Name()))
				return false;
		}
		return true;
	}
	/**
         * this function delete the data from the database
         * */
	public void deletefees(String feeId,PrintWriter out) throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		String com= "Delete from Fees_Type_Master_Table where Fees_Id in ("+feeId+");";
		Statement stmt=null;
		stmt= conn.createStatement();
		stmt.executeUpdate(com);
		Database.freeConnection(conn);
	}
}
