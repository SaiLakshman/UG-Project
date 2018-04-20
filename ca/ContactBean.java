package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactBean
{
	private String relation;
	private String contactNo;
	
	/**This is a default constructor*/
	public ContactBean()
	{
		relation= "";
		contactNo= "";
	}

	/**This is a multiple argument constructor*/
	public ContactBean(String relation, String contactNo)
	{
		this.relation = relation;
		this.contactNo = contactNo;
	}
	
	/**This is a Getter method for getting relation of the Students*/
	public String getRelation()
	{
		return relation;
	}
	
	/**This is a Setter method for setting relation of the Students*/
	public void setRelation(String relation)
	{
		this.relation = relation;
	}
	
	/**This is a Getter method for getting contact no. of the Students*/
	public String getContactNo()
	{
		return contactNo;
	}
	
	/**This is a Setter method for setting contact no. of the Students*/
	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

	/**
	 * This mthod is an static method which returns the array of contact nos and relation
	 * */
	public static ContactBean[] insertContact(HttpServletRequest req,PrintWriter out)
	{
		ContactBean[] contacts= new ContactBean[5];
		String[] str= req.getParameterValues("relation");
		String[] str1= req.getParameterValues("contactno");
		ContactBean con= new ContactBean();
		for(int i= 0; i < str.length;i++)
		{
			if(!str.equals(""))
			{
				con.setRelation(str[i]);
				con.setContactNo(str1[i]);
				contacts[i]= con;
				if(str[i].equals(""))
				{
					con.setRelation("Not Entered");
					con.setContactNo("Not Entered");
					contacts[i]= con;
				}
				con= new ContactBean();
			}
		}
		return contacts;
	}
}