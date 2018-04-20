package bca.batch2011.project1.ht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import bca.batch2011.project1.ha.Database;
import bca.batch2011.project1.ha.Fees_Type;

public class Fees_AmountDB
{
	/** This function  takes the bean class Fees_AmountBean,printwriter as an argument. According to that particular year and semester it gets the data from the 		database.
	* This function returns an arraylist of bean class
	*/
	public ArrayList<Fees_AmountBean> selectbyId(Fees_AmountBean fee,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Connection conn= Database.getConnection();
		ArrayList<Fees_AmountBean> feesBean= new ArrayList<Fees_AmountBean>();
		Fees_AmountBean fees= new Fees_AmountBean();
		String com= "select a.Fees_Id Fees_Id,a.Fees_Name Fees_Name,b.Amount Amount,b.Year Year"
				  + ",b.Semester Semester from Fees_Type_Master_Table a,Fees_Amount_Table b "
				  + "where a.Fees_Id= b.Fees_Id and b.Year= ? and b.Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, fee.getYear());
		ps.setInt(2, fee.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			fees.setFees_Id(rs.getInt("Fees_Id"));
			fees.setFeestype(rs.getString("Fees_Name"));
			fees.setAmount(rs.getInt("Amount"));
			fees.setYear(rs.getInt("Year"));
			fees.setSemester(rs.getInt("Semester"));
			feesBean.add(fees);
			fees= new Fees_AmountBean();
		}
		Database.freeConnection(conn);
		return feesBean;
	}
	/** This function  takes the bean class Fees_AmountBean,arraylist of Fees_AmountBean,printwriter as an arguments. It checks weather that particular data is present in database or not accordingly it returns the boolean value if it is present it returns false if it is not it returns true.*/
	public boolean checkIfExists(Fees_AmountBean feesBean,ArrayList<Fees_AmountBean> fees,PrintWriter out)
	{
		for(int i= 0;i < fees.size();i++)
		{
			if(feesBean.getFees_Id() == fees.get(i).getFees_Id())
				if(feesBean.getYear() == fees.get(i).getYear())
					if(feesBean.getSemester() == fees.get(i).getSemester())
						return false;
		}
		return true;
	}
	/** This function  takes the bean class and an arraylist,printwriter as an arguments. It checks weather that particular data is present in database or not accordingly it returns the boolean value if it is present it returns false if it is not it returns true.*/
	public boolean checkExists(Fees_AmountBean feesBean,ArrayList<Fees_AmountBean> fees,PrintWriter out)
	{
		for(int i= 0;i < fees.size();i++)
		{
				if(feesBean.getYear() == fees.get(i).getYear())
					if(feesBean.getSemester() == fees.get(i).getSemester())
						return false;
		}
		return true;
	}
	/** This function does not take any arguments. It helps in getting all the values from database.It returns an arraylist of feestype.*/
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
	/** This function takes int x,int y as arguments. It helps in getting all the values from database for that particular year and semester.It returns an arraylist of feesamountbean.*/
	public ArrayList<Fees_AmountBean> selectExisting(int year,int sem) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		ArrayList<Fees_AmountBean> beanArray= new ArrayList<Fees_AmountBean>();
		Fees_AmountBean feeBean= new Fees_AmountBean();
		String com= "select * from Fees_Amount_Table where Year= ? and Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1,year);
		ps.setInt(2,sem);
		rs= ps.executeQuery();
		while(rs.next())
		{
			feeBean.setFees_Id(rs.getInt("Fees_Id"));
			feeBean.setAmount(rs.getInt("Amount"));
			feeBean.setYear(rs.getInt("Year"));
			feeBean.setSemester(rs.getInt("Semester"));
			beanArray.add(feeBean);
			feeBean= new Fees_AmountBean();
		}
		Database.freeConnection(conn);
		return beanArray;
	}
	/** This function takes bean object of fessamountbean,printwriter as argument. It helps in inserting values in to database.It does not return any values.*/
	public void insert(Fees_AmountBean fee,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "insert into Fees_Amount_Table(Fees_Id,Amount,Year,Semester) values (?,?,?,?);";
		ps= conn.prepareStatement(com);
		ps.setInt(1, fee.getFees_Id());
		ps.setInt(2, fee.getAmount());
		ps.setInt(3, fee.getYear());
		ps.setInt(4, fee.getSemester());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/** This function takes bean object of fessamountbean and arraylist of fessamountbean,printwriter as arguments. It helps in inserting values in to database.It does not return any values.*/
	public void copyinsert(Fees_AmountBean fee,ArrayList<Fees_AmountBean> fees,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0;i < fees.size();i++)
		{
				String com= "insert into Fees_Amount_Table(Fees_Id,Amount,Year,Semester) values (?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, fees.get(i).getFees_Id());
				ps.setInt(2, fees.get(i).getAmount());
				ps.setInt(3, fee.getYear());
				ps.setInt(4, fee.getSemester());
				ps.executeUpdate();
		}
		Database.freeConnection(conn);
	}
	/** This function takes String[],String[],bean object of fessamountbean,printwriter as arguments. It helps in inserting values in to database.It does not return any values.*/
	public void modupdate(String[] fees,String[] amt, Fees_AmountBean fee,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0; i< fees.length;i++)
		{
			if(fees[i] != "" && amt[i] != "")
			{
				String com= "insert into Fees_Amount_Table(Fees_Id,Amount,Year,Semester) values (?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setString(1, fees[i]);
				ps.setString(2, amt[i]);
				ps.setInt(3, fee.getYear());
				ps.setInt(4, fee.getSemester());
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	/** This function takes int x,int y,printwriter as argument. It helps in deleting values in to database.It does not return any values.*/
	public void delete(int year,int sem,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "Delete from Fees_Amount_Table where Year= ? and Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, year);
		ps.setInt(2, sem);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
}
