package bca.batch2011.project1.ha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SRD
{
	private int srd_Id;
	private String srd_Name;
	/**This is the Default Constructor*/
	public SRD()
	{
		srd_Id= 0;
		srd_Name= "";
	}
	/**This is the two Argument Constructor*/
	public SRD(int srd_Id, String srd_Name)
	{
		this.srd_Id = srd_Id;
		this.srd_Name = srd_Name;
	}
	/**This will get the Self_Reliance_Department's ID*/
	public int getSrd_Id()
	{
		return srd_Id;
	}
	/**This will set the Self_Reliance_Department's ID*/
	public void setSrd_Id(int srd_Id)
	{
		this.srd_Id = srd_Id;
	}
	/**This will get the Self_Reliance_Department's Name*/
	public String getSrd_Name()
	{
		return srd_Name;
	}
	/**This will set the Self_Reliance_Department's Name*/
	public void setSrd_Name(String srd_Name)
	{
		this.srd_Name = srd_Name;
	}
	 /** This function will captures the data from the jsps**/
	public static void fillSRD(SRD s,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{	
		s.setSrd_Name(req.getParameter("srdName"));
		return;
	}
	/**
           * This function insert the data into the database.
          **/	
	public static void insertSRD(SRD srd,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		SRD_DB insertSrd= new SRD_DB();
		ArrayList<SRD> srdArray= new ArrayList<SRD>();
		fillSRD(srd, req);
		srdArray= insertSrd.select();
		boolean isAbsent= insertSrd.checkIfExist(srd,srdArray);
		if(isAbsent == true)
			insertSrd.insert(srd);
		return;
	}
	/**
     * This function updates the data into the database.
     **/
	public static void updateSRD(SRD srd,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		fillSRD(srd, req);
		SRD_DB update= new SRD_DB();
		int srdId= Integer.parseInt(req.getParameter("srdId"));
		srd.setSrd_Id(srdId);
		update.updatesrd(srd,srdId);
		return;
	}
	/**
	 * This function deletes the data from the database.
	 **/
	public static void deleteSRD(HttpServletResponse res,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		PrintWriter out= res.getWriter();
		SRD_DB delSrd= new SRD_DB();
		String[] str= req.getParameterValues("deleteBox");
		String srdIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					srdIds= srdIds.concat(str[i]);
				else
					srdIds= srdIds.concat(str[i]+",");
			}
		}
		delSrd.deletesrd(srdIds,out);
		return;
	}
}