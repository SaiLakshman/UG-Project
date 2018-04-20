package bca.batch2011.project1.sac;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import bca.batch2011.project1.ca.Course;
import bca.batch2011.project1.ca.Student;

public class SAC_ControllerServlet extends HttpServlet{
	   /**
	     * this is the beginning of the House module
	     */
	    public void houseService(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	    {
		    PrintWriter out= res.getWriter();
		    HouseBean house= new HouseBean();//here system creats an object of House bean class//
		    HouseDB housedb= new HouseDB();
		    /**
		     * here system creating a object of array which will contain the housenames,
		     * with help of this object iam getting housenames from database
		     */
		    ArrayList<HouseBean> housearray= new ArrayList<HouseBean>();
		    String url= null;
		    String access= req.getParameter("access");
		    boolean list= false; 
		    if(access == null)
		    	access= "Frames";
		    if(access != null)
		    {	    	  
		   	   if(access.equalsIgnoreCase("Frames"))
	           {
		    		   list= true;
	           }  
	    	   if(access.equalsIgnoreCase("cancel"))
	    		   list=true;
	    	   else if(access.equals("addhouse"))
	    	   {
		    	  url= "/SACAddHouse.jsp";
	    	   }
		   	   /**this function is to insert the data of the house into the database*/
	    	   if(access.equals("insert"))
		   	   {
		    	  house.setHouseName(req.getParameter("name"));
		   		  try
		   		  {
					housedb.insert(house);
		   		  }
		   		  catch (ClassNotFoundException e)
		   		  {
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
		   		  }
		   		  catch (SQLException e)
		   		  {
		   			req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
		   		  }
		   		  list= true;
		   	   }
	    	   /** this function is to modify the contents of house in the database*/
	           if(access.equalsIgnoreCase("modify"))
	           {
		           house.setHouseid(Integer.parseInt(req.getParameter("House_id")));
		           try
		           {
		        	   housedb.modify(house);
		           }
		           catch (ClassNotFoundException e)
		           {
		        	   req.setAttribute("exc", e.getMessage());
		        	   req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
		        	   return;
		           }
		           catch (SQLException e)
		           {
		        	   req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
		           }
		    	   url= "/SACModifyHouse.jsp";
		           req.setAttribute("housedetails", house);
		       }
	           /**this function is to update the contents of house in the database*/
	           if(access.equalsIgnoreCase("update"))
	           {
		         	 house.setHouseName(req.getParameter("name"));
				     house.setHouseid(Integer.parseInt(req.getParameter("House_id"))); 
	        	     try
	        	     {
	        	    	out.println("SAIRAM"+house.getHouseName() + house.getHouseid());
						housedb.update(house);
	        	     }
	        	     catch (ClassNotFoundException e)
	        	     {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
	        	     }
	        	     catch (SQLException e)
	        	     {
	        	    	req.setAttribute("exc", e.getMessage());
	 					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
	 					return;
	        	     }
	        	     list= true;
		       }
	           /** this function is to delete the data in the database*/
               if(access.equals("delete"))
               {
            	   String[] hids= req.getParameterValues("hids");
			       String hidstr= "";
		           if(hids != null)
    	           {
			       	   hidstr= hids[0];
			     	   for(int k= 1;k < hids.length;k++)
			                hidstr+= "," + hids[k];
		    		   try
		    		   {
		    			   housedb.delete(hidstr);
		    		   }
		    		   catch (ClassNotFoundException e)
		    		   {
		    			   req.setAttribute("exc", e.getMessage());
		    			   req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
		    			   return;
		    		   } 
		    		   catch (SQLException e)
		    		   {
		    			   req.setAttribute("exc", e.getMessage());
		    			   req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
		    			   return;
		    		   } 
    	           }
			     	list= true;
		       }     
		       if(list)
		       {
		       	  try
		       	  {
					housearray= housedb.select();
		       	  }
		       	  catch (ClassNotFoundException e)
		       	  {
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
		       	  }
		       	  catch (SQLException e)
		       	  {
		       		req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
		       	  }
		          url= "/SACListHouses.jsp";
		          req.setAttribute("houselist", housearray);
	           }
               RequestDispatcher dispatcher= req.getRequestDispatcher(url);
               dispatcher.forward(req, res);
		     }
		   }
	    /**
	     * this is the beginning of the Event module
	     */
         public void eventService(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	     {
        	 PrintWriter out= res.getWriter();
        	 EventBean event= new EventBean();//here iam creating a object of Event bean class//
			 EventDB eventdb= new EventDB();      
			 ArrayList<EventBean> eventarray1= new ArrayList<EventBean>(); 
			 String url= null;
			 String access= req.getParameter("access");
			 boolean list= false;
		     if(access == null)
		    	 access= "Frames";
		     if(access != null)
		     {
			    if(access.equalsIgnoreCase("Frames"))
		        {
			    	list= true;
			    }
		        if(access.equalsIgnoreCase("cancel"))
		    	{
		  		   list= true;
			    }	
			    else if(access.equals("addevent"))
			    		url= "/SACAddEvent.jsp";
		        // this function is to insert the data of events into the database//
			    if(access.equals("insertevent"))
			    {   
			    	int value= Integer.parseInt(req.getParameter("group_individual_id"));
			    	event.setEventname(req.getParameter("name"));
			    	event.setGroup_individual(value);
			    	event.setSports_cultural_athletic(Integer.parseInt(req.getParameter("sports_id")));
			    	try
			    	{
						eventdb.insert(event);
					}
			    	catch (ClassNotFoundException e)
			    	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
			    	catch (SQLException e)
			    	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
			    	list= true;	 
			     }
			     // this function is to modify the contents of the events in the database//
			     if(access.equals("modify1"))
			     {
			        event.setEventid(Integer.parseInt(req.getParameter("Event_id")));
			        try
			        {
						eventdb.modify(event);
					}
			        catch (ClassNotFoundException e)
			        {
			        	req.setAttribute("exc", e.getMessage());
			        	req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
			        	return;
					}
			        catch (SQLException e)
			        {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
			        url= "/SACModifyEvent.jsp";
			        req.setAttribute("eventdetails", event);
			     }
			     // this function is to update the contents of the events in the database//
			     if(access.equals("update"))
			     {
			        event.setEventname(req.getParameter("name"));
			        event.setEventid(Integer.parseInt(req.getParameter("event_id")));
			        event.setGroup_individual(Integer.parseInt(req.getParameter("group_individual_id")));
			        event.setSports_cultural_athletic(Integer.parseInt(req.getParameter("sports_id")));
			        try
			        {
						eventdb.update(event);
					}
			        catch (ClassNotFoundException e)
			        {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
			        catch (SQLException e)
			        {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
			        list= true;
			      }
			      /** this function is to delete the contents of the events in the database*/ 
			      if(access.equals("deleted"))
		          {
		        	 String[] eids= req.getParameterValues("eids");
		        	 String eidstr= "";
		        	 if(eids != null)
		        	 {
		        		 eidstr= eids[0];
		        		 for(int k= 1;k < eids.length;k++)
		                         eidstr+= "," + eids[k];
	 	        	     try
	 	        	     {
							eventdb.delete(eidstr);
	 	        	     }
	 	        	     catch (ClassNotFoundException e)
	 	        	     {
							req.setAttribute("exc", e.getMessage());
							req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
							return;
	 	        	     }
	 	        	     catch (SQLException e)
	 	        	     {
	 	        	    	 req.setAttribute("exc", e.getMessage());
	 	        	    	 req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
	 	        	    	 return;
	 	        	     } 
		        	 }
		        	 list= true;
		           }     
			       if(list)
			       {
			         try
			         {
						eventarray1= eventdb.select();
			         }
			         catch (ClassNotFoundException e)
			         {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
			         }
			         catch (SQLException e)
			         {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
			         }
			         url= "/SACListEvents.jsp";
				     req.setAttribute("eventlist", eventarray1);
			       }
	               RequestDispatcher dispatcher= req.getRequestDispatcher(url);
			       dispatcher.forward(req, res);
			   }
	     } // end of Event module
         /**
 	     * this is the beginning of the Position module
 	     */
         public void positionService(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	     {
        	 PrintWriter out= res.getWriter();
        	 PositionBean position= new PositionBean();//here iam creating a object of position bean class//
			 PositionDB positiondb= new PositionDB();      
			 ArrayList<PositionBean> positionarray1= new ArrayList<PositionBean>(); 
			 String url= null;
			 String access= req.getParameter("access");
			 boolean list= false;
		     if(access == null)
		    	 access= "Frames";
		     if(access != null)
		     {
		    	if(access.equalsIgnoreCase("Frames"))
		    	{
		    		list= true;
		    	}
		    	if(access.equalsIgnoreCase("cancel"))
		    		list= true;
		    	else if(access.equals("addposition"))
		    	{
		    		url= "/SACAddPosition.jsp";
		    	}
		    	//this function is to insert the details of position into database//
		    	else if(access.equalsIgnoreCase("insertposition"))
		    	{   
		    		position.setPositiontitle(req.getParameter("name"));
		    		position.setPoints(Integer.parseInt(req.getParameter("point")));
		    	    try
		    	    {
						positiondb.insert(position,out);
					}
		    	    catch (ClassNotFoundException e)
		    	    {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		    	    catch (SQLException e)
		    	    {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		    		list= true;	 
		     	}
		    	// this function is to modify the details of position in the database//
		    	else if(access.equals("modify"))
		        {
		        	position.setPositionid(Integer.parseInt(req.getParameter("position_id")));
		        	try
		        	{
						positiondb.modify(position,out);
					}
		        	catch (ClassNotFoundException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
		        	}
		        	catch (SQLException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		        	url= "/SACModifyPosition.jsp";
		        	req.setAttribute("positiondetails", position);
		        }
		    	// this function is to update the contents of the position in the database//
		        if(access.equals("update"))
		        {
		        	position.setPositiontitle(req.getParameter("name"));
		        	position.setPositionid(Integer.parseInt(req.getParameter("position_id")));
		        	position.setPoints(Integer.parseInt(req.getParameter("point")));
		        	try
		        	{
						positiondb.update(position,out);
					}
		        	catch (ClassNotFoundException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		        	catch (SQLException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		        	list= true;
		        }
		        //this function is to delete the contents of the position in the database//
		        if(access.equals("deleted1"))
	            {
	        	   String[] pids= req.getParameterValues("pids");
	        	   String pidstr= "";
	        	   if(pids != null)
	        	   {
	        		   pidstr= pids[0];
	        		   for(int k= 1;k < pids.length;k++)
	                         pidstr+= "," + pids[k];
 	        	       try
 	        	       {
						positiondb.delete(pidstr);
 	        	       }
 	        	       catch (ClassNotFoundException e)
 	        	       {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
 	        	       } 
 	        	       catch (SQLException e)
 	        	       {
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
 	        	       } 
	        	   }
	        	    list= true;
	           }     
		        if(list)
		        {
		        	try 
		        	{
						positionarray1= positiondb.select();
					}
		        	catch (ClassNotFoundException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		        	catch (SQLException e)
		        	{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
		        	url= "/SACListPositions.jsp";
			        req.setAttribute("positionlist", positionarray1);
		        }
                RequestDispatcher dispatcher= req.getRequestDispatcher(url);
		        dispatcher.forward(req, res);
		     }
		  }//end of position module//

         /**
   	     * this is the beginning of the  HouseEventmodule
          * 
   	     */
         public void houseeventService(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     	 {
     		PrintWriter out=res.getWriter();
     		String access= req.getParameter("access");
     		HouseBean housebean= new HouseBean();// here i'am creating a object of HouseBean class//
     		HouseEventDB houseDB1= new HouseEventDB();
     		ArrayList<HouseBean>housearray=new ArrayList<HouseBean>();
     		EventDB eventDB1= new EventDB();
     		ArrayList<EventBean>eventarray= new ArrayList<EventBean>();
     		PositionDB positionDB1= new PositionDB();
     		ArrayList<PositionBean>positionarray= new ArrayList<PositionBean>();
     		boolean check;
     		String url= null;
     		if(access == null)
     			access= "frames";
     		if(access != null)
     		{
     			url="/SACViewPage.jsp";
     			if(access.equalsIgnoreCase("SUBMIT"))
     			{
     				housebean.setYear(Integer.parseInt(req.getParameter("year")));
     				try
     				{
     					housearray= houseDB1.printnames(housebean);//for getting all the values from Database
     					check= houseDB1.isexists(housebean,housearray);
     					if(check)
     					{
     						req.setAttribute("exist", housearray);
     						req.setAttribute("getyear",housebean);
     						url= "/SACExistAllocation1.jsp";
     					}
     					else
     					{
     						eventarray=eventDB1.selectevent();
     						housearray=houseDB1.selecthouse();
     						positionarray=positionDB1.select();
     						req.setAttribute("getyear",housebean);
     						req.setAttribute("notexist",eventarray);
     						req.setAttribute("positions",positionarray);
     						req.setAttribute("housenames",housearray);
     						url= "/SACFreshAllocation1.jsp";
     					}
     				} 
     				catch (ClassNotFoundException e)
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				} 
     				catch (SQLException e)
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			// this function is to insert the data into database//
     			else if(access.equalsIgnoreCase("INSERT"))
     			{
     				int year= Integer.parseInt(req.getParameter("houseyear"));
     				int row= Integer.parseInt(req.getParameter("row"));
     				int column= Integer.parseInt(req.getParameter("column"));
     				String[] eventid= req.getParameterValues("event_id");
     				String[] houseid= req.getParameterValues("house_id");
     				String[][] values= new String[row][column];
     				housebean.setYear(year);
     				int count= 0;
     				try 
     				{
     					 for(int i= 0;i< row;i++)
     					 {
     						housebean.setEventid(Integer.parseInt(eventid[i]));
     						count= 0;
     						for(int k= 0;k< column;k++)
     						{ 	
     								 values[i][k]= req.getParameter("positionnames"+i+k);
     								 if(!(values[i][k].equalsIgnoreCase("-1")))
     								 {
     									 count++;
     									 if(count > 2)
     										 throw new RuntimeException("SELECT ANY 2");
     								 }
     						} 
     						
     					 }
     					 for(int i= 0;i< row;i++)
     					 {
     						housebean.setEventid(Integer.parseInt(eventid[i]));
     						for(int k= 0;k< column;k++)
     						{ 	
     								 housebean.setHouseid(Integer.parseInt(houseid[k]));
     								 values[i][k]= req.getParameter("positionnames"+i+k);
     								 housebean.setPositionid(Integer.parseInt(values[i][k]));
     								 if(!(values[i][k].equalsIgnoreCase("-1")))
     									  if(count <= 2)
     										 houseDB1.insert(housebean);
     						} 
     					 }
     					 count= 0;
     					 housearray= houseDB1.printnames(housebean);
     				} 
     				catch (ClassNotFoundException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				catch (SQLException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				req.setAttribute("exist",housearray);
     				req.setAttribute("getyear",housebean);
     				url= "/SACExistAllocation1.jsp";
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			// this function is to modify the contents in the database//
     			else if(access.equalsIgnoreCase("MODIFY"))
     			{
     				int year= Integer.parseInt(req.getParameter("houseyear"));
     				ArrayList<HouseBean>selectarray= new ArrayList<HouseBean>();
     				ArrayList<PositionBean>selectposition= new ArrayList<PositionBean>();
     				ArrayList<EventBean>selectevent= new ArrayList<EventBean>();
     				housebean.setYear(year);
     				try
     				{
     					selectposition=positionDB1.select();
     					selectevent=eventDB1.selectevent();
     					selectarray=houseDB1.selecthouse();
     					housearray=houseDB1.printnames(housebean);
     				}
     				catch (ClassNotFoundException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				catch (SQLException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				req.setAttribute("events",selectevent);
     				req.setAttribute("selecthouses",selectarray);
     				req.setAttribute("positions" ,selectposition);
     				req.setAttribute("getyear",housebean);
     				req.setAttribute("housearrays",housearray);
     				url="/SACModifyAllocation1.jsp";
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			//this function is to update the contents in the database//
     			else if(access.equalsIgnoreCase("UPDATE"))
     			{
     				int year= Integer.parseInt(req.getParameter("houseyear"));
     				housebean.setYear(year);
     				int row= Integer.parseInt(req.getParameter("row"));
     				int column= Integer.parseInt(req.getParameter("column"));
     				String[] eventid= req.getParameterValues("event_id");
     				String[] houseid= req.getParameterValues("house_id");
     				String[][] values= new String[row][column];
     				int count= 0;
     				try 
     				{
     					houseDB1.delete(housebean);
     					 for(int i= 0;i< row;i++)
     					 {
     						housebean.setEventid(Integer.parseInt(eventid[i]));
     						count= 0;
     						for(int k= 0;k< column;k++)
     						{ 	
     								 values[i][k]= req.getParameter("positionnames"+i+k);
     								 if(!(values[i][k].equalsIgnoreCase("-1")))
     								 {
     									 count++;
     									 if(count > 2)
     										 throw new RuntimeException("SELECT ANY 2");
     								 }
     						} 
     						
     					 }
     					 for(int i= 0;i< row;i++)
     					 {
     						housebean.setEventid(Integer.parseInt(eventid[i]));
     						for(int k= 0;k< column;k++)
     						{ 	
     								 housebean.setHouseid(Integer.parseInt(houseid[k]));
     								 values[i][k]= req.getParameter("positionnames"+i+k);
     								 housebean.setPositionid(Integer.parseInt(values[i][k]));
     								 if(!(values[i][k].equalsIgnoreCase("-1")))
     									  if(count <= 2)
     										 houseDB1.insert(housebean);
     						} 
     					 }
     					 count= 0;
     					 housearray= houseDB1.printnames(housebean);
     				} 
     				catch (ClassNotFoundException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				catch (SQLException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				req.setAttribute("notexist",eventarray);
     				req.setAttribute("positions",positionarray);
     				req.setAttribute("housenames",housearray);
     				req.setAttribute("exist",housearray);
     				req.setAttribute("getyear",housebean);
     				url= "/SACExistAllocation1.jsp";
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			else if(access.equalsIgnoreCase("CANCEL"))
     			{
     				url="/SACViewPage.jsp";
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			else if(access.equalsIgnoreCase("CANCELHOUSE"))
     			{
     				int year= Integer.parseInt(req.getParameter("houseyear"));
     				housebean.setYear(year);
     				try 
     				{
     					housearray=houseDB1.printnames(housebean);
     				}
     				catch (ClassNotFoundException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				catch (SQLException e) 
     				{
     					req.setAttribute("exc", e.getMessage());
     					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
     					return;
     				}
     				req.setAttribute("exist", housearray);
     				req.setAttribute("getyear",housebean);
     				url= "/SACExistAllocation1.jsp";
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     			if(access.equalsIgnoreCase("Frames"))
     			{
     				req.setAttribute("notexist",eventarray);
     				req.getRequestDispatcher(url).forward(req, res);
     				return;
     			}
     		}
     	}
        	 
         	public void Frameservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
         	{
         		req.getRequestDispatcher("/SAC.html").forward(req, res);
         		return;
         	}
     	      // this function is the servlet get method//
             public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
             {
		        	doPost(req,res);
             }
              // this function is the servlet post method//
             public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
             {
		          String module= req.getParameter("module");
		  		  if(module == null)
		  			 module= "frames";
		          if(module.equalsIgnoreCase("house"))
		  			houseService(req, res);
		          if(module.equalsIgnoreCase("event"))
		        	 eventService(req, res);
		          if(module.equalsIgnoreCase("position"))
		             positionService(req,res);
		          if(module.equalsIgnoreCase("houseevent"))
						 houseeventService(req,res);
		          if(module.equalsIgnoreCase("frames"))
		        	 Frameservice(req, res);
             }
}