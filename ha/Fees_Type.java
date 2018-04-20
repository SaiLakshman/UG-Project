package bca.batch2011.project1.ha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Fees_Type 
{
	private int fees_Id;
	private String feesName;
	/**This is the Default Constructor*/
	public Fees_Type()
	{
		fees_Id= 0;
		feesName= "";
	}
	/**This is the two Argument Constructor*/
	public Fees_Type(int fees_Id, String feesName)
	{
		this.fees_Id = fees_Id;
		this.feesName = feesName;
	}
	/**This will get the Self_Reliance_Department's ID*/
	public int getfees_Id()
	{
		return fees_Id;
	}
	/**This will set the Self_Reliance_Department's ID*/
	public void setfees_Id(int fees_Id)
	{
		this.fees_Id = fees_Id;
	}
	/**This will get the Self_Reliance_Department's Name*/
	public String getfees_Name()
	{
		return feesName;
	}
	/**This will set the Self_Reliance_Department's Name*/
	public void setfees_Name(String feesName)
	{
		this.feesName = feesName;
	}
	public static void fillfees(Fees_Type fee,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{	
		fee.setfees_Name(req.getParameter("feesName"));
		return;
	}
	/** 
	 *  This function insert the data into the database
	**/
	public static void insertfees(Fees_Type fees,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		Fees_TypeDB insertfees= new Fees_TypeDB();
		ArrayList<Fees_Type> feesArray= new ArrayList<Fees_Type>();
		fillfees(fees, req);
		feesArray= insertfees.select();
		boolean isAbsent= insertfees.checkIfExist(fees,feesArray);
		if(isAbsent == true)
			insertfees.insert(fees);
		return;
	}
	/** 
	 * This function updates the data in database
	 **/
	public static void updatefees(Fees_Type fees,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		fillfees(fees, req);
		Fees_TypeDB update= new Fees_TypeDB();
		int feesId= Integer.parseInt(req.getParameter("feesId"));
		fees.setfees_Id(feesId);
		update.updatefees(fees,feesId);
		return;
	}
	/**
	 * This function deletes the data from the Database
	**/
	public static void deletefees(HttpServletResponse res,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		PrintWriter out= res.getWriter();
		Fees_TypeDB delfees= new Fees_TypeDB();
		String[] str= req.getParameterValues("deleteBox");
		String feesIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					feesIds= feesIds.concat(str[i]);
				else
					feesIds= feesIds.concat(str[i]+",");
			}
		}
		delfees.deletefees(feesIds,out);
		return;
	}
}