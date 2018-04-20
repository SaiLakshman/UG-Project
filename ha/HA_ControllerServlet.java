package bca.batch2011.project1.ha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HA_ControllerServlet extends HttpServlet
{
	/**This is the function for Self-Reliance-Department Module*/
   	public void SRDservice(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter out= res.getWriter();
		SRD_DB ins= new SRD_DB();
		ArrayList<SRD> show= new ArrayList<SRD>();
		String access= req.getParameter("access");
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					show= ins.select();
				}
				catch(SQLException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch(ClassNotFoundException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListSRDs.jsp").forward(req, res);
				return;
			}
			
			/**If new Self Reliance Dept. is to be added*/
			if(access.equalsIgnoreCase("Add New SRD"))
			{
				req.getRequestDispatcher("/AddSRD.jsp").forward(req, res);
				return;
			}
			
			/**For inserting into database*/
			if(access.equalsIgnoreCase("insertsrd"))
			{
				SRD srd= new SRD();
				try
				{
					srd.insertSRD(srd, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListSRDs.jsp").forward(req, res);
				return;
			}
			
			/**For Modifying the SRD*/
			if(access.equalsIgnoreCase("modifysrd"))
			{
				String srdId= req.getParameter("srdId");
				SRD update= new SRD();
				if(srdId != null)
				{
					try
					{
						update= ins.selectbyid(srdId,out);
					}
					catch (SQLException e)
					{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (ClassNotFoundException e)
					{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				req.setAttribute("modify", update);
				req.getRequestDispatcher("/ModifySRD.jsp").forward(req, res);
				return;
			}
			
			/**It will update the database*/
			if(access.equalsIgnoreCase("updatesrd"))
			{
				SRD srd= new SRD();
				try
				{
					srd.updateSRD(srd, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListSRDs.jsp").forward(req, res);
				return;
			}
			
			/**It will delete the Room*/
			if(access.equalsIgnoreCase("deletesrd"))
			{
				SRD del= new SRD();
				try
				{
					del.deleteSRD(res, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListSRDs.jsp").forward(req, res);
				return;
			}
		}
	}
		
	/**This is the function for Room Module*/
    public void Roomservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out= res.getWriter();
		RoomDB ins= new RoomDB();
		ArrayList<Room> show= new ArrayList<Room>();
		String access= req.getParameter("access");
		if(access == null)
			access= "Frames";
		if(access.equalsIgnoreCase("Frames"))
		{
			try
			{
				show= ins.select();
			}
			catch(SQLException e)
			{
				req.setAttribute("exc", e.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
			catch(ClassNotFoundException e)
			{
				req.setAttribute("exc", e.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
			req.setAttribute("show", show);
			req.getRequestDispatcher("/ListRooms.jsp").forward(req, res);
			return;
		}
			
		/**If new Room is to be added*/
		if(access.equalsIgnoreCase("Add New Room"))
		{
			req.getRequestDispatcher("/AddRoom.jsp").forward(req, res);
			return;
		}
		
		/**For inserting into database*/
		if(access.equalsIgnoreCase("insertroom"))
		{
			Room room= new Room();
			try
			{
				room.insertRoom(room, req);
				show= ins.select();
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
			req.setAttribute("show", show);
			req.getRequestDispatcher("/ListRooms.jsp").forward(req, res);
			return;
		}
		
		/**For Modifying the room*/
		if(access.equalsIgnoreCase("modifyroom"))
		{
			String roomId= req.getParameter("roomId");
			Room update= new Room();
			if(roomId != null)
			{
				try
				{
					update= ins.selectbyid(roomId,out);
				}
				catch (SQLException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (ClassNotFoundException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
			}
			req.setAttribute("modify", update);
			req.getRequestDispatcher("/ModifyRoom.jsp").forward(req, res);
			return;
		}
		
		/**It will update the database*/
		if(access.equalsIgnoreCase("updateroom"))
		{
			Room room= new Room();
			try
			{
				room.updateRoom(room, req);
				show= ins.select();
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
			req.setAttribute("show", show);
			req.getRequestDispatcher("/ListRooms.jsp").forward(req, res);
			return;
		}
		
		/**It will delete the Room*/
		if(access.equalsIgnoreCase("deleteroom"))
		{
			Room del= new Room();
			try
			{
				del.deleteRoom(res,req);
				show= ins.select();
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
			req.setAttribute("show", show);
			req.getRequestDispatcher("/ListRooms.jsp").forward(req, res);
			return;
		}
	}
	
    /**This module is to Configure Fees_Type*/
	public void Feeservice(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		PrintWriter out= res.getWriter();
		Fees_TypeDB ins= new Fees_TypeDB();
		ArrayList<Fees_Type> show= new ArrayList<Fees_Type>();
		String access= req.getParameter("access");
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					show= ins.select();
				}
				catch(SQLException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch(ClassNotFoundException e)
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListFeesType.jsp").forward(req, res);
				return;
			}
	
			/**If new Fees_Type is to be added*/
			if(access.equalsIgnoreCase("Add New Fees"))
			{
				req.getRequestDispatcher("/AddFeesType.jsp").forward(req, res);
				return;
			}
		
			/**For inserting into database*/
			if(access.equalsIgnoreCase("insertfeestype"))
			{
				Fees_Type fees= new Fees_Type();
				try
				{
					fees.insertfees(fees, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListFeesType.jsp").forward(req, res);
				return;
			}
	
			/**For Modifying the Fees_Type*/
			if(access.equalsIgnoreCase("modifyfeestype"))
			{
				String feesId= req.getParameter("feesId");
				Fees_Type update= new Fees_Type();
				if(feesId != null)
				{
					try
					{
						update= ins.selectbyid(feesId,out);
					}
					catch (SQLException e)
					{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (ClassNotFoundException e)
					{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				req.setAttribute("modify", update);
				req.getRequestDispatcher("/ModifyFeesType.jsp").forward(req, res);
				return;
			}
	
			/**It will update the database*/
			if(access.equalsIgnoreCase("updatefeestype"))
			{
				Fees_Type fees= new Fees_Type();
				try
				{
					fees.updatefees(fees, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListFeesType.jsp").forward(req, res);
				return;
			}
	
			/**It will delete the Fees_Type*/
			if(access.equalsIgnoreCase("deletefeestype"))
			{
				Fees_Type del= new Fees_Type();
				try
				{
					del.deletefees(res, req);
					show= ins.select();
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
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListFeesType.jsp").forward(req, res);
				return;
			}
		}
	}
	
	/**This is the function for Frame Module*/
	public void Frameservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/hosteladmin.html").forward(req, res);
		return;
	}

	/**This is the Servlet doPost*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{	
		String module= req.getParameter("module");
		if(module == null)
			module= "Frames";
		if(module.equalsIgnoreCase("srd"))
			SRDservice(req, res);
		if(module.equalsIgnoreCase("rooms"))
			Roomservice(req, res);
		if(module.equalsIgnoreCase("fees"))
			Feeservice(req, res);
		if(module.equalsIgnoreCase("frames"))
			Frameservice(req, res);
	}
	
	/**This is the Servlet doGet*/
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}
}
