package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CA_ControllerServlet extends HttpServlet
{
	/**This is the function for Student Module*/
	public void studentService(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out= res.getWriter();
		String access= req.getParameter("access");
		ArrayList<Student> studentarray= new ArrayList<Student>();
		ArrayList<Course>coursearray=new ArrayList<Course>();
		Student student= new Student();
		StudentDB ins= new StudentDB();
		CourseDB course= new CourseDB();
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
				try
				{
					studentarray= ins.select();
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
				req.setAttribute("in",studentarray);
				req.getRequestDispatcher("/ListStudents.jsp").forward(req, res);
				return;
			}
		
			/**If Add New Student button is Clicked*/
			if(access.equalsIgnoreCase("Add New Student"))
			{
				try
				{
					coursearray=course.select();
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
				req.setAttribute("course", coursearray);
				req.getRequestDispatcher("/AddStudent.jsp").forward(req, res);
				return;
			}
		
			/**It will insert into the database*/
			if(access.equalsIgnoreCase("insertstudent"))
			{
				try
				{
					student.insertStudent(student, req,out);
					studentarray= ins.select();
					boolean isAbsent= ins.checkIfExist(student, studentarray,out);
					if(isAbsent == true)
					{
						ins.insert(student);
						studentarray= ins.select();
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
				req.setAttribute("in", studentarray);
				req.getRequestDispatcher("/ListStudents.jsp").forward(req, res);
				return;
			}
		
			/**for viewing the particular student*/
			if(access.equalsIgnoreCase("viewstudent"))
			{
				int studentId= Integer.parseInt(req.getParameter("studentId"));
				Student view= new Student();
				view.setStudentId(studentId);
				CourseDB courseDB= new CourseDB();
				if(studentId != 0)
				{
					try
					{
						coursearray=courseDB.select();
						req.setAttribute("coursearray",coursearray);
						view= ins.selectbyid(view);
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
				String url="/ViewStudent.jsp";
				req.setAttribute("view1", view);
				req.setAttribute("coursearray", coursearray);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
		
			/**Modification of the Student*/
			if(access.equalsIgnoreCase("modifystudent"))
			{
				int studentId= Integer.parseInt(req.getParameter("studentId"));
				Student up= new Student();
				up.setStudentId(studentId);
				if(studentId != 0)
				{
					try
					{
						coursearray= course.select();
						up= ins.selectbyid(up);
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
				req.setAttribute("course", coursearray);
				req.setAttribute("up", up);
				req.getRequestDispatcher("/ModifyStudent.jsp").forward(req, res);
				return;
			}
			
			/**It will update the database*/
			if(access.equalsIgnoreCase("updatestudent"))
			{
				student.setStudentId(Integer.parseInt(req.getParameter("studentId")));
				Course cour= new Course();
				cour.setCourseid(Integer.parseInt(req.getParameter("courseId")));
				try
				{
					student.insertStudent(student,req,out);
					ins.update(student);
					studentarray= ins.select();
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
				req.setAttribute("in", studentarray);
				req.getRequestDispatcher("/ListStudents.jsp").forward(req, res);
				return;
			}
		
			/**for deletion of a particular Student*/
			else if(access.equalsIgnoreCase("deletestudent"))
			{
				Student del= new Student();
				try
				{
					del.deleteStudent(res,req);
					studentarray= ins.select();
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
				req.setAttribute("in", studentarray);
				req.getRequestDispatcher("/ListStudents.jsp").forward(req, res);
				return;
			}
		}
	}
	
	/**This is the function for Exam Module*/
	public void examService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out= res.getWriter();
		ExamDB ins= new ExamDB();
		ArrayList<Exam> show= new ArrayList<Exam>();
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
				req.getRequestDispatcher("/ListExams.jsp").forward(req, res);
				return;
			}
			
			/**If new Exam is to be added*/
			if(access.equalsIgnoreCase("Add New Exam"))
			{
				req.getRequestDispatcher("/AddExam.jsp").forward(req, res);
				return;
			}
			
			/**For inserting into database*/
			if(access.equalsIgnoreCase("insertexam"))
			{
				Exam exam= new Exam();
				try
				{
					exam.insertExam(exam, req);
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
				req.getRequestDispatcher("/ListExams.jsp").forward(req, res);
				return;
			}
			
			/**For Modifying the Exam*/
			if(access.equalsIgnoreCase("modifyexam"))
			{
				String examId= req.getParameter("examId");
				Exam update= new Exam();
				if(examId != null)
				{
					try
					{
						update= ins.selectbyid(examId,out);
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
				req.getRequestDispatcher("/ModifyExam.jsp").forward(req, res);
				return;
			}
			
			/**It will update the database*/
			if(access.equalsIgnoreCase("updateexam"))
			{
				Exam exam= new Exam();
				try
				{
					exam.updateExam(exam, req);
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
				req.getRequestDispatcher("/ListExams.jsp").forward(req, res);
				return;
			}
			
			/**It will delete the Exam*/
			if(access.equalsIgnoreCase("deleteexam"))
			{
				Exam del= new Exam();
				try
				{
					del.deleteExam(res, req);
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
				req.getRequestDispatcher("/ListExams.jsp").forward(req, res);
				return;
			}
		}
	}
	
	
	
	public void semesterService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String access= req.getParameter("access");
		SemesterDB semDB= new SemesterDB();
		PrintWriter out= res.getWriter();
		ArrayList<Semester> semArray= null;
		if(access == null)
			access= "updatesem";
		if(access.equalsIgnoreCase("updatesem"))
		{
			String[] years= req.getParameterValues("year");
			String[] semesters= req.getParameterValues("semester");
			String[] sDates= req.getParameterValues("sdate");
			String[] eDates= req.getParameterValues("edate");
			for(int i= 0; i < years.length; i++)
			{
				if(!sDates[i].trim().isEmpty() && !eDates[i].trim().isEmpty())
				{
					try {
						semDB.update(Integer.parseInt(years[i]), Integer.parseInt(semesters[i]), Date.valueOf(sDates[i]), Date.valueOf(eDates[i]),out);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		try {
			semArray= semDB.select(out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("arraylist", semArray);
		req.getRequestDispatcher("/SemesterSetup.jsp").forward(req, res);
		return;
	}	

	
	
	
	/**This is the function for Semester Module*//*
	public void semesterService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String access= req.getParameter("access");
		SemesterDB semDB= new SemesterDB();
		ArrayList<Semester> semArray= null;
		PrintWriter out= res.getWriter();
		if(access == null)
			access= "updatesem";
		if(access.equals("updatesem"))
		{
			String[] years= req.getParameterValues("year");
			String[] semesters= req.getParameterValues("semester");
			String[] sDates= req.getParameterValues("sdate");
			String[] eDates= req.getParameterValues("edate");
			for(int i= 0; i < years.length; i++)
			{
				if(!sDates[i].trim().isEmpty() && !eDates[i].trim().isEmpty())
				{
					try
					{
						semDB.update(Integer.parseInt(years[i]), Integer.parseInt(semesters[i]), Date.valueOf(sDates[i]), Date.valueOf(eDates[i]));
					}
					catch (NumberFormatException e)
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
					catch (SQLException e)
					{
						req.setAttribute("exc", e.getMessage());
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
			}
		}
		try
		{
			semArray= semDB.select();
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
		req.setAttribute("arraylist", semArray);
		req.getRequestDispatcher("/SemesterSetup.jsp").forward(req, res);
		return;
	}*/
	
	/**This is the function for Academic Department Module*/
	public void departmentService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	PrintWriter out=res.getWriter();
		String access=req.getParameter("access");
		String url=null;
		boolean check;
		DepartmentBean dept1=new DepartmentBean();
		ArrayList<DepartmentBean> dept2= new ArrayList<DepartmentBean>();
		DepartmentDB ins= new DepartmentDB();

		if(access == null)
		{
			access= "Frames";
		}
		if(access != null)
		{
			try 
			{
				dept2=ins.select();
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
			url="/ListDepartments.jsp";
			/**For the Add Page*/
			if(access.equalsIgnoreCase("ADDNEWDEPARTMENT"))
			{
				url="/AddDepartment.jsp";
			}
			/**For Deleting the Department*/
			else if(access.equalsIgnoreCase("DELETE"))
			{
				String id= "";
				String [] del= req.getParameterValues("deleteBox"); 
				if(del != null)
				{
				  for(int i= 0;i<del.length;i++)
				  {
					 if(i == del.length - 1)
						 id=id.concat(del[i]);
					 else
						 id= id.concat(del[i]+',');
				  }
				  try 
			  	  {
					 ins.delete(id);
					 dept2=ins.select();
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
				  url= "/ListDepartments.jsp";
				}
				
			}
			/**For Inserting into Database*/
			else if(access.equalsIgnoreCase("ADD"))
			{
				dept1.setDepartmentname(req.getParameter("Name"));
				dept1.setDepartmenttitle(req.getParameter("Title"));
				try
				{
					dept2=ins.select();
					check= ins.isexists(dept1,dept2);
					if(check)
					{
					  ins.insert(dept1);
					  dept2=ins.select();
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
				url="/ListDepartments.jsp";
			}
			/**For Cancellation of the Process*/
			else if(access.equalsIgnoreCase("CANCEL"))
			{
				try 
				{
					dept2=ins.select();
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
				url="/ListDepartments.jsp";
			}
			else if(access.equalsIgnoreCase("MODIFY"))
			{
				DepartmentBean department=new DepartmentBean();
				department.setDepartmentid(Integer.parseInt(req.getParameter("department_id")));
				try
				{
					department=ins.modify(department);
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
				url="/ModifyDepartment.jsp";
				req.setAttribute("inse",department);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
			else if(access.equalsIgnoreCase("UPDATE"))
			{
				dept1.setDepartmentname(req.getParameter("Name"));
				dept1.setDepartmenttitle(req.getParameter("Title"));
				dept1.setDepartmentid(Integer.parseInt(req.getParameter("department_id")));
				try 
				{
					ins.update(dept1);
					dept2=ins.select();
				}
				catch (ClassNotFoundException e) 
				{
					req.setAttribute("exc", e.getMessage());
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				} 
				catch (SQLException e) 
				{
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				url="/ListDepartments.jsp";
				req.setAttribute("inse",dept2);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
		}
		req.setAttribute("inse",dept2);
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		dispatcher.forward(req, res);
    }
    
    /**This is the funtion for Teacher Module*/
	public void teacherService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access=req.getParameter("access");
		String url=null;
		boolean check= false;
		TeacherBean teacher1=new TeacherBean();
		TeacherDB teacherDB= new TeacherDB();
		ArrayList<TeacherBean> teacharray= new ArrayList<TeacherBean>();
		ArrayList<DepartmentBean>deptarray=new ArrayList<DepartmentBean>();
		DepartmentDB departmentDB= new DepartmentDB();
		if(access == null)
		{
			access= "Frames";
		}
		if(access != null)
		{
			try 
			{
				teacharray=teacherDB.selectbydept(out);
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
			url="/ListTeachers.jsp";
			/**For Addition of the Teacher*/
			if(access.equalsIgnoreCase("ADDNEWTEACHER"))
			{
				try
				{
					deptarray=departmentDB.select();
					req.setAttribute("dep",deptarray);
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
				url="/AddTeacher.jsp";
			}
			/**For Deleting the Teacher*/
			else if(access.equalsIgnoreCase("DELETE"))
			{
				String id= "";
				String [] del= req.getParameterValues("deleteBox"); 
				if(del != null)
				{
				  for(int i= 0;i<del.length;i++)
				  {
					 if(i == del.length - 1)
						 id=id.concat(del[i]);
					 else
						 id= id.concat(del[i]+',');
				  }
				  try 
			  	  {
					 teacherDB.delete(id);
					 teacharray=teacherDB.selectbydept(out);
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
				  url= "/ListTeachers.jsp";
				}
			}
			/**For Inserting into the Database*/
			else if(access.equalsIgnoreCase("ADD"))
			{
				teacher1.setTeachername(req.getParameter("Name"));
				teacher1.setQualification(req.getParameter("Qualification"));
				teacher1.setPosition(req.getParameter("Position"));
				teacher1.setDepartmentid(Integer.parseInt(req.getParameter("DepartmentId")));
				try
				{
					teacharray= teacherDB.selectbydept(out);
					check= teacherDB.isexists(teacher1,teacharray);
					if(check == true)
					{
						teacherDB.insert(teacher1);
						teacharray=teacherDB.selectbydept(out);
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
				url="/ListTeachers.jsp";
			}
			/**For Cancellation of the Process*/
			else if(access.equalsIgnoreCase("CANCEL"))
			{
				try 
				{
					teacharray=teacherDB.selectbydept(out);
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
				url="/ListTeachers.jsp";
				req.setAttribute("inse",teacharray);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
				return;
			}
			/**To Modify the information*/
			else if(access.equalsIgnoreCase("MODIFY"))
			{
				TeacherBean teach1=new TeacherBean();
				teach1.setTeacherid(Integer.parseInt(req.getParameter("teacher_id")));
				try
				{
					deptarray=departmentDB.select();
					req.setAttribute("dep", deptarray);
					teach1=teacherDB.modify(teach1);
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
				url="/ModifyTeacher.jsp";
				req.setAttribute("inse",teach1);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
			/**To Update the Database with new Information*/
			else if(access.equalsIgnoreCase("UPDATE"))
			{
				teacher1.setTeachername(req.getParameter("Name"));
				teacher1.setQualification(req.getParameter("Qualification"));
				teacher1.setPosition(req.getParameter("Position"));
				teacher1.setTeacherid(Integer.parseInt(req.getParameter("teacher_id")));
				teacher1.setDepartmentid(Integer.parseInt(req.getParameter("DepartmentId")));
				try 
				{
					teacherDB.update(teacher1);
					teacharray=teacherDB.selectbydept(out);
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
				url="/ListTeachers.jsp";
			}
			req.setAttribute("inse",teacharray);
			RequestDispatcher dispatcher=req.getRequestDispatcher(url);
			dispatcher.forward(req,res);
			return;
		}
	}	
	
	/**This is for Course Module*/
	public void courseService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access=req.getParameter("access");
		String url=null;
		boolean check;
		Course course1=new Course();
		CourseDB courseDB= new CourseDB();
		ArrayList<Course> courarray= new ArrayList<Course>();
		ArrayList<DepartmentBean>deptarray=new ArrayList<DepartmentBean>();
		DepartmentDB departmentDB= new DepartmentDB();
		if(access == null)
		{
			access= "Frames";
		}
		if(access != null)
		{
			try 
			{
				courarray=courseDB.selectbydept();
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
			url="/ListCourses.jsp";
			/**Adding new Course*/
			if(access.equalsIgnoreCase("Add New Course"))
			{
				try
				{
					deptarray=departmentDB.select();
					req.setAttribute("dep",deptarray);
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
				url="/AddCourse.jsp";
			}
			/**For Deleting the Course*/
			else if(access.equalsIgnoreCase("deletecourse"))
			{
				String id= "";
				String [] del= req.getParameterValues("deleteBox"); 
				if(del != null)
				{
				  for(int i= 0;i<del.length;i++)
				  {
					 if(i == del.length - 1)
						 id=id.concat(del[i]);
					 else
						 id= id.concat(del[i]+',');
				  }
				  try 
			  	  {
					 courseDB.delete(id);
					 courarray=courseDB.selectbydept();
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
				  url= "/ListCourses.jsp";
				}
			}
			/**Inserting into the Database*/
			else if(access.equalsIgnoreCase("insertcourse"))
			{
				course1.setCoursename(req.getParameter("coursename"));
				course1.setCoursetitle(req.getParameter("coursetitle"));
				course1.setDuration(Integer.parseInt(req.getParameter("duration")));
				course1.setDepartmentid(Integer.parseInt(req.getParameter("DepartmentId")));
				try
				{
					courarray= courseDB.selectbydept();
					check= courseDB.isexists(course1,courarray);
					if(check == true)
					{
						courseDB.insert(course1);
						courarray=courseDB.selectbydept();
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
				url="/ListCourses.jsp";
			}
			else if(access.equalsIgnoreCase("cancelcourse"))
			{
				try 
				{
					courarray=courseDB.selectbydept();
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
				url="/ListCourses.jsp";
				req.setAttribute("inse",courarray);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req, res);
				return;
			}
			/**For Modification of particular Course's Information*/
			else if(access.equalsIgnoreCase("modifycourse"))
			{
				Course course=new Course();
				course.setCourseid(Integer.parseInt(req.getParameter("courseId")));
				try
				{
					deptarray=departmentDB.select();
					req.setAttribute("dep", deptarray);
					course=courseDB.modify(course);
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
				url="/ModifyCourse.jsp";
				req.setAttribute("inse",course);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
			else if(access.equalsIgnoreCase("updatecourse"))
			{
				course1.setCoursename(req.getParameter("coursename"));
				course1.setCoursetitle(req.getParameter("coursetitle"));
				course1.setDuration(Integer.parseInt(req.getParameter("duration")));
				course1.setCourseid(Integer.parseInt(req.getParameter("courseId")));
				course1.setDepartmentid(Integer.parseInt(req.getParameter("DepartmentId")));
				try 
				{
					courseDB.update(course1);
					courarray=courseDB.selectbydept();
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
				url="/ListCourses.jsp";
			}
			req.setAttribute("inse",courarray);
			RequestDispatcher dispatcher=req.getRequestDispatcher(url);
			dispatcher.forward(req,res);
			return;
		}
	}	
	
	/**This is the function for Paper Module*/
	public void paperService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String access=req.getParameter("access");
		String url=null;
		boolean check;
		PaperBean paper1=new PaperBean();
		ArrayList<PaperBean> paper2= new ArrayList<PaperBean>();
		PaperDB ins= new PaperDB();
		
		if(access == null)
		{
			access = "Frames";
		}
		if(access != null)
		{
			try 
			{
				paper2=ins.select();
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
			url="/ListPapers.jsp";
			/**Adding new Paper*/
			if(access.equalsIgnoreCase("ADDNEWPAPER"))
			{
				url="/AddPaper.jsp";
			}
			/**This Function will Delete the Courses selected*/
			else if(access.equalsIgnoreCase("DELETE"))
			{
				String id= "";
				String [] del= req.getParameterValues("deleteBox"); 
				if(del != null)
				{
				  for(int i= 0;i<del.length;i++)
				  {
					 if(i == del.length - 1)
						 id=id.concat(del[i]);
					 else
						 id= id.concat(del[i]+',');
				  }
				  try 
			  	  {
					 ins.delete(id);
					 paper2=ins.select();
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
				  url= "/ListPapers.jsp";
				}
				
			}
			/**This function will call the Database to Insert*/
			else if(access.equalsIgnoreCase("ADD"))
			{
				paper1.setPapertitle(req.getParameter("Title"));
				try
				{
					paper2=ins.select();
					check= ins.isexists(paper1,paper2);
					if(check)
					{
					  ins.insert(paper1);
					  paper2=ins.select();
					  
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
				url="/ListPapers.jsp";
			}
			/**This funtion is to Cancel the Process*/
			else if(access.equalsIgnoreCase("CANCEL"))
			{
				try 
				{
					paper2=ins.select();
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
				url="/ListPapers.jsp";
			}
			/**This function will modify the Paper*/
			else if(access.equalsIgnoreCase("MODIFY"))
			{
				PaperBean pap=new PaperBean();
				pap.setPaperid(Integer.parseInt(req.getParameter("paper_id")));
				try
				{
					pap=ins.modify(pap);
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
				url="/ModifyPaper.jsp";
				req.setAttribute("inse",pap);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
			/**This function will update te Information*/
			else if(access.equalsIgnoreCase("UPDATE"))
			{
				paper1.setPapertitle(req.getParameter("Title"));
				paper1.setPaperid(Integer.parseInt(req.getParameter("paper_id")));
				try 
				{
					ins.update(paper1);
					paper2=ins.select();
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
				url="/ListPapers.jsp";
				req.setAttribute("inse",paper2);
				RequestDispatcher dispatcher=req.getRequestDispatcher(url);
				dispatcher.forward(req,res);
				return;
			}
		}
		req.setAttribute("inse",paper2);
		RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		dispatcher.forward(req, res);
	}
	
	/**This for the Holiday*/
	public void holidayService(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		AttendenceDB ad= new AttendenceDB();
		HolidayDB hd= new HolidayDB();
		PrintWriter out= res.getWriter();
		ArrayList<Event> e= new ArrayList<Event>();
		String url="";
		String access= req.getParameter("access");
		String starting= req.getParameter("starting");
		String ending= req.getParameter("ending");
		String reason= req.getParameter("reason");
		String holidayeveid= req.getParameter("holeveid");
		Holiday h1= new Holiday();
		ArrayList<Holiday> h= new ArrayList<Holiday>();
		if(holidayeveid != null && holidayeveid != "")
		{
			int holid= Integer.parseInt(holidayeveid);
			h1.setEvent_id(holid);
			try {
				String evename= hd.isid(holid);
				h1.setEvent_name(evename);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
			} catch (SQLException e1) {
				e1.printStackTrace();
				req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
			}
		}
		if(starting != null && starting != "")
		{
			h1.setStarting(starting);
		}
		if(ending != null && ending != "")
		{
			h1.setEnding(ending);
		}
		if(reason != null && reason != "")
		{
			h1.setReason(reason);
		}
		req.setAttribute("holidaydetails", h1);
		
		
		if(access == null)
			access= "Frames";
		if(access != null)
		{
			if(access.equalsIgnoreCase("Frames"))
			{
						url= "/EventHoliday.jsp";
						try {
							e= ad.select();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
							req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
						} catch (SQLException e1) {
							e1.printStackTrace();
							req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
						}
						req.setAttribute("sai",e);
			}
			else if(req.getParameter("access").equals("Modholiday"))
			{
				try {
					
					//boolean check= hd.check(h1,h,out);
					//if(check)
					//{
						hd.inserthol(h1);
						h= hd.select(h1);
						url= "/HolidayDetails.jsp";
						req.setAttribute("hol",h);
					//}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				} catch (SQLException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				}
				
			}
			else if(req.getParameter("access").equals("cancel"))
			{
				try {
					e= ad.select();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				} catch (SQLException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				}
				req.setAttribute("sai",e);
				url= "/EventHoliday.jsp";
			}
			else if(req.getParameter("access").equals("viewholiday"))
			{
				try {
						h= hd.select(h1);
						url= "/HolidayDetails.jsp";
						req.setAttribute("hol",h);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				} catch (SQLException e1) {
					e1.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req,res);
				}
			}
			RequestDispatcher dispatcher= req.getRequestDispatcher(url);
			dispatcher.forward(req, res);
		}
	}
	/**This is the function for Attendance Events*/
	public void attendanceService(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out= res.getWriter();
		AttendenceDB ins= new AttendenceDB();
		ArrayList<Event> show= new ArrayList<Event>();
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
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch(ClassNotFoundException e)
				{
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListEvents.jsp").forward(req, res);
				return;
			}
			
			/**If new Self Reliance Dept. is to be added*/
			if(access.equalsIgnoreCase("Add New Event"))
			{
				req.getRequestDispatcher("/AddEvent.jsp").forward(req, res);
				return;
			}
			
			/**For inserting into database*/
			if(access.equalsIgnoreCase("insertevent"))
			{
				Event event= new Event();
				try
				{
					event.insertEvent(event,req);
					show= ins.select();
				}
				catch (ClassNotFoundException e)
				{
					//e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e)
				{
					//e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListEvents.jsp").forward(req, res);
				return;
			}
			
			/**For Modifying the SRD*/
			if(access.equalsIgnoreCase("modifyevent"))
			{
				String eventId= req.getParameter("EventId");
				Event update= new Event();
				if(eventId != null)
				{
					try
					{
						update= ins.isid(eventId);
					}
					catch (SQLException e)
					{
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
					catch (ClassNotFoundException e)
					{
						req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
						return;
					}
				}
				req.setAttribute("modify", update);
				req.getRequestDispatcher("/ModifyEvent.jsp").forward(req, res);
				return;
			}
			
			/**It will update the database*/
			if(access.equalsIgnoreCase("updateevent"))
			{
				Event event= new Event();
				try
				{
					event.updateEvent(event, req);
					show= ins.select();
				}
				catch (ClassNotFoundException e)
				{
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e)
				{
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListEvents.jsp").forward(req, res);
				return;
			}
			
			/**It will delete the Room*/
			if(access.equalsIgnoreCase("deleteevent"))
			{
				Event del= new Event();
				try
				{
					del.deleteEvent(res, req);
					show= ins.select();
				}
				catch (ClassNotFoundException e)
				{
					//e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				catch (SQLException e)
				{
					//e.printStackTrace();
					req.getRequestDispatcher("/ErrorPage.jsp").forward(req, res);
					return;
				}
				req.setAttribute("show", show);
				req.getRequestDispatcher("/ListEvents.jsp").forward(req, res);
				return;
			}
		}
	}
	/**This is the function for Frame Module*/
	public void Frameservice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/campusadmin.html").forward(req, res);
		return;
	}
	
	/**This is the Servlet doPost*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String module= req.getParameter("module");
		if(module == null)
			module= "frames";
		if(module.equalsIgnoreCase("courses"))
			courseService(req, res);
		if(module.equalsIgnoreCase("exams"))
			examService(req, res);
		if(module.equalsIgnoreCase("semesters"))
			semesterService(req, res);
		if(module.equalsIgnoreCase("students"))
			studentService(req, res);
		if(module.equalsIgnoreCase("department"))
			departmentService(req,res);
		if(module.equalsIgnoreCase("teacher"))
			teacherService(req, res);
		if(module.equalsIgnoreCase("paper"))
			paperService(req, res);
		if(module.equalsIgnoreCase("attendance"))
			attendanceService(req,res);
		if(module.equalsIgnoreCase("holidays"))
			holidayService(req,res);
		if(module.equalsIgnoreCase("frames"))
			Frameservice(req, res);
	}
	
	/**This is the Servlet doGet*/
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		doPost(req,res);
	}
}