package bca.batch2011.project1.ca;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;

public class Event 
{
	private int event_id;
	String event_name="";
	
	/**
	 * Default constructor for initializin the member variables
	 * */
	public Event()
	{
		event_id= 0;
		event_name="";
	}
	
	/**
	 * Multiple argument constructor
	 * */
	public Event(String event_name,int event_id)
	{
		this.event_id = event_id;
		this.event_name = event_name;
	}
	
	/**
	 * Getter-Setter method for member variables
	 * */
	public Event(String event_name)
	{
		this.event_name = event_name;
	}

	public int getEvent_id() 
	{
		return event_id;
	}
	public void setEvent_id(int event_id) 
	{
		this.event_id = event_id;
	}
	public void deleteEvent_id(int event_id) 
	{
		this.event_id = event_id;
	}
	public String getEvent_name() 
	{
		return event_name;
	}
	public void setEvent_name(String event_name) 
	{
		this.event_name = event_name;
	}
	
	/**
	 * This method is static and its return type is void.
	 * It gets the Event name from the jsp
	 * */
	public static void fillEvent(Event e,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{	
		e.setEvent_name(req.getParameter("eventName"));
		return;
	}
	
	/**
	 * This method uses the getter-setter method and calls the database methods
	 * */
	public static void insertEvent(Event event,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		AttendenceDB insertevent= new AttendenceDB();
		ArrayList<Event> eventArray= new ArrayList<Event>();
		fillEvent(event, req);
		eventArray= insertevent.select();
		boolean isAbsent= insertevent.check(event,eventArray);
		if(isAbsent == true)
			insertevent.insert(event);
		return;
	}
	
	/**
	 * This function calls the database method for modification
	 * */
	public static void updateEvent(Event event,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		fillEvent(event, req);
		AttendenceDB update= new AttendenceDB();
		int eventId= Integer.parseInt(req.getParameter("EventId"));
		event.setEvent_id(eventId);
		update.modify(event);
		return;
	}
	
	/**
	 * This method captures all the Id's inorder to delete from the database
	 * */
	public static void deleteEvent(HttpServletResponse res,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		PrintWriter out= res.getWriter();
		AttendenceDB delEvent= new AttendenceDB();
		String[] str= req.getParameterValues("deleteBox");
		String eventIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					eventIds= eventIds.concat(str[i]);
				else
					eventIds= eventIds.concat(str[i]+",");
			}
		}
		delEvent.delete(eventIds);
		return;
	}
}