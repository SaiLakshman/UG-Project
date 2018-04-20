<html>
<head>
<title>View Marks</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "StudentmarkssetForm" method= "post" action="/Project1/campusteacher">
<%
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("coursesempaper");
ArrayList<ExamPaper> ep1= (ArrayList<ExamPaper>) request.getAttribute("selectedpaperexams");
ArrayList<ExamPaper> ep2= (ArrayList<ExamPaper>) request.getAttribute("exampaperidsandmarks");
ArrayList<Student> sm1= (ArrayList<Student>) request.getAttribute("studentmarks");
ArrayList<Student> sm2= (ArrayList<Student>) request.getAttribute("allstudents");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
Papers_Course ep= (Papers_Course)request.getAttribute("selected paper");
int total= 0;
%>
<h1 class="labelred"> @ View Marks for <font color="black"><%=c.getCourse_name()%></font> for the batch <font color=" black"><%=c.getBatch()%> </font> for the Year  <font color="black"><%=c.getYear()%></font> And Semester <font color="black"> <%=c.getSemester()%></font></h1>
<h2 class="label" align= "right">*examcode--|marks|</h2>
<table border=3>
<tr></tr><tr></tr><tr></tr><tr>
	<%for(int i= 0;i < pap.size();i++){
		if(pap.get(i).getPaper_id() == ep.getPaper_id()) {%><td class= "sai1b"><strong><u><%=pap.get(i).getPaper_code()%>--<%=pap.get(i).getPaper_title()%> </u></strong></td>
	<%}}%>
	<%for(int i= 0;i < ep1.size();i++){%>
		<th class= "sai1b">*<%=ep1.get(i).getExam_code()%>--|<%=ep1.get(i).getMarks()%>|<%total+= ep1.get(i).getMarks();%></th>
	<%}%><th class= "sai1b">Total--|<%=total%>|</th>
</tr>
<tr><%int z= 0,counter= 0;total= 0;
	for(int l= 0;l<sm1.size();l++)
	{
		for(int m= 0;m<sm2.size();m++)
		{
			if(sm2.get(m).getStudentId() == sm1.get(l).getStudentId())
			{
				if(l == 0){%>
					<td><%=sm2.get(m).getName()%></td><%}
				else if(l != 0 && sm1.get(l).getStudentId() != sm1.get(l-1).getStudentId())
				{%><%for(int i= z-1;i < ep1.size()-1;i++){%><td>--</td><%}%>
					<td><%=total%></td></tr><tr>
					<td><%=sm2.get(m).getName()%></td>
					<%z= 0;total= 0;counter= 0;
				}
				for(int k= 0; k< ep1.size();k++)
				{
					if(ep1.get(k).getExam_paper_id() == ep2.get(l).getExam_paper_id())
					{
						for(int j= z;j< k-1;j++){%>
							<td>--</td><%}%>
						<%if(z != k ){%><td>--</td><%}%>
						<td><%=ep2.get(l).getMarks()%></td>
						<%z= k+1;total+= ep2.get(l).getMarks();counter++;
					}
				}
			}
		}
	}for(int i= z-1;i < ep1.size()-1;i++){%><td>--</td><%}%><td><%=total%></td>
</tr>
<td><input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()"></td>
<%for(int i= 0;i< ep1.size();i++)
{%>
<td></td>
 <%} %>
<td align="right"><input type= "button" name= "coursepaper" value="Modify Marks" onclick= "javascript:modifymarks()"></td></tr>

</table>
<input type= "hidden" name= "module" value= "marksstudents">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "smcoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "smbatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "smyear" value= "<%=c.getYear()%>">
<input type= "hidden" name= "smsemester" value= "<%=c.getSemester()%>">
<input type= "hidden" name= "smpaper" value= "<%=ep.getPaper_id()%>">
</form>
</body>
</html
