<html>
<head>
<title>Checking with Database</title>
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

<h1>Result</h1>
<%Papers_Course c= (Papers_Course)request.getAttribute("coursename");
 ArrayList<Papers_Course> years= (ArrayList<Papers_Course>) request.getAttribute("years");%>

<form name= "teacherpapercheckForm" method= "post" action="/Project1/campusteacher">
<table>
<tr><td>The Syllabus is not present for</td></tr>
<tr>
<td><strong>Course:<%=c.getCourse_name()%></strong>
</td>
<td><strong>Batch:<%=c.getBatch()%></strong></td>
<tr><td align="right"><input type= "button" name= "coursepapers" value="Back" onclick= "javascript:Cancel()"></td></tr>
</table>
<table>
<tr>
 <td>Batch:</td>
<td><select name= "copyteacherbatch" id= "teacherbatch">
<option value="">SELECT</option>
<%
for(int i= 0; i < years.size(); i++)
{
%>
<option value= "<%=years.get(i).getBatch()%>"><%= years.get(i).getBatch()%></option>
<%
}
%>
</select> </td></tr>
<tr><td align="right"><input type="button" name= "copy from existing" value="COPY FROM EXISTING" onclick= "javascript:copyteacherpaperdraft()"></td></tr>
</table>

<input type= "hidden" name= "module" value= "teacherpaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">
</form>
</body>
</html>
