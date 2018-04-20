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
%>
<body>
<center>

<h1 class="labelred"><u>|| Select a course, Batch ,Year , Semester ||</u></h1>
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("course");%>
<table>
<form name= "ExamcoursepaperForm" method= "post" action="/Project1/campusteacher">
<tr>
<td Class="sai1b"><strong>Course:</strong>
<select name="ecoursename" id="ecoursename">
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
<select name= "ebatch" id= "ebatch">
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
<tr><td class= "sai12">Year: </td><td class= "sai1b"><input type= "radio" name= "year" value= "1" checked>1 </td>
		<td class= "sai13"><input type= "radio" name= "year" value= "2" >2</td>
		<td class= "sai14"><input type= "radio" name= "year" value= "3">3</td>
</tr>
<tr>
<td class= "sai11">Semester: <td class= "sai1b"><input type= "radio" name= "semester" value= "1" checked>1</td>
			     <td class= "sai14"><input type= "radio" name= "semester" value= "2" >2</td>
</tr>
<input type= "hidden" name= "Course_Id" value= "">
<input type= "hidden" name= "module" value= "exampaper">
<input type= "hidden" name= "access" value= "">

</form>
<tr><td align="center"><input type= "button" name= "coursepapers" value="View Exams" onclick= "javascript:checkexam()"></td></tr>
</table></center>
</body>
</html>
