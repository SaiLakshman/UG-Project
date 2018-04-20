package bca.batch2011.project1.ct;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bca.batch2011.project1.ca.Student;
import bca.batch2011.project1.ca.TeacherBean;

public class CT_ControllerServlet extends HttpServlet
{
	public void papercourseService(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PaperTeacherDB pt= new PaperTeacherDB();
		ExamPaperDB ep= new ExamPaperDB();
		PaperCourseDB pc= new PaperCourseDB();
		PrintWriter out= res.getWriter();
		String url= "";
		ArrayList<Papers_Course> e= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> pap= new ArrayList<Papers_Course>();
		String coursename= req.getParameter("coursename");
		ArrayList<Papers_Course> years= new ArrayList<Papers_Course>();
		String ba= req.getParameter("batch");
		String module= req.getParameter("module");
		Papers_Course c= new Papers_Course();
		Papers_Course oc= new Papers_Course();
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		String access= req.getParameter("access");
		String pid1[]= null,pid2[]= null,pid3[]= null,pid4[]= null,pid5[]= null,pid6[]= null,pcode1[]= null,pcode2[]= null,pcode3[]= null,pcode4[]= null,pcode5[]= null,pcode6[]= null;
		if((coursename != null) && !coursename.equals(""))
		{
			int cid= Integer.parseInt(coursename);
			c.setCourse_id(cid);
		}
		if((ba != null) && !ba.equals(""))
		{
			int batch= Integer.parseInt(ba);
			c.setBatch(batch);
			try
			{
				int duration= pc.duration(c);
				c.setDuration(duration);
			}
			catch (ClassNotFoundException e1)
			{
				req.setAttribute("exc", e1.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
			catch (SQLException e1)
			{
				req.setAttribute("exc", e1.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
		}
		req.setAttribute("coursename", c); //c is common for whole paper course service.User entered details are stored in c.
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			/**This function is for showing the view of Syllabus View*/
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					e= pc.selectcourse(); //e is an arraylist of Papers_Course bean class which has all the details of courses
					req.setAttribute("course",e);
				}
				catch (ClassNotFoundException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				url= "/ListCourseBatch.jsp";
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
				return;
		    }
			else if(module.equals("coursepaper"))
			{
			/**This function is for checking weather the user selected Year and Course is present in database or not.If it is present then it shows the syllabus for that selected year and semester*/
				if(req.getParameter("access").equals("check"))
				{
					try
					{
						c1= pc.selectforpaperbatch();//this is for getting all the course details from Pap_Cou_T
						p1= pc.selectforpapercodetitle();//this is for getting all the paper details from P_C_T & P_M_T
						years= pc.selectyears(c);//this is for getting the duration of the user selected course
						req.setAttribute("years",years);
						boolean check= pc.checkforpaperbatch(c,c1);//comparing the users data with data base data
						if(!check)
						{
								req.setAttribute("paperbatch",c1);
								req.setAttribute("batchpaper",p1);
								url= "/SeePapers.jsp";
						}
						else
							url= "/CheckResult.jsp";
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
			/**In case of no data for the selected year and semester in the database this function fetches all the paper details from paper_Master_Table*/
				else if(req.getParameter("access").equals("setpaper"))
				{
					try
					{
						pap= pc.selectpapers();
						req.setAttribute("papers",pap);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/SetPaper.jsp";
				}
			/**This function fetches the data of the selected particular year from database for modify*/
				else if(req.getParameter("access").equals("modifypaper"))
				{
					try
					{
						c1= pc.selectforpaperbatch();
						p1= pc.selectforpapercodetitle();
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
						pap= pc.selectpapers();
						req.setAttribute("papers",pap);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/CourseModifyPaper.jsp";
				}
			/**This function is for getting the paper_code and paper_id entered and selected by the user for setting syllabus*/
				else if(req.getParameter("access").equals("setpapercourse"))
				{
					try
					{
						ep.delete(c);
						pt.deleteteacherpaper(c);
						pc.deletecoursepaper(c);
					}
					catch (ClassNotFoundException | SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					pid1= req.getParameterValues("1paperid"); 
					pcode1= req.getParameterValues("1code"); 
					pid2= req.getParameterValues("2paperid"); 
					pcode2= req.getParameterValues("2code"); 
					pid3= req.getParameterValues("3paperid"); 
					pcode3= req.getParameterValues("3code"); 
					pid4= req.getParameterValues("4paperid"); 
					pcode4= req.getParameterValues("4code"); 
					pid5= req.getParameterValues("5paperid"); 
					pcode5= req.getParameterValues("5code"); 
					pid6= req.getParameterValues("6paperid"); 
					pcode6= req.getParameterValues("6code"); 
				}
			/**This function is for getting the paper_code and paper_id entered and selected by the user for modifying syllabus*/
				else if(req.getParameter("access").equals("setmodifypapercourse"))
				{
					try
					{
						ep.delete(c);
						pt.deleteteacherpaper(c);
						pc.deletecoursepaper(c);
					}
					catch (ClassNotFoundException | SQLException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					pid1= req.getParameterValues("1modpaperid"); 
					pcode1= req.getParameterValues("1modcode"); 
					pid2= req.getParameterValues("2modpaperid"); 
					pcode2= req.getParameterValues("2modcode"); 
					pid3= req.getParameterValues("3modpaperid"); 
					pcode3= req.getParameterValues("3modcode"); 
					pid4= req.getParameterValues("4modpaperid"); 
					pcode4= req.getParameterValues("4modcode"); 
					pid5= req.getParameterValues("5modpaperid"); 
					pcode5= req.getParameterValues("5modcode"); 
					pid6= req.getParameterValues("6modpaperid"); 
					pcode6= req.getParameterValues("6modcode"); 
				}
				/**This function is for inserting the paper_code and paper_id entered and selected by the user into database*/
				if(req.getParameter("access").equals("setmodifypapercourse") || req.getParameter("access").equals("setpapercourse"))
				{
					try
					{
						c.setYear(1);
						c.setSemester(1);
						pc.insertcoursepaper(pid1,pcode1,c);
						c.setSemester(2);
						pc.insertcoursepaper(pid2,pcode2,c);
						c.setYear(2);
						c.setSemester(1);
						pc.insertcoursepaper(pid3,pcode3,c);
						c.setSemester(2);
						pc.insertcoursepaper(pid4,pcode4,c);
						if(c.getDuration() > 2)
						{
							c.setYear(3);
							c.setSemester(1);
							pc.insertcoursepaper(pid5,pcode5,c);
							c.setSemester(2);
							pc.insertcoursepaper(pid6,pcode6,c);
						}
						c1= pc.selectforpaperbatch();
						p1= pc.selectforpapercodetitle();
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/SeePapers.jsp";
				}
				/**This function is for copying the data of other batches to the user selected batch*/
				else if(req.getParameter("access").equals("copydraft"))
				{
					oc.setCourse_name(c.getCourse_name());
					oc.setCourse_id(c.getCourse_id());
					String oba= req.getParameter("copybatch");
					int batch= Integer.parseInt(oba);
					oc.setBatch(batch);
					req.setAttribute("copypaperbatch",oc);
					try
					{
						c1= pc.selectforcopycourse(oc);
						p1= pc.selectforcopypaper(oc);
						pc.addcopy(c,oc,c1,p1);
						c1= pc.selectforpaperbatch();
						p1= pc.selectforpapercodetitle();
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/SeePapers.jsp";
				}
				/**This function is for viewing the starting page of Syllabus view*/
				else if(req.getParameter("access").equals("cancel"))
				{
					try
					{
						e= pc.selectcourse();
						req.setAttribute("course",e);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/ListCourseBatch.jsp";
				}
			}
			RequestDispatcher dispatcher= req.getRequestDispatcher(url);
			dispatcher.forward(req, res);
		}
	}
	public void paperteacherService(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PaperTeacherDB pt= new PaperTeacherDB();
		ExamPaperDB ep= new ExamPaperDB();
		PaperCourseDB pc= new PaperCourseDB();
		PrintWriter out= res.getWriter();
		String url= "";
		ArrayList<Papers_Course> e= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> pap= new ArrayList<Papers_Course>();
		String coursename= req.getParameter("coursename");
		ArrayList<Papers_Course> years= new ArrayList<Papers_Course>();
		ArrayList<TeacherBean> teachers= new ArrayList<TeacherBean>();
		ArrayList<Papers_Course> paper1= new ArrayList<Papers_Course>();
		String ba= req.getParameter("batch");
		String module= req.getParameter("module");
		Papers_Course c= new Papers_Course();
		Papers_Course oc= new Papers_Course();
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> c2= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		String access= req.getParameter("access");
		String tid1[]= null,tid2[]= null,tid3[]= null,tid4[]= null,tid5[]= null, tid6[]= null;
		if((coursename != null) && !coursename.equals(""))
		{
			int cid= Integer.parseInt(coursename);
			c.setCourse_id(cid);
		}
		if((ba != null) && !ba.equals(""))
		{
			int batch= Integer.parseInt(ba);
			c.setBatch(batch);
			try
			{
				int duration= pc.duration(c);
				c.setDuration(duration);
				years= pt.selectteacherpaperyears(c);
				req.setAttribute("years",years);
			}
			catch (ClassNotFoundException e1)
			{
				req.setAttribute("exc", e1.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
			catch (SQLException e1)
			{
				req.setAttribute("exc", e1.getMessage());
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
				return;
			}
		}
		req.setAttribute("coursename", c);
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			/**This function is for showing the view of Paper Teacher*/
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					e= pc.selectcourse();
					req.setAttribute("course",e);
				}
				catch (ClassNotFoundException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				url= "/TeacherListCourseBatch.jsp";
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
		  	}
			/**This function is for checking weather any data for the selected year and semester is present in Paper_Teacher_Table or not.*/
			else if(module.equals("teacherpaper"))
			{
				if(req.getParameter("access").equals("check"))
				{
					ArrayList<TeacherBean> t= new ArrayList<TeacherBean>();
					try
					{
						c1= pc.selectforpaperbatch();
						c2= pt.selectforteachercourse();
						p1= pc.selectforpapercodetitle();
						boolean check= pc.checkforpaperbatch(c,c1);
						if(!check)
						{
							boolean checkteacherpaper= pc.checkforpaperbatch(c,c2);
							if(!checkteacherpaper)
							{
								c1= pt.selectforpaperbatchteachercourse(c);
								p1= pt.selectforpapercodetitleteacher(c);
								t= pt.selectforteacherpapercourse(c);
								req.setAttribute("teacherpaper",t);
								req.setAttribute("batchpaper",p1);
								req.setAttribute("paperbatch",c1);
								url= "/TeacherSeePapers.jsp";
							}
							else
								url= "/TeacherCopyCheckResult.jsp";
						}
						else
							url= "/TeacherPaperCheckResult.jsp";
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				/**This function is for getting the teacher details from T_M_T*/
				else if(req.getParameter("access").equals("setteacher"))
				{
					try
					{
						teachers= pt.selectteachers();
						req.setAttribute("allteachers",teachers);
						c1= pc.selectforpaperbatch();
						p1= pc.selectforpapercodetitle();
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
						pap= pc.selectpapers();
						req.setAttribute("papers",pap); 
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/TeacherSetPaper.jsp";
				}
				/**This function is for getting the paper_id selected by the user for setting teachers to papers*/
				else if(req.getParameter("access").equals("setteacherpaper"))
				{
					tid1= req.getParameterValues("1teachpaperid"); 
					tid2= req.getParameterValues("2teachpaperid"); 
					tid3= req.getParameterValues("3teachpaperid"); 
					tid4= req.getParameterValues("4teachpaperid"); 
					tid5= req.getParameterValues("5teachpaperid"); 
					tid6= req.getParameterValues("6teachpaperid");
				}
				/**This function is for getting the teacher details from T_M_T and P_T_T for modifying*/
				else if(req.getParameter("access").equals("modifyteacher"))
				{
					ArrayList<TeacherBean> t= new ArrayList<TeacherBean>();
					try
					{
						c1= pt.selectforpaperbatchteachercourse(c);
						p1= pt.selectforpapercodetitleteacher(c);
						t= pt.selectforteacherpapercourse(c);
						teachers= pt.selectteachers();
						req.setAttribute("allteachers",teachers);
						req.setAttribute("teacherpaper",t);
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/TeacherModifyPaper.jsp";
				}
				/**This function is for getting the paper_id selected by the user for modifying teachers who are allocated*/
				else if(req.getParameter("access").equals("modifyteacherspaper"))
				{
					try
					{
						ep.delete(c);
						pt.deleteteacherpaper(c);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					tid1= req.getParameterValues("1modteachpaperid"); 
					tid2= req.getParameterValues("2modteachpaperid"); 
					tid3= req.getParameterValues("3modteachpaperid"); 
					tid4= req.getParameterValues("4modteachpaperid"); 
					tid5= req.getParameterValues("5modteachpaperid"); 
					tid6= req.getParameterValues("6modteachpaperid");
				}
				/**This function is for inserting the details of paper teacher into P_T_T*/
				if(req.getParameter("access").equals("modifyteacherspaper") || req.getParameter("access").equals("setteacherpaper"))
				{
					ArrayList<TeacherBean> t= new ArrayList<TeacherBean>();
					try
					{
						c.setSemester(1);
						c.setYear(1);
						paper1= pt.selectpaperidnaco(c);
						if (tid1 != null)
							pt.insertteacherpaper(tid1,paper1,c);
						c.setSemester(2);
						paper1= pt.selectpaperidnaco(c);
						if(tid2 != null)
							pt.insertteacherpaper(tid2,paper1,c);
						c.setYear(2);
						c.setSemester(1);
						paper1= pt.selectpaperidnaco(c);
						if(tid3 != null)
							pt.insertteacherpaper(tid3,paper1,c);
						c.setSemester(2);
						paper1= pt.selectpaperidnaco(c);
						if(tid4 != null)
							pt.insertteacherpaper(tid4,paper1,c);
						if(c.getDuration() > 2)
						{
							c.setYear(3);
							c.setSemester(1);
							paper1= pt.selectpaperidnaco(c);
							if(tid5 != null)
								pt.insertteacherpaper(tid5,paper1,c);
							c.setSemester(2);
							paper1= pt.selectpaperidnaco(c);
							if(tid6 != null)
								pt.insertteacherpaper(tid6,paper1,c);
							paper1= pt.selectpaperidnaco(c);
						}
						c2= pt.selectforteachercourse();
						boolean checkteacherpaper= pc.checkforpaperbatch(c,c2);
						if(!checkteacherpaper)
						{
							ArrayList<Papers_Course> p= new ArrayList<Papers_Course>();
							p= pc.selectforcopypaper(c);
							c1= pt.selectforpaperbatchteachercourse(c);
							p1= pt.selectforpapercodetitleteacher(c);
							t= pt.selectforteacherpapercourse(c);
							req.setAttribute("teacherpaper",t);
							req.setAttribute("batchpaper",p1);
							req.setAttribute("paperbatch",c1);
							if(t.size() != p1.size() && t.size()>0 || p.size() != p1.size())
							{
								url="TeacherNotAllocated.jsp";
								pt.deleteteacherpaper(c);
							}
							else
								url= "/TeacherSeePapers.jsp";
						}
						else
							url= "/TeacherCopyCheckResult.jsp";
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				/**This function is for copying the all details from one batch and assigning to other batch*/
				else if(req.getParameter("access").equals("copyteacherpaperdraft"))
				{
					ArrayList<TeacherBean> t= new ArrayList<TeacherBean>();
					oc.setCourse_name(c.getCourse_name());
					oc.setCourse_id(c.getCourse_id());
					String oba= req.getParameter("copyteacherbatch");
					int batch= Integer.parseInt(oba);
					oc.setBatch(batch);
					req.setAttribute("copypaperbatch",oc);
					try {
						c1= pc.selectforcopycourse(oc);
						p1= pc.selectforcopypaper(oc);
						pc.addcopy(c,oc,c1,p1);
						c1= pc.selectforpaperbatch();
						p1= pc.selectforpapercodetitle();
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					try
					{
						c1= pc.selectforcopycourse(oc);
						p1= pc.selectforcopypaper(oc);
						t= pt.selectforcopyteacher(oc);
						pt.addcopyteacher(c,oc,c1,p1,t);
						c1= pt.selectforpaperbatchteachercourse(c);
						p1= pt.selectforpapercodetitleteacher(c);
						t= pt.selectforteacherpapercourse(c);
						req.setAttribute("teacherpaper",t);
						req.setAttribute("batchpaper",p1);
						req.setAttribute("paperbatch",c1);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/TeacherSeePapers.jsp";
				}
				/**This function is for viewing the starting page of Paper Teacher*/
				else if(req.getParameter("access").equals("cancel"))
				{
					try
					{
						e= pc.selectcourse();
						req.setAttribute("course",e);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/TeacherListCourseBatch.jsp";
				}
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
			}
		}
	}
	public void exampaperService(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PaperCourseDB pc= new PaperCourseDB();
		PaperTeacherDB pt= new PaperTeacherDB();
		ExamPaperDB ep= new ExamPaperDB();
		PrintWriter out= res.getWriter();
		String url= "";
		ArrayList<Papers_Course> e= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> pap= new ArrayList<Papers_Course>();
		String coursename= req.getParameter("ecoursename");
		String yr= req.getParameter("year");
		String sem= req.getParameter("semester");
		ArrayList<Papers_Course> years= new ArrayList<Papers_Course>();
		String ba= req.getParameter("ebatch");
		String module= req.getParameter("module");
		Papers_Course c= new Papers_Course();
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> c2= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		String access= req.getParameter("access");
		ArrayList<ExamPaper> ep1= new ArrayList<ExamPaper>();
		ArrayList<ExamPaper> ep2= new ArrayList<ExamPaper>();
		ArrayList<Papers_Course> p2= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> p3= new ArrayList<Papers_Course>();
		String pid1[]= null,pid2[] = null,pid3[] = null,pid4[] = null,pid5[] = null,pid6[] = null,pid7[] = null,pid8[] = null,pid9[] = null,pid10[] = null,pcode1[] = null,pcode2[] = null,pcode3[] = null,pcode4[] = null,pcode5[] = null,pcode6[] = null,pcode7[] = null,pcode8[] = null,pcode9[] = null,pcode10[] = null;
		
		if((coursename != null) && !coursename.equals(""))
		{
			int cid= Integer.parseInt(coursename);
			c.setCourse_id(cid);
		}
		if((yr != null) && !yr.equals(""))
		{
			int year= Integer.parseInt(yr);
			c.setYear(year);
		}
		if((sem != null) && !sem.equals(""))
		{
			int semester= Integer.parseInt(sem);
			c.setSemester(semester);
		}
		if((ba != null) && !ba.equals(""))
		{
			int batch= Integer.parseInt(ba);
			c.setBatch(batch);
			try {
					int duration= pc.duration(c);
					c.setDuration(duration);
				} catch (ClassNotFoundException e1) {
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				} catch (SQLException e1) {
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
		}
		req.setAttribute("coursename", c);
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			/**This function is for viewing the starting page of Exams Marks*/
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					e= pc.selectcourse();
					req.setAttribute("course",e);
				}
				catch (ClassNotFoundException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				url= "/ExamListCourseBatchYearSemester.jsp";
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
		   	}
			else if(module.equals("exampaper"))
			{
				/**This function is for checking weather is there any data of the particular year is present in P_C_T and P_T_T*/
				if(req.getParameter("access").equals("echeck"))
				{
					try
					{
						c1= pc.selectforpaperbatch();
						c2= pt.selectforteachercourse();
						years= pc.selectyears(c);
						req.setAttribute("years",years);
						boolean check= ep.checkforpaperbatch(c,c1);
						if(!check)
						{
							boolean checkteacherpaper= pc.checkforpaperbatch(c,c2);
							if(!checkteacherpaper)
							{
								c1= ep.selectforexambatchcourse();
								boolean checkep= ep.checkforpaperbatch(c,c1);
								if(!checkep)
								{
									p1= ep.selectPaperBeanfromcoursetable(c);
									p2= ep.selectpid(c);
									ep1= ep.selectexamdetails(c);
									p3= ep.selectPaperBean(c);
									req.setAttribute("coursesempaper",p1);
									req.setAttribute("pid",p2);
									req.setAttribute("examdetails",ep1);
									req.setAttribute("papers", p3);
									url= "/ExamSeePapers.jsp";
								}
								else
									url= "ExamNotAllocated.jsp";
							}
							else
								url= "TeacherNotPresent.jsp";
						}
						else
							url= "/ExamCheckResult.jsp";
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				/**This function is for getting the exams details from E_M_T*/
				else if(req.getParameter("access").equals("setexam"))
				{
					try
					{
						pap= ep.selectPaperBeanfromcoursetable(c);
						ep1= ep.selectallexams();
						req.setAttribute("papers",pap);
						req.setAttribute("exams",ep1);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/ExamSetPaper.jsp";
				}
				/**This function is for getting the exams details from the selected year and semester for modifying*/
				else if(req.getParameter("access").equals("modifyexam"))
				{
					try
					{
						pap= ep.selectPaperBeanfromcoursetable(c);
						ep1= ep.selectallexams();
						ep2= ep.selecteidsfromexpaper(c);
						p2= ep.selectpid(c);
						req.setAttribute("papers",pap);
						req.setAttribute("pid",p2);
						req.setAttribute("exams",ep1);
						req.setAttribute("yearsemexams",ep2);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/ExamModifyPaper.jsp";
				}
				/**This function is for getting the examcode and marks for inserting into Exam_Paper_Table*/
				else if(req.getParameter("access").equals("setexampaper"))
				{
					 pid1= req.getParameterValues("1examcode"); 
					 pcode1= req.getParameterValues("1mark"); 
					 pid2= req.getParameterValues("2examcode"); 
					 pcode2= req.getParameterValues("2mark"); 
					 pid3= req.getParameterValues("3examcode"); 
					 pcode3= req.getParameterValues("3mark"); 
					 pid4= req.getParameterValues("4examcode"); 
					 pid5= req.getParameterValues("5examcode"); 
					 pcode5= req.getParameterValues("5mark"); 
					 pid6= req.getParameterValues("6examcode"); 
					 pcode6= req.getParameterValues("6mark"); 
					 pid7= req.getParameterValues("7examcode"); 
					 pcode7= req.getParameterValues("7mark"); 
					 pid8= req.getParameterValues("8examcode"); 
					 pcode8= req.getParameterValues("8mark"); 
					 pid9= req.getParameterValues("9examcode"); 
					 pcode9= req.getParameterValues("9mark"); 
					 pid10= req.getParameterValues("10examcode"); 
				     pcode10= req.getParameterValues("10mark");
				}
				/**This function is for getting the modified examcode and marks for inserting into Exam_Paper_Table*/
				else if(req.getParameter("access").equals("modexampaper"))
				{
					try
					{
						ep.delete(c);
					} 
					catch (ClassNotFoundException e2) 
					{
						req.setAttribute("exc", e2.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e2)
					{
						req.setAttribute("exc", e2.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					 pid1= req.getParameterValues("1modexamcode"); 
					 pcode1= req.getParameterValues("1modmark"); 
					 pid2= req.getParameterValues("2modexamcode"); 
					 pcode2= req.getParameterValues("2modmark"); 
					 pid3= req.getParameterValues("3modexamcode"); 
					 pcode3= req.getParameterValues("3modmark"); 
					 pid4= req.getParameterValues("4modexamcode"); 
					 pcode4= req.getParameterValues("4modmark"); 
					 pid5= req.getParameterValues("5modexamcode"); 
					 pcode5= req.getParameterValues("5modmark"); 
					 pid6= req.getParameterValues("6modexamcode"); 
					 pcode6= req.getParameterValues("6modmark"); 
					 pid7= req.getParameterValues("7modexamcode"); 
					 pcode7= req.getParameterValues("7modmark"); 
					 pid8= req.getParameterValues("8modexamcode"); 
					 pcode8= req.getParameterValues("8modmark"); 
					 pid9= req.getParameterValues("9modexamcode"); 
					 pcode9= req.getParameterValues("9modmark"); 
					 pid10= req.getParameterValues("10modexamcode"); 
					 pcode10= req.getParameterValues("10modmark");
				}
				/**This function is for inserting the examcode and marks into the Exam_Paper_Table*/
				if(req.getParameter("access").equals("modexampaper") || req.getParameter("access").equals("setexampaper"))
				{
					int i= 0;
					try 
					{
						pap= ep.selectPaperBeanfromcoursetable(c);
						if(pap.size() != 0)
						{
							ep.insertexampaper(pid1,pcode1,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 1)
						{
							ep.insertexampaper(pid2,pcode2,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 2)
						{
							ep.insertexampaper(pid3,pcode3,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 3)
						{
							ep.insertexampaper(pid4,pcode4,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 4)
						{
							ep.insertexampaper(pid5,pcode5,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 5)
						{
							ep.insertexampaper(pid6,pcode6,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 6)
						{
							ep.insertexampaper(pid7,pcode7,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 7)
						{
							ep.insertexampaper(pid8,pcode8,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 8)
						{
							ep.insertexampaper(pid9,pcode9,c,pap.get(i).getPaper_id());
							i++;
						}
						if(pap.size() > 9)
						{
							ep.insertexampaper(pid10,pcode10,c,pap.get(i).getPaper_id());
							i++;
						}
						p1= ep.selectPaperBeanfromcoursetable(c);
						p2= ep.selectpid(c);
						ep1= ep.selectexamdetails(c);
						p3= ep.selectPaperBean(c);
						req.setAttribute("coursesempaper",p1);
						req.setAttribute("pid",p2);
						req.setAttribute("examdetails",ep1);
						req.setAttribute("papers", p3);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/ExamSeePapers.jsp";
				}
				/**This function is for viewing the starting page of the Exams Marks*/
				else if(req.getParameter("access").equals("cancel"))
				{
					try
					{
						e= pc.selectcourse();
						req.setAttribute("course",e);
					} 
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					url= "/ExamListCourseBatchYearSemester.jsp";
				}
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
			}
		}
	}
	
	public void studentmarkService(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PaperCourseDB pc= new PaperCourseDB();
		ExamPaperDB ep= new ExamPaperDB();
		StudentsMarksDB sm= new StudentsMarksDB();
		PrintWriter out= res.getWriter();
		String url= "";
		ArrayList<Papers_Course> e= new ArrayList<Papers_Course>();
		ArrayList<Student> sm1= new ArrayList<Student>();
		ArrayList<Student> sm2= new ArrayList<Student>();
		ArrayList<Student> sm3= new ArrayList<Student>();
		String coursename= req.getParameter("smcoursename");
		String yr= req.getParameter("smyear");
		String sem= req.getParameter("smsemester");
		ArrayList<Papers_Course> years= new ArrayList<Papers_Course>();
		String ba= req.getParameter("smbatch");
		String module= req.getParameter("module");
		Papers_Course c= new Papers_Course();
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		String access= req.getParameter("access");
		ArrayList<ExamPaper> ep1= new ArrayList<ExamPaper>();
		ArrayList<ExamPaper> ep2= new ArrayList<ExamPaper>();
		Papers_Course p4= new Papers_Course();
		String students[]= null,mark1[] = null,mark2[] = null,mark3[] = null,mark4[] = null,mark5[] = null,mark6[] = null,mark7[] = null;
		int year= 0,semester= 0,cid= 0;
		
		if((yr != null) && !yr.equals(""))
		{
			year= Integer.parseInt(yr);
			c.setYear(year);
		}
		if((sem != null) && !sem.equals(""))
		{
			semester= Integer.parseInt(sem);
			c.setSemester(semester);
		}
		if((coursename != null) && !coursename.equals(""))
		{
			cid= Integer.parseInt(coursename);
			c.setCourse_id(cid);
		}
		if((ba != null) && !ba.equals(""))
		{
			int batch= Integer.parseInt(ba);
			c.setBatch(batch);
			try
			{
				int duration= pc.duration(c);
				c.setDuration(duration);
			}
			catch (ClassNotFoundException e1)
			{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
			} 
			catch (SQLException e1)
			{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
			}
		}
		req.setAttribute("coursename", c);
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			/**This function is for viewing the starting page of the Student Marks*/
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					e= pc.selectcourse();
					req.setAttribute("course",e);
				} 
				catch (ClassNotFoundException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				} 
				catch (SQLException e1)
				{
					req.setAttribute("exc", e1.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				url= "/SMListCourseBatchYearSemester.jsp";
				RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
		   	}
			else if(module.equals("marksstudents"))
			{
				/**This function is for checking weather is there any data of the particular year is present in P_C_T and P_T_T and E_P_T*/
				if(req.getParameter("access").equals("smcheck"))
				{
					try 
					{
						c1= pc.selectforpaperbatch();
						years= pc.selectyears(c);
						req.setAttribute("years",years);
						boolean check= ep.checkforpaperbatch(c,c1);
						if(!check)
						{
							c1= ep.selectforexambatchcourse();
							boolean checkep= ep.checkforpaperbatch(c,c1);
							if(!checkep)
							{
								p1= ep.selectPaperBeanfromcoursetable(c);
								req.setAttribute("coursesempaper",p1);
						    	url= "/SMSeePapers.jsp";
							}
							else
								url= "/SMExamNotAllocated.jsp";
						}
						else
							url= "/ExamCheckResult.jsp";
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/**This funcion is for checking weather marks are allocated to students or not*/
				else if(req.getParameter("access").equals("viewmarks"))
				{
					String epid= req.getParameter("smpaper");
					int pid= Integer.parseInt(epid);
					p4.setPaper_id(pid);
					try {
						ep1= sm.selecteidsfromexpaper(c,pid);
						ep2= sm.selecteidsfromsmtable();
						boolean markcheck= sm.isexist(ep1,ep2);
						if(!markcheck)
						{
							sm1= sm.selectsidsfromsmtable();
							p1= ep.selectPaperBeanfromcoursetable(c);
							sm2= sm.selectstudents(c);
							req.setAttribute("selectedpaperexams",ep1);
							req.setAttribute("coursesempaper",p1);
							req.setAttribute("exampaperidsandmarks", ep2);
							req.setAttribute("studentmarks", sm1);
							req.setAttribute("selected paper", p4);
							req.setAttribute("allstudents", sm2);
							url= "/SMSeeMarks.jsp";
						}
						else
						{
							p1= ep.selectPaperBeanfromcoursetable(c);
							req.setAttribute("coursesempaper",p1);
							req.setAttribute("selected paper", p4);
							url= "/SMNotSet.jsp";
						}
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/**This function fetches the students if present from database and also the exams and marks conducted for a particular paper*/
				else if(req.getParameter("access").equals("setmarks"))
				{
					String epid= req.getParameter("smpaper");
					int pid= Integer.parseInt(epid);
					p4.setPaper_id(pid);
					try 
					{
						ep1= sm.selecteidsfromexpaper(c,pid);
						sm1= sm.selectstudents(c);
						p1= ep.selectPaperBeanfromcoursetable(c);
						req.setAttribute("coursesempaper",p1);
						req.setAttribute("selectedpaperexams",ep1);
						req.setAttribute("allstudents", sm1);
						req.setAttribute("selected paper", p4);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					if(ep1.size() != 0)
					{
						if(sm1.size() != 0)
							url= "/SMSetMarks.jsp";
						else
							url="/SMNoStudents.jsp";
					}
					else
						url="/SMExamNotAllocated.jsp";
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/**This function is for getting the marks of students*/
				else if(req.getParameter("access").equals("setmarkstostudents"))
				{
					students= req.getParameterValues("student");
					mark1= req.getParameterValues("1smmark");
					mark2= req.getParameterValues("2smmark");
					mark3= req.getParameterValues("3smmark");
					mark4= req.getParameterValues("4smmark");
					mark5= req.getParameterValues("5smmark");
					mark6= req.getParameterValues("6smmark");
					mark7= req.getParameterValues("7smmark");
					
				}
				/**This function is for getting the modified marks of students*/
				else if(req.getParameter("access").equals("modmarkstostudents"))
				{
					students= req.getParameterValues("modstudent");
					mark1= req.getParameterValues("mod1smmark");
					mark2= req.getParameterValues("mod2smmark");
					mark3= req.getParameterValues("mod3smmark");
					mark4= req.getParameterValues("mod4smmark");
					mark5= req.getParameterValues("mod5smmark");
					mark6= req.getParameterValues("mod6smmark");
					mark7= req.getParameterValues("mod7smmark");
				}
				/**This function is for inserting the marks of students into Student_Marks_Table*/
				if(req.getParameter("access").equalsIgnoreCase("setmarkstostudents")
						|| req.getParameter("access").equalsIgnoreCase("modmarkstostudents"))
				{
					String epid= req.getParameter("smpaper");
					int pid= Integer.parseInt(epid);
					p4.setPaper_id(pid);
					try
					{
						sm2= sm.selectstudents(c);
						ep1= sm.selecteidsfromexpaper(c,pid);
						sm.deletefromsm(ep1);
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					try
					{
						int i= 0;
						if(ep1.size() >= 1)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark1);
							i++;
						}
						if(ep1.size() >= 2)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark2);
							i++;
						}
						if(ep1.size() >= 3)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark3);
							i++;
						}
						if(ep1.size() >= 4)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark4);
							i++;
						}
						if(ep1.size() >= 5)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark5);
							i++;
						}
						if(ep1.size() >= 6)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark6);
							i++;
						}
						if(ep1.size() >= 7)
						{
							sm.insertstudentmarks(ep1.get(i).getExam_paper_id(),students,mark7);
							i++;
						}
						ep2= sm.selecteidsfromsmtable();
						sm1= sm.selectsidsfromsmtable();
						p1= ep.selectPaperBeanfromcoursetable(c);
						sm2= sm.selectstudents(c);
					}
					catch (ClassNotFoundException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (SQLException e1)
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					req.setAttribute("selectedpaperexams",ep1);
					req.setAttribute("coursesempaper",p1);
					req.setAttribute("exampaperidsandmarks", ep2);
					req.setAttribute("studentmarks", sm1);
					req.setAttribute("selected paper", p4);
					req.setAttribute("allstudents", sm2);
					if(sm1.size() != 0)
						url= "/SMSeeMarks.jsp";
					else
						url= "/SMNotSet.jsp";
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/**This function is for getting the student marks from S_M_T for modifying them*/
				else if(req.getParameter("access").equals("modifymarks"))
				{
					String epid= req.getParameter("smpaper");
					int pid= Integer.parseInt(epid);
					p4.setPaper_id(pid);
					try 
					{
						ep1= sm.selecteidsfromexpaper(c,pid);
						ep2= sm.selecteidsfromsmtable();
						sm1= sm.selectsidsfromsmtable();
						sm3= sm.distinctselectsidsfromsmtable();
						p1= ep.selectPaperBeanfromcoursetable(c);
						sm2= sm.selectstudents(c);
					}
					catch (ClassNotFoundException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					} 
					catch (SQLException e1) 
					{
						req.setAttribute("exc", e1.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					req.setAttribute("selectedpaperexams",ep1);
					req.setAttribute("coursesempaper",p1);
					req.setAttribute("exampaperidsandmarks", ep2);
					req.setAttribute("studentmarks", sm1);
					req.setAttribute("selected paper", p4);
					req.setAttribute("allstudents", sm2);
					req.setAttribute("noofstudents", sm3);
					url= "/SMModifyMarks.jsp";
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/**This function is for viewing the Starting page of the Student Marks*/
				else if(req.getParameter("access").equals("cancel"))
				{
					try {
						e= pc.selectcourse();
						req.setAttribute("course",e);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
					} catch (SQLException e1) {
						e1.printStackTrace();
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
					}
					url= "/SMListCourseBatchYearSemester.jsp";
					RequestDispatcher dispatcher= req.getRequestDispatcher(url);
					dispatcher.forward(req, res);
				}
				/*RequestDispatcher dispatcher= req.getRequestDispatcher(url);
				dispatcher.forward(req, res);*/
			}
		}
	}
	
	public void Frameservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/campusteacher.html").forward(req, res);
		return;
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String module= req.getParameter("module");
		if( module == null)
			module= "Frames";
		if( module.equalsIgnoreCase("coursepaper"))
			papercourseService(req,res);
		if( module.equalsIgnoreCase("teacherpaper"))
			paperteacherService(req,res);
		if( module.equalsIgnoreCase("exampaper"))
			exampaperService(req,res);
		if( module.equalsIgnoreCase("marksstudents"))
			studentmarkService(req,res);
		if(module.equalsIgnoreCase("Frames"))
			Frameservice(req, res);
	}
}