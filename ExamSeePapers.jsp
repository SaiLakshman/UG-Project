<html>
<head>
<title>View Syllabus</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "examseepaperForm" method= "post" action="/Project1/campusteacher">
<%
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("coursesempaper");
ArrayList<Papers_Course> p1= (ArrayList<Papers_Course>) request.getAttribute("pid");
ArrayList<ExamPaper> ep= (ArrayList<ExamPaper>) request.getAttribute("examdetails");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
%>
<h1><u>View Exams of <%=c.getCourse_name()%> <%=c.getBatch()%> batch.</u></h1>
<table>

<tr></tr><tr></tr><tr></tr>
<td Class= "sai14"><strong><u><%=c.getSemester()%> SEM:</u></strong></td></tr><tr></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
			
		%>
					<tr><td Class= "labelred" colspan= "9" align="center"><strong><u><%=pap.get(cnt).getPaper_code()%> --
					<%=pap.get(cnt).getPaper_title()%></br>&nbsp;</u></strong></td></tr>
					<tr><%
						for(int i= 0;i<ep.size();i++)
						{
							if(p1.get(i).getPaper_id() == pap.get(cnt).getPaper_id())
							{
					%>
					<td class= "sai1b">Exam Code:<%=ep.get(i).getExam_code()%></td>
					<td class= "sai11">Marks:<%=ep.get(i).getMarks()%></td>
							<%}
						}%>	
		<%
	}
	%>
</tr>
<td><input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()"></td>
<td align="center"><input type= "button" name= "coursepaper" value="Modify" onclick= "javascript:modifyexam()"></td></tr>

</table>
<input type= "hidden" name= "module" value= "exampaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "ecoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "ebatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "year" value= "<%=c.getYear()%>">
<input type= "hidden" name= "semester" value= "<%=c.getSemester()%>">
</form>
</body>
</html>
