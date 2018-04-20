package bca.batch2011.project1.ht;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bca.batch2011.project1.ca.Course;
import bca.batch2011.project1.ca.Student;
import bca.batch2011.project1.ca.StudentDB;
import bca.batch2011.project1.ha.Fees_Type;
import bca.batch2011.project1.ha.Fees_TypeDB;
import bca.batch2011.project1.ha.Room;
import bca.batch2011.project1.ha.RoomDB;

public class HT_ControllerServlet extends HttpServlet
{
	/**This is function for configuring the Students to rooms*/
	public void Roomallocationservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access= req.getParameter("access");
		String url= null; 
		RoomAllocation roomalloc=new RoomAllocation();
		RoomAllocation roomAllocation=new RoomAllocation();
		RoomAllocationDB roomallocDB= new RoomAllocationDB();
		ArrayList<Room> room= new ArrayList<Room>();
		ArrayList<Room> room1= new ArrayList<Room>();
		ArrayList<Student> student= new ArrayList<Student>();
		ArrayList<RoomAllocation> student1= new ArrayList<RoomAllocation>();
		RoomDB roomDB= new RoomDB();
		ArrayList<Course> course= new ArrayList<Course>();
		ArrayList<RoomAllocation> roomallocarray=new ArrayList<RoomAllocation>();
		boolean find;
		if(access!= null)
		{
			if(access.equalsIgnoreCase("Submit"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("year")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				try
				{
					roomallocarray= roomallocDB.select();
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				find= roomallocDB.check(roomalloc,roomallocarray,out);
				if(find == false)
				{
					try 
					{
						ArrayList<ArrayList<RoomAllocation>> BigList= new ArrayList<ArrayList<RoomAllocation>>();
						out.println("sairam"+roomalloc.getYear()+""+roomalloc.getSemester());
						room1= roomDB.selectid(roomalloc,out);
						out.println(room1.size());
						for(int i= 0;i< room1.size();i++)
						{
							out.println(room1.get(i).getRoomNo());
							student1= roomallocDB.selectbyroom(roomalloc,room1.get(i).getRoomNo(),out);
							for (int j = 0; j < student1.size(); j++) {
								out.println(student1.get(j).getName());
							}
							BigList.add(student1);
						}
						req.setAttribute("StList",BigList);
						req.setAttribute("RmList",room1);
					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					req.setAttribute("allocation", roomalloc);
					req.setAttribute("allroom", room1);
					req.setAttribute("roomarray", student1);
					url= "/RoomExistAllocation.jsp";
					req.getRequestDispatcher(url).forward(req, res);
					return;
				}
				else if(find == true)
				{
					req.setAttribute("notexist", roomalloc);
					url= "/RoomNotexistAllocation.jsp";
					req.getRequestDispatcher(url).forward(req, res);
					return;
				}
			}
			if(access.equals("Freshallocation"))
			{
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				try
				{
					room= roomDB.select();
					roomallocarray= RoomAllocationDB.studentcourse(out);
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
					out.println(e);
				}
				req.setAttribute("arraylist", room);
				req.setAttribute("allocation", roomAllocation);
				req.setAttribute("roomalloc", roomallocarray);
				req.getRequestDispatcher("/RoomFreshAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updateallocation"))
			{
				String[] studentname= req.getParameterValues("input");
				String[] roomnos= req.getParameterValues("roomno");
				String[] cupboardnos= req.getParameterValues("cupno");
				String year1= req.getParameter("yearh");
				String semester1= req.getParameter("semesterh");
				int y= Integer.parseInt(year1);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semester1);
				roomAllocation.setSemester(s);
				int[] studentid = new int[studentname.length];
				int[] roomid= new int[roomnos.length];
				
				for(int j=0;j< roomnos.length;j++)
				{
						try {
							roomid[j]= roomallocDB.roomselectid(roomnos[j],out);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
				int i= 0;
				for(int k=0;k< roomnos.length;k++)
				{
					for(int j= 0;j< Integer.parseInt(cupboardnos[k])&& i< studentname.length ;j++)
					{
						String[] split= studentname[i].split(",");
						try
						{
							studentid[i]= roomallocDB.selectid(split[0],out);
							if(studentname[i] != null)
							{
								roomallocDB.insert(studentid[i],roomid[k],roomAllocation,out);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						i++;
					}
				}
				url="/RoomAllocation.jsp";
				req.getRequestDispatcher(url).forward(req, res);
				return;
			}
			if(access.equals("Copyallocation"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("year")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				out.println(y+","+s);
				try 
				{
					ArrayList<ArrayList<RoomAllocation>> BigList= new ArrayList<ArrayList<RoomAllocation>>();
					room1= roomDB.selectid(roomalloc,out);
					
					for(int i= 0;i< room1.size();i++)
					{
						student1= roomallocDB.selectbyroom(roomalloc,room1.get(i).getRoomNo(),out);
						for (int j = 0; j < student1.size(); j++)
						{
							roomallocDB.insert(student1.get(j).getStudentId(),room1.get(i).getRoomId(),roomAllocation,out);
						}
							
						BigList.add(student1);
					}
					req.setAttribute("StList",BigList);
					req.setAttribute("RmList",room1);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				req.setAttribute("allocation", roomAllocation);
				req.getRequestDispatcher("/RoomExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancel"))
			{
				req.setAttribute("allocation", roomAllocation);
				req.getRequestDispatcher("/RoomAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelfresh"))
			{
				String yearh= req.getParameter("yearh");
				String semesterh= req.getParameter("semesterh");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				req.setAttribute("arraylist", roomallocarray);
				req.setAttribute("allocation", roomAllocation);
				req.setAttribute("notexist", roomAllocation);
				req.getRequestDispatcher("/RoomNotexistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelmodify"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("yearh")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semesterh")));
				try
				{
					roomallocarray= roomallocDB.selected(roomalloc,out);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e) 
				{
					out.println("in sql exception"+e);
				}
				req.setAttribute("update", roomallocarray);
				req.setAttribute("allocation", roomalloc);
				req.getRequestDispatcher("/RoomExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Modifyallocation"))
			{
				int year= Integer.parseInt(req.getParameter("year"));
				int semester= Integer.parseInt(req.getParameter("semester"));
				roomAllocation.setYear(year);
				roomAllocation.setSemester(semester);
				try 
				{
					ArrayList<ArrayList<RoomAllocation>> BigList= new ArrayList<ArrayList<RoomAllocation>>();
					
					room1= roomDB.selectid(roomAllocation,out);
					student1= roomallocDB.select(out);
					req.setAttribute("studentarray", student1);
					
					roomallocarray= roomallocDB.selectfromroom(out);
					req.setAttribute("studentroomarray", roomallocarray);
					for(int i= 0;i< room1.size();i++)
					{
						student1= roomallocDB.selectbyroom(roomAllocation,room1.get(i).getRoomNo(),out);
						BigList.add(student1);
					}
					req.setAttribute("StList",BigList);
					req.setAttribute("RmList",room1);
					room= roomDB.select();
					roomallocarray= RoomAllocationDB.studentcourse(out);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				req.setAttribute("arraylist", room);
				req.setAttribute("roomalloc", roomallocarray);
				req.setAttribute("allocation", roomAllocation);
				req.setAttribute("allroom", room1);
				req.setAttribute("roomarray", student1);
				req.getRequestDispatcher("/RoomModifyAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updatemodifyallocation"))
			{
				String year= req.getParameter("year");
				String semester= req.getParameter("semester");
				int y= Integer.parseInt(year);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semester);
				roomAllocation.setSemester(s);
				String[] studentname= req.getParameterValues("input");
				String[] roomnos= req.getParameterValues("roomno");
				String[] cupboardnos= req.getParameterValues("cupno");
				int[] studentid = new int[studentname.length];
				int[] roomid= new int[roomnos.length];
				
				for(int j=0;j< roomnos.length;j++)
				{
						try {
							roomid[j]= roomallocDB.roomselectid(roomnos[j],out);
							roomallocDB.delete(roomid[j], roomAllocation, out);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
				int i= 0;
				for(int k=0;k< roomnos.length;k++)
				{
					for(int j= 0;j< Integer.parseInt(cupboardnos[k])&& i< studentname.length ;j++)
					{
						String[] split= studentname[i].split(",");
						try
						{
							studentid[i]= roomallocDB.selectid(split[0],out);
							if(studentname[i] != null)
							{
								
								roomallocDB.insert(studentid[i],roomid[k],roomAllocation,out);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						i++;
					}
				}
				url="/RoomAllocation.jsp";
				req.getRequestDispatcher(url).forward(req, res);
				return;
			}
			if(access.equals("Frames"))
			{
				req.getRequestDispatcher("/RoomAllocation.jsp").forward(req, res);
				return;
			}
		}
		else
		{
			url= "/RoomAllocation.jsp";
			req.getRequestDispatcher(url).forward(req,res);
			return;
		}
	}
	/**This is function for configuring the Teachers to Rooms*/
	public void TeacherRoomallocationservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access= req.getParameter("access");
		TeacherAllocation roomalloc=new TeacherAllocation();
		TeacherAllocation roomAllocation=new TeacherAllocation();
		TeacherAllocationDB roomallocDB= new TeacherAllocationDB();
		ArrayList<TeacherAllocation> room= new ArrayList<TeacherAllocation>();
		ArrayList<Room> room1= new ArrayList<Room>();
		RoomDB roomsDB= new RoomDB();
		ArrayList<Student> student= new ArrayList<Student>();
		ArrayList<TeacherAllocation> student1= new ArrayList<TeacherAllocation>();
		TeacherAllocationDB roomDB= new TeacherAllocationDB();
		ArrayList<Course> course= new ArrayList<Course>();
		ArrayList<TeacherAllocation> roomallocarray=new ArrayList<TeacherAllocation>();
		boolean find;
		if(access!= null)
		{
			if(access.equalsIgnoreCase("Submit"))
			{
				out.println(access);

				roomalloc.setYear(Integer.parseInt(req.getParameter("year")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				try
				{
					roomallocarray= roomallocDB.select();
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				find= roomallocDB.check(roomalloc,roomallocarray,out);
				if(find == false)
				{
					try 
					{
						ArrayList<ArrayList<TeacherAllocation>> BigList= new ArrayList<ArrayList<TeacherAllocation>>();
						room1= roomDB.selectid(roomalloc,out);
						for(int i= 0;i< room1.size();i++)
						{
							student1= roomallocDB.selectbyroom(roomalloc,room1.get(i).getRoomNo(),out);
							BigList.add(student1);
						}
						req.setAttribute("StList",BigList);
						req.setAttribute("RmList",room1);
					} 
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					req.setAttribute("allocation", roomalloc);
					req.setAttribute("allroom", room1);
					req.setAttribute("roomarray", student1);
					req.getRequestDispatcher("/TeacherExistAllocation.jsp").forward(req, res);
					return;
				}
				else if(find == true)
				{
					out.println("its not there");
					req.setAttribute("notexist", roomalloc);
					req.getRequestDispatcher("/TeacherNotExistAllocation.jsp").forward(req, res);
					return;
				}
			}
			if(access.equals("Freshallocation"))
			{
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				try {
					room1= roomsDB.select();
					roomallocarray= TeacherAllocationDB.studentcourse(out);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				req.setAttribute("arraylist", room1);
				req.setAttribute("roomalloc", roomallocarray);
				req.setAttribute("allocation", roomAllocation);
				req.getRequestDispatcher("/TeacherFreshAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updateallocation"))
			{
				int roomsize= Integer.parseInt(req.getParameter("roomlistsize"));
				String[] studentname= req.getParameterValues("input");
				String[] roomnos= req.getParameterValues("roomno");
				String year1= req.getParameter("yearh");
				String semester1= req.getParameter("semesterh");
				int y= Integer.parseInt(year1);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semester1);
				roomAllocation.setSemester(s);
				int[] roomid= new int[roomnos.length];
				for(int k=0;k< roomsize;k++)
				{
						try {
							roomallocarray= TeacherAllocationDB.studentcourse(out);
							roomid[k]= roomallocDB.roomselectid(roomnos[k],out);
							if(studentname[k] != "")
								roomallocDB.insert(Integer.parseInt(studentname[k]),roomid[k],roomAllocation,out);
						} 
						catch (ClassNotFoundException e) 
						{
							e.printStackTrace();
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
				}
				req.getRequestDispatcher("/TeacherAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("TeacherModifyallocation"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("year")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				
				try {
					room1= roomsDB.select();
					room= roomallocDB.roomnos(roomalloc,out);
					roomallocarray= TeacherAllocationDB.studentcourse(out);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				req.setAttribute("rooms", room1);
				req.setAttribute("roomnos", room);
				req.setAttribute("allocation", roomalloc);
				req.setAttribute("roomallocarray", roomallocarray);
				req.getRequestDispatcher("/TeacherModifyAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updatemodifyallocation"))
			{
				String year= req.getParameter("year");
				String semester= req.getParameter("semester");
				String[] s= req.getParameterValues("teachermodify");
				out.println("year=   "+year+"semester=   "+semester);
				roomalloc.setYear(Integer.parseInt(year));
				roomalloc.setSemester(Integer.parseInt(semester));
				
				try 
				{
					roomallocDB.delete(roomalloc);
					for (int i = 0; i < s.length; i++)
					{
						if(!s[i].equals(""))
						{
							String[] split= s[i].split(",");
							roomallocDB.insert(Integer.parseInt(split[0]),Integer.parseInt(split[1]),roomalloc,out);
						}
					}
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				req.setAttribute("allocation", roomalloc);
				req.getRequestDispatcher("/TeacherAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Copyallocation"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("year")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				try 
				{
					ArrayList<ArrayList<TeacherAllocation>> BigList= new ArrayList<ArrayList<TeacherAllocation>>();
					room1= roomDB.selectid(roomalloc,out);
					for(int i= 0;i< room1.size();i++)
					{
						student1= roomallocDB.selectbyroom(roomalloc,room1.get(i).getRoomNo(),out);
						for (int j = 0; j < student1.size(); j++)
						{
							roomallocDB.insert(student1.get(j).getTeacherId(),room1.get(i).getRoomId(),roomAllocation,out);
						}
							
						BigList.add(student1);
					}
					req.setAttribute("StList",BigList);
					req.setAttribute("RmList",room1);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				req.setAttribute("allocation", roomAllocation);
				req.getRequestDispatcher("/TeacherExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancel"))
			{
				req.setAttribute("allocation", roomAllocation);
				req.getRequestDispatcher("/TeacherAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelfresh"))
			{
				String yearh= req.getParameter("yearh");
				String semesterh= req.getParameter("semesterh");
				int y= Integer.parseInt(yearh);
				roomAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				roomAllocation.setSemester(s);
				req.setAttribute("arraylist", roomallocarray);
				req.setAttribute("allocation", roomAllocation);
				req.setAttribute("notexist", roomAllocation);
				req.getRequestDispatcher("/TeacherNotExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelmodify"))
			{
				roomalloc.setYear(Integer.parseInt(req.getParameter("yearh")));
				roomalloc.setSemester(Integer.parseInt(req.getParameter("semesterh")));
				try
				{
					roomallocarray= roomallocDB.selected(roomalloc,out);
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e) 
				{
					out.println("in sql exception"+e);
				}
				req.setAttribute("update", roomallocarray);
				req.setAttribute("allocation", roomalloc);
				req.getRequestDispatcher("/TeacherExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Frames"))
			{
				req.getRequestDispatcher("/TeacherAllocation.jsp").forward(req, res);
				return;
			}
		}
		else
		{
			req.getRequestDispatcher("/TeacherAllocation.jsp").forward(req,res);
			return;
		}
	}
	/**This is function for configuring the Self Reliance Department*/
	public void Srdallocationservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access= req.getParameter("access");
		SRDAllocation srdalloc=new SRDAllocation();
		SRDAllocation srdAllocation=new SRDAllocation();
		SRDAllocationDB srdallocDB= new SRDAllocationDB();
		ArrayList<SRDAllocation> srd= new ArrayList<SRDAllocation>();
		ArrayList<SRDAllocation> student1= new ArrayList<SRDAllocation>();
		SRDAllocationDB srdDB= new SRDAllocationDB();
		ArrayList<SRDAllocation> srdallocarray=new ArrayList<SRDAllocation>();
		if(access!= null)
		{
			if(access.equalsIgnoreCase("srdSubmit"))
			{
				srdalloc.setYear(Integer.parseInt(req.getParameter("year")));
				srdalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				try
				{
					srdallocarray= srdallocDB.select(srdalloc,out);
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				if(srdallocarray.size() != 0)
				{
					try 
					{
						ArrayList<ArrayList<SRDAllocation>> BigList= new ArrayList<ArrayList<SRDAllocation>>();
						student1= SRDAllocationDB.selectid(srdalloc,out);
						for(int i= 0;i< student1.size();i++)
						{
							srdallocarray= srdallocDB.selectbysrd(srdalloc,student1.get(i).getSrdName(),out);
							BigList.add(srdallocarray);
						}
						req.setAttribute("StList",BigList);
						req.setAttribute("RmList",student1);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					} 
					req.setAttribute("allocation", srdalloc);
					req.setAttribute("srd", student1);
					req.setAttribute("student", srdallocarray);
					req.getRequestDispatcher("/SRDExistAllocation.jsp").forward(req, res);
					return;
				}
				else if(srdallocarray.size() == 0)
				{
					out.println("its true");
					req.setAttribute("notexist", srdalloc);
					req.getRequestDispatcher("/SRDNotExistAllocation.jsp").forward(req, res);
					return;
				}
			}
			if(access.equals("Freshallocation"))
			{
				
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				
				int y= Integer.parseInt(yearh);
				srdalloc.setYear(y);
				int s= Integer.parseInt(semesterh);
				srdalloc.setSemester(s);
				out.println("year= "+y+"semester= "+s);
				try
				{
					srd= srdDB.select(out);
					srdallocarray= srdallocDB.studentcourse(out);
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
					out.println(e);
				}
				for (int i = 0; i < srdallocarray.size(); i++)
				{
					out.println(srdallocarray.get(i).getName()+"course= "+srdallocarray.get(i).getCourseName());
				}
				out.println("srd size"+srd.size());
				req.setAttribute("arraylist", srd);
				req.setAttribute("allocation", srdalloc);
				req.setAttribute("srdalloc", srdallocarray);
				req.getRequestDispatcher("/SRDFreshAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updateallocation"))
			{
				
				String[] srdnames= req.getParameterValues("srdname");
				String year1= req.getParameter("yearh");
				String semester1= req.getParameter("semesterh");
				int y= Integer.parseInt(year1);
				srdAllocation.setYear(y);
				int s= Integer.parseInt(semester1);
				srdAllocation.setSemester(s);
				int srdallocsize= Integer.parseInt(req.getParameter("srdallocsize"));
				
				try
				{
					srdallocarray= srdallocDB.studentcourse(out);
					out.println(srdallocsize);
					for (int i = 0; i < srdallocsize; i++) 
					{
						out.println(srdallocarray.get(i).getStudentId());
						for (int j = 0; j < 3; j++)
						{
							String[] studentname= req.getParameterValues("input"+i+j); 
							int[] srdid= new int[studentname.length];
							
							for(int z= 0; z < studentname.length; z++)
							{
								if(!studentname[z].equals(""))
								{
									srdid[z]= srdallocDB.roomselectid(studentname[z],out);
									out.println(srdallocarray.get(i).getStudentId()+"srdid= "+srdid[z]);
									srdallocDB.insert(srdallocarray.get(i).getStudentId(),srdid[z],srdAllocation,out);
								}
							}
						}
					}
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				req.getRequestDispatcher("/SRDAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Copyallocation"))
			{
				srdalloc.setYear(Integer.parseInt(req.getParameter("year")));
				srdalloc.setSemester(Integer.parseInt(req.getParameter("semester")));
				String yearh= req.getParameter("yearhidden");
				String semesterh= req.getParameter("semesterhidden");
				int y= Integer.parseInt(yearh);
				srdAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				srdAllocation.setSemester(s);
				try 
				{
					ArrayList<ArrayList<SRDAllocation>> BigList= new ArrayList<ArrayList<SRDAllocation>>();
					student1= SRDAllocationDB.selectid(srdalloc,out);
					out.println("studentsize= "+student1.size());
					for(int i= 0;i< student1.size();i++)
					{
						srdallocarray= srdallocDB.selectbysrd(srdalloc,student1.get(i).getSrdName(),out);
						out.println(srdallocarray.size());
						for (int j = 0; j < srdallocarray.size(); j++)
						{
							out.println("srdid= "+student1.get(i).getSrdId()+"studentid= "+srdallocarray.get(j).getStudentId()+"year= "+srdAllocation.getYear()+"semester= "+srdAllocation.getSemester());
							srdallocDB.insert(srdallocarray.get(j).getStudentId(),student1.get(i).getSrdId(),srdAllocation,out);
						}
						BigList.add(srdallocarray);
					}
					req.setAttribute("StList",BigList);
					req.setAttribute("RmList",student1);
				} 
				catch (Exception e) 
				{
					out.println(e.getMessage());
					out.println(e.toString());
					e.printStackTrace();
				} 
				req.setAttribute("allocation", srdAllocation);
				req.setAttribute("srd", student1);
				req.setAttribute("student", srdallocarray);
				req.getRequestDispatcher("/SRDExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancel"))
			{
				req.setAttribute("allocation", srdAllocation);
				req.getRequestDispatcher("/SRDAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelfresh"))
			{
				String yearh= req.getParameter("yearh");
				String semesterh= req.getParameter("semesterh");
				int y= Integer.parseInt(yearh);
				srdAllocation.setYear(y);
				int s= Integer.parseInt(semesterh);
				srdAllocation.setSemester(s);
				req.setAttribute("arraylist", srdallocarray);
				req.setAttribute("allocation", srdAllocation);
				req.setAttribute("notexist", srdAllocation);
				req.getRequestDispatcher("/SRDNotExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Cancelmodify"))
			{
				srdalloc.setYear(Integer.parseInt(req.getParameter("yearh")));
				srdalloc.setSemester(Integer.parseInt(req.getParameter("semesterh")));
				req.setAttribute("update", srdallocarray);
				req.setAttribute("allocation", srdalloc);
				req.getRequestDispatcher("/SRDExistAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Modifyallocation"))
			{
				
				String yearh= req.getParameter("year");
				String semesterh= req.getParameter("semester");
				
				int y= Integer.parseInt(yearh);
				srdalloc.setYear(y);
				int s= Integer.parseInt(semesterh);
				srdalloc.setSemester(s);
				out.println("year= "+y+"semester= "+s);
				try
				{
					srd= srdDB.select(out);
					srdallocarray= srdallocDB.studentcourse(out);
				} catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
					out.println(e);
				}
				for (int i = 0; i < srdallocarray.size(); i++)
				{
					out.println(srdallocarray.get(i).getName()+"course= "+srdallocarray.get(i).getCourseName());
				}
				out.println("srd size"+srd.size());
				req.setAttribute("arraylist", srd);
				req.setAttribute("allocation", srdalloc);
				req.setAttribute("srdalloc", srdallocarray);
				req.getRequestDispatcher("/SRDModifyAllocation.jsp").forward(req, res);
				return;
			}
			if(access.equals("Updatemodifyallocation"))
			{
				String[] srdnames= req.getParameterValues("srdname");
				String year1= req.getParameter("yearh");
				String semester1= req.getParameter("semesterh");
				int y= Integer.parseInt(year1);
				srdAllocation.setYear(y);
				int s= Integer.parseInt(semester1);
				srdAllocation.setSemester(s);
				out.println(y+"semester= "+s);
				int srdallocsize= Integer.parseInt(req.getParameter("srdallocsize"));
				
				try
				{
					srdallocDB.delete(srdAllocation,out);
					srdallocarray= srdallocDB.studentcourse(out);
					out.println(srdallocsize);
					for (int i = 0; i < srdallocsize; i++) 
					{
						out.println(srdallocarray.get(i).getStudentId());
						for (int j = 0; j < 3; j++)
						{
							String[] studentname= req.getParameterValues("input"+i+j); 
							int[] srdid= new int[studentname.length];
							
							for(int z= 0; z < studentname.length; z++)
							{
								if(!studentname[z].equals(""))
								{
									srdid[z]= srdallocDB.roomselectid(studentname[z],out);
									out.println(srdallocarray.get(i).getStudentId()+"srdid= "+srdid[z]);
									srdallocDB.insert(srdallocarray.get(i).getStudentId(),srdid[z],srdAllocation,out);
								}
							}
						}
					}
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				req.getRequestDispatcher("/SRDAllocation.jsp").forward(req, res);
				return;
			
			}
			if(access.equals("Frames"))
			{
				req.getRequestDispatcher("/SRDAllocation.jsp").forward(req, res);
				return;
			}
		
		}
		else
		{
			req.getRequestDispatcher("/SRDAllocation.jsp").forward(req,res);
			return;
		}
	}
	/**This is the function for Configuring the Amount of each Fees_Type*/
	public void feesAmountService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out= res.getWriter();
		String access= req.getParameter("access");
		Fees_AmountBean feesAmount= new Fees_AmountBean();
		Fees_AmountDB feesAmountDB= new Fees_AmountDB();
		ArrayList<Fees_AmountBean> feesArray= new ArrayList<Fees_AmountBean>();
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
				req.getRequestDispatcher("/SearchFeesAmount.jsp").forward(req, res);
				return;
			}
			if(access.equalsIgnoreCase("find"))
			{
				try 
				{
					int year= Integer.parseInt(req.getParameter("year"));
					int sem= Integer.parseInt(req.getParameter("semester"));
					feesAmount.setYear(year);
					feesAmount.setSemester(sem);
					feesArray= feesAmountDB.selectbyId(feesAmount,out);
					boolean isAbsent= feesAmountDB.checkExists(feesAmount, feesArray,out);
					if(isAbsent == true)
					{
						req.setAttribute("notexists", feesAmount);
						req.getRequestDispatcher("/NotExisting.jsp").forward(req, res);
						return;
					}
					else
					{
						req.setAttribute("feesdetails", feesArray);
						req.setAttribute("feesyearsem",feesAmount);
						req.getRequestDispatcher("/ViewFeesAmount.jsp").forward(req, res);
						return;
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
			}
			if(access.equalsIgnoreCase("freshAllocation"))
			{
				int year= Integer.parseInt(req.getParameter("yearhidden"));
				int sem= Integer.parseInt(req.getParameter("semesterhidden"));
				Fees_AmountBean feeAmount= new Fees_AmountBean();
				ArrayList<Fees_Type> feeArray= new ArrayList<Fees_Type>();
				Fees_TypeDB feesDB= new Fees_TypeDB();
				feeAmount.setYear(year);
				feeAmount.setSemester(sem);
				try
				{
					feeArray= feesDB.select();
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
				req.setAttribute("newAllocation", feeAmount);
				req.setAttribute("feeType", feeArray);
				req.getRequestDispatcher("/NewAllocation.jsp").forward(req, res);
				return;
			}
			
			if(access.equalsIgnoreCase("insertfees"))
			{
				Fees_AmountBean fees= new Fees_AmountBean();
				Fees_AmountDB feesDB= new Fees_AmountDB();
				int feesId= Integer.parseInt(req.getParameter("feestype"));
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				int amount= Integer.parseInt(req.getParameter("amount"));
				fees.setAmount(amount);
				fees.setYear(year);
				fees.setSemester(sem);
				fees.setFees_Id(feesId);
				try
				{
					ArrayList<Fees_AmountBean> feesarray = feesDB.selectExisting(year,sem);
					boolean isAbsent= feesDB.checkIfExists(fees, feesarray,out);
					if(isAbsent == true)
					{
						feesDB.insert(fees,out);
						feesarray= feesDB.selectbyId(fees, out);
						req.setAttribute("feesdetails", feesarray);
						req.setAttribute("feesyearsem",fees);
						req.getRequestDispatcher("/ViewFeesAmount.jsp").forward(req, res);
						return;
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
			}
			
			if(access.equalsIgnoreCase("modifyfees"))
			{
				Fees_AmountBean fees= new Fees_AmountBean();
				Fees_AmountDB feesDB= new Fees_AmountDB();
				int year= Integer.parseInt(req.getParameter("yearhidden"));
				int sem= Integer.parseInt(req.getParameter("semesterhidden"));
				fees.setYear(year);
				fees.setSemester(sem);
				try
				{
					ArrayList<Fees_AmountBean> feesarray = feesDB.selectbyId(fees,out);
					ArrayList<Fees_Type> fee= feesDB.select();
					req.setAttribute("yearnsem", fees);
					req.setAttribute("feesAmount", feesarray);
					req.setAttribute("fees", fee);
					req.getRequestDispatcher("/ModifyFeesAmount.jsp").forward(req, res);
					return;
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
				
			if(access.equalsIgnoreCase("updatefees"))
			{
				Fees_AmountBean fees= new Fees_AmountBean();
				Fees_AmountDB feesDB= new Fees_AmountDB();
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				String[] feesId= req.getParameterValues("feesname");
				String[] amount= req.getParameterValues("modamount");
				fees.setYear(year);
				fees.setSemester(sem);
				try
				{
					feesDB.delete(fees.getYear(),fees.getSemester(), out);
					ArrayList<Fees_AmountBean> feesarray = feesDB.selectExisting(year,sem);
					feesDB.modupdate(feesId,amount,fees,out);
					feesarray= feesDB.selectbyId(fees, out);
					req.setAttribute("feesdetails", feesarray);
					req.setAttribute("feesyearsem",fees);
					req.getRequestDispatcher("/ViewFeesAmount.jsp").forward(req, res);
					return;
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
			
			if(access.equalsIgnoreCase("copyExisting"))
			{
				Fees_AmountBean fee= new Fees_AmountBean();
				Fees_AmountBean copy= new Fees_AmountBean();
				Fees_AmountDB feeDB= new Fees_AmountDB();
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				int copyyear= Integer.parseInt(req.getParameter("yearhidden"));
				int copysem= Integer.parseInt(req.getParameter("semesterhidden"));
				fee.setYear(year);
				fee.setSemester(sem);
				copy.setYear(copyyear);
				copy.setSemester(copysem);
				try
				{
					ArrayList<Fees_AmountBean> feesarray = feeDB.selectExisting(fee.getYear(),fee.getSemester());
					boolean isAbsent= feeDB.checkIfExists(copy, feesarray,out);
					if(isAbsent == true)
					{
						feeDB.copyinsert(copy,feesarray,out);
						feesArray= feeDB.selectbyId(copy, out);
						req.setAttribute("feesyearsem",copy);
						req.setAttribute("feesdetails", feesArray);
						req.getRequestDispatcher("/ViewFeesAmount.jsp").forward(req, res);
						return;
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
			}
		}
	}
	/**This is the function for Configuring the Amount of each Student_Fees_Information*/
	public void studentfeesService(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out= res.getWriter();
		String access= req.getParameter("access");
		StudentFeesBean studentfees= new StudentFeesBean();
		StudentFeesDB studentfeesDB= new StudentFeesDB();
		ArrayList<StudentFeesBean> studentfeesArray= new ArrayList<StudentFeesBean>();
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
				req.getRequestDispatcher("/SearchStudentFees.jsp").forward(req, res);
				return;
			}
			if(access.equalsIgnoreCase("search"))
			{
				try 
				{
					int year= Integer.parseInt(req.getParameter("year"));
					int sem= Integer.parseInt(req.getParameter("semester"));
					studentfees.setYear(year);
					studentfees.setSemester(sem);
					studentfeesArray= studentfeesDB.selectbyId(studentfees,out);
					boolean isAbsent= studentfeesDB.checkExists(studentfees, studentfeesArray,out);
					if(isAbsent == true)
					{
						req.setAttribute("notexists", studentfees);
						req.getRequestDispatcher("/StudentFeesNotExisting.jsp").forward(req, res);
						return;
					}
					else
					{
						req.setAttribute("feesdetails", studentfeesArray);
						req.setAttribute("feesyearsem",studentfees);
						req.getRequestDispatcher("/ViewStudentFees.jsp").forward(req, res);
						return;
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
			}
			
			if(access.equalsIgnoreCase("freshAllocation"))
			{
				int year= Integer.parseInt(req.getParameter("yearhidden"));
				int sem= Integer.parseInt(req.getParameter("semesterhidden"));
				StudentFeesBean studentfee= new StudentFeesBean();
				ArrayList<Fees_Type> feeArray= new ArrayList<Fees_Type>();
				ArrayList<Student> student= new ArrayList<Student>();
				Fees_TypeDB feesDB= new Fees_TypeDB();
				StudentDB studentDB= new StudentDB();
				studentfee.setYear(year);
				studentfee.setSemester(sem);
				try
				{
					feeArray= feesDB.select();
					student= studentDB.select();
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
				req.setAttribute("newAllocation", studentfee);
				req.setAttribute("feeType", feeArray);
				req.setAttribute("studentarray", student);
				req.getRequestDispatcher("/StudentFeesAllocation.jsp").forward(req, res);
				return;
			}
			
			if(access.equalsIgnoreCase("insertstudentfees"))
			{
				StudentFeesBean studentfee= new StudentFeesBean();
				StudentFeesDB studentfeeDB= new StudentFeesDB();
				int studentId= Integer.parseInt(req.getParameter("student"));
				String[] feesId= req.getParameterValues("feestype");
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				String[] amount= req.getParameterValues("amount");
				String[] receipt= req.getParameterValues("receipt");
				studentfee.setStudentId(studentId);
				studentfee.setYear(year);
				studentfee.setSemester(sem);
				try
				{
					ArrayList<StudentFeesBean> studentfeesarray = studentfeesDB.selectExisting(year,sem);
					boolean isAbsent= studentfeeDB.checkIfExists(studentfee, studentfeesarray,out);
					if(isAbsent == true)
					{
						studentfeeDB.insert(feesId,studentfee,amount,receipt,out);
						studentfeesArray= studentfeeDB.selectbyId(studentfee, out);
						req.setAttribute("feesdetails", studentfeesArray);
						req.setAttribute("feesyearsem",studentfee);
						req.getRequestDispatcher("/ViewStudentFees.jsp").forward(req, res);
						return;
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
			}
			
			if(access.equalsIgnoreCase("modifystudentfees"))
			{
				StudentFeesBean studentfee= new StudentFeesBean();
				StudentFeesDB studentfeeDB= new StudentFeesDB();
				ArrayList<Student> student= new ArrayList<Student>();
				ArrayList<Fees_Type> fee= new ArrayList<Fees_Type>();
				StudentFeesDB studentDB= new StudentFeesDB();
				StudentFeesDB feesDB= new StudentFeesDB();
				Fees_AmountDB fees= new Fees_AmountDB();
				Fees_AmountBean f= new Fees_AmountBean();
				ArrayList<Fees_AmountBean> feeamount= new ArrayList<Fees_AmountBean>();
				int year= Integer.parseInt(req.getParameter("yearhidden"));
				int sem= Integer.parseInt(req.getParameter("semesterhidden"));
				studentfee.setYear(year);
				studentfee.setSemester(sem);
				f.setYear(year);
				f.setSemester(sem);
				try
				{
					ArrayList<StudentFeesBean> studentfeesarray = studentfeeDB.selectbyId(studentfee,out);
					student= studentDB.select1();
					fee= feesDB.select();
					feeamount= fees.selectbyId(f, out);
					req.setAttribute("yearnsem", studentfee);
					req.setAttribute("feesAmount", studentfeesarray);
					req.setAttribute("fees", fee);
					req.setAttribute("students", student);
					req.setAttribute("amount", feeamount);
					req.getRequestDispatcher("/ModifyStudentFees.jsp").forward(req, res);
					return;
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
			
			if(access.equalsIgnoreCase("updatestudentfees"))
			{
				StudentFeesBean studentfee= new StudentFeesBean();
				StudentFeesDB studentfeeDB= new StudentFeesDB();
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				int studentId= Integer.parseInt(req.getParameter("name"));
				String[] feesId= req.getParameterValues("feesname");
				String[] amount= req.getParameterValues("modamount");
				String[] receipt= req.getParameterValues("modreceipt");
				studentfee.setYear(year);
				studentfee.setSemester(sem);
				studentfee.setStudentId(studentId);
				try
				{
					studentfeeDB.delete(studentfee.getYear(),studentfee.getSemester(), out);
					ArrayList<StudentFeesBean> studentfeesarray = studentfeeDB.selectExisting(year,sem);
					studentfeeDB.modupdate(feesId,studentfee,amount,receipt,out);
					studentfeesarray= studentfeeDB.selectbyId(studentfee, out);
					req.setAttribute("feesdetails", studentfeesarray);
					req.setAttribute("feesyearsem",studentfee);
					req.getRequestDispatcher("/ViewStudentFees.jsp").forward(req, res);
					return;
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
			
			if(access.equalsIgnoreCase("copyexisting"))
			{
				StudentFeesBean studentfee= new StudentFeesBean();
				StudentFeesBean copy= new StudentFeesBean();
				StudentFeesDB studentfeeDB= new StudentFeesDB();
				int year= Integer.parseInt(req.getParameter("year"));
				int sem= Integer.parseInt(req.getParameter("semester"));
				int copyyear= Integer.parseInt(req.getParameter("yearhidden"));
				int copysem= Integer.parseInt(req.getParameter("semesterhidden"));
				studentfee.setYear(year);
				studentfee.setSemester(sem);
				copy.setYear(copyyear);
				copy.setSemester(copysem);
				try
				{
					ArrayList<StudentFeesBean> studentfeesarray = studentfeesDB.selectExisting(studentfee.getYear(),studentfee.getSemester());
					boolean isAbsent= studentfeeDB.checkIfExists(copy, studentfeesarray,out);
					if(isAbsent == true)
					{
						studentfeeDB.copyinsert(copy,studentfeesarray,out);
						studentfeesArray= studentfeeDB.selectbyId(copy, out);
						req.setAttribute("feesyearsem",copy);
						req.setAttribute("feesdetails", studentfeesArray);
						req.getRequestDispatcher("/ViewStudentFees.jsp").forward(req, res);
						return;
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
			}
		}
	}
	
	/**This function for Student Bank's Information*/
	public void studentBankService(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out= res.getWriter();
		String access= req.getParameter("access");
		if(access == null)
			access= "search";
		if(access != null)
		{
			if(access.equalsIgnoreCase("addnew"))
			{
				ArrayList<Student> student= new ArrayList<Student>();
				StudentDB studentDB= new StudentDB();
				try
				{
					student= studentDB.select();
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
				req.setAttribute("studentarray", student);
				req.getRequestDispatcher("/StudentBank.jsp").forward(req, res);
				return;
			}
			if(access.equalsIgnoreCase("search"))
			{
				try
				{
					Student_Bank bank= new Student_Bank();
					Student_BankDB bankDB= new Student_BankDB();
					ArrayList<Student_Bank> bankarray= new ArrayList<Student_Bank>();
					bankarray= bankDB.selectbyId();
					ArrayList<Student> student= new ArrayList<Student>();
					StudentDB studentDB= new StudentDB();
					for(int i= 0;i < bankarray.size();i++)
					{
						bank.setStudentname(bankarray.get(i).getStudentname());
						bankarray= bankDB.selectExisting();
					}
					if(bankarray.size() != 0)
					{
						req.setAttribute("bank", bankarray);
						req.getRequestDispatcher("/ViewStudentBank.jsp").forward(req, res);
						return;
					}
					if(bankarray.size() == 0)
					{
						student= studentDB.select();
						req.setAttribute("studentarray", student);
						req.getRequestDispatcher("/StudentBank.jsp").forward(req, res);
						return;
					}
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
			}
			
			if(access.equalsIgnoreCase("insertbank"))
			{
				Student_Bank bank= new Student_Bank();
				Student_BankDB bankDB= new Student_BankDB();
				int studentId= Integer.parseInt(req.getParameter("student"));
				String[] name= req.getParameterValues("bankname");
				String[] accno= req.getParameterValues("accno");
				String[] atm= req.getParameterValues("atmcard");
				bank.setStudentId(studentId);
				try
				{
					ArrayList<Student_Bank> bankarray = bankDB.selectExisting();
					boolean isAbsent= bankDB.checkExists(bank, bankarray,out);
					if(isAbsent == true)
					{
						bankDB.insert(bank,name,accno,atm,out);
						bankarray= bankDB.selectExisting();
						req.setAttribute("bank", bankarray);
						req.getRequestDispatcher("/ViewStudentBank.jsp").forward(req, res);
						return;
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
			}
			
			if(access.equalsIgnoreCase("modifybank"))
			{
				Student_Bank bank= new Student_Bank();
				Student_BankDB bankDB= new Student_BankDB();
				ArrayList<Student_Bank> bankarray= new ArrayList<Student_Bank>();
				ArrayList<Student> student= new ArrayList<Student>();
				StudentDB studentDB= new StudentDB();
				bank.setStudentId(Integer.parseInt(req.getParameter("studentId")));
				try
				{
					student= studentDB.select();
					req.setAttribute("studentarray", student);
					bankarray= bankDB.selectbyid(bank);
					req.setAttribute("bank", bankarray);
					req.getRequestDispatcher("/ModifyStudentBank.jsp").forward(req, res);
					return;
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
			
			if(access.equalsIgnoreCase("updatebank"))
			{
				Student_Bank bank= new Student_Bank();
				Student_BankDB bankDB= new Student_BankDB();
				int studentId= Integer.parseInt(req.getParameter("name"));
				String[] bankname= req.getParameterValues("modbank");
				String[] accno= req.getParameterValues("modaccno");
				String[] atm= req.getParameterValues("modatm");
				bank.setStudentId(studentId);
				try
				{
					bankDB.delete(bank, out);
					ArrayList<Student_Bank> bankarray = bankDB.selectExisting();
					bankDB.update(bank,bankname,accno,atm,out);
					bankarray= bankDB.selectExisting();
					req.setAttribute("bank", bankarray);
					req.getRequestDispatcher("/ViewStudentBank.jsp").forward(req, res);
					return;
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
		}
	}
	/**This is the function for Frame Module*/
	public void Frameservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/hostelteacher.html").forward(req, res);
		return;
	}
	
	/**This is the Servlet doPost*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String module= req.getParameter("module");
		if(module == null)
			module= "frames";
		if(module.equalsIgnoreCase("fees_Amount"))
			feesAmountService(req, res);
		if(module.equalsIgnoreCase("studentfees"))
			studentfeesService(req,res);
		if(module.equalsIgnoreCase("studentbank"))
			studentBankService(req,res);
		if(module.equals("RoomAllocation"))
			Roomallocationservice(req, res);
		if(module.equals("TeacherRoomAllocation"))
			TeacherRoomallocationservice(req, res);
		if(module.equals("SrdAllocation"))
			Srdallocationservice(req, res);
		if(module.equalsIgnoreCase("frames"))
			Frameservice(req, res);
	}
	/**This is the Servlet doGet*/
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}
}
