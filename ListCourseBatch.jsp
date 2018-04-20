<html>
<head>
<title>course papers list</title>
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
<%		int year= Calendar.getInstance().getWeekYear();
		//int month= Calendar.getInstance().MONTH;
		//year= year-1;
%>
<body>
<center>

<h1>Select a course</h1>
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("course");%>
<table>
<form name= "coursepaperForm" method= "post" action="/Project1/campusteacher">
<tr>
<td Class="sai1b"><strong>Course:</strong>
<select name="coursename" id="coursename">
<option value="">SELECT</option>
<%
 for(int i= 0;i < show.size();i++)
{
%>
<option value="<%= show.get(i).getCourse_id() %>"><%=show.get(i).getCourse_name()%></option>
<%
}
%>
</select> </td></tr>
<tr>
<td Class= "sai1b"><strong>Batch:</strong>
<select name= "batch" id= "batch">
<option value="">SELECT</option>
<%
for(int i= 5; i > -5; i--)
{
%>
<option value= "<%=year-1-i%>"><%= year-1-i%></option>
<%
}
%>
</select> </td></tr>
<input type= "hidden" name= "Course_Id" value= "">
<input type= "hidden" name= "module" value= "coursepaper">
<input type= "hidden" name= "access" value= "">

</form>
<tr><td align="center"><input type= "button" name= "coursepapers" value="View Syllabus" onclick= "javascript:checkpaper()"></td></tr>
</table></center>
</body>
</html>
