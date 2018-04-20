package bca.batch2011.project1.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bca.batch2011.project1.ha.SRD;
import bca.batch2011.project1.ha.SRD_DB;

public class Exam 
{
	private int ExamId;
	private String ExamCode,ExamTitle;

	/**
	 * Default constructor to initialize the member variables
	 * */
	public Exam()
	{
		ExamId= 0;
		ExamCode= "";
		ExamTitle= "";
	}

	/**
	 * Multiple argument constructor to initialize the member variables with the parameters
	 * */
	public Exam(int examId, String examCode, String examTitle)
	{
		ExamId = examId;
		ExamCode = examCode;
		ExamTitle = examTitle;
	}
	
	/**
	 * The following are the Getter-Setter methods for the member variables
	 * */
	public int getExamId()
	{
		return ExamId;
	}

	public void setExamId(int examId)
	{
		ExamId = examId;
	}

	public String getExamCode()
	{
		return ExamCode;
	}

	public void setExamCode(String examCode)
	{
		ExamCode = examCode;
	}

	public String getExamTitle()
	{
		return ExamTitle;
	}

	public void setExamTitle(String examTitle)
	{
		ExamTitle = examTitle;
	}
	
	/**
	 * This method captures the value from the jsps
	 * */
	public static void fillExam(Exam exam,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{	
		exam.setExamCode(req.getParameter("examcode"));
		exam.setExamTitle(req.getParameter("examtitle"));
		return;
	}
	
	/**
	 * This method checks and then inserts into database by calling the database method
	 * */
	public static void insertExam(Exam exam,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		ExamDB insertExam= new ExamDB();
		ArrayList<Exam> examArray= new ArrayList<Exam>();
		fillExam(exam, req);
		examArray= insertExam.select();
		boolean isAbsent= insertExam.checkIfExist(exam,examArray);
		if(isAbsent == true)
			insertExam.insert(exam);
		return;
	}
	
	/**
	 * This method is called for updating the data
	 * */
	public static void updateExam(Exam exam,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		fillExam(exam, req);
		ExamDB update= new ExamDB();
		int examId= Integer.parseInt(req.getParameter("examId"));
		exam.setExamId(examId);
		update.update(exam,examId);
		return;
	}
	
	/**
	 * This method captures the Id's inorder to delete from the database
	 * */
	public static void deleteExam(HttpServletResponse res,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		PrintWriter out= res.getWriter();
		ExamDB delExam= new ExamDB();
		String[] str= req.getParameterValues("deleteBox");
		String examIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					examIds= examIds.concat(str[i]);
				else
					examIds= examIds.concat(str[i]+",");
			}
		}
		delExam.delete(examIds);
		return;
	}
}