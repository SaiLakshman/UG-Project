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
<%int year= Calendar.getInstance().getWeekYear();%>
<body>
<center>

<h1>Result</h1>
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("course");
 ArrayList<Papers_Course> years= (ArrayList<Papers_Course>) request.getAttribute("years");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");%>

<form name= "coursepapercheckForm" method= "post" action="/Project1/campusteacher">
<table>
<tr><td>The Syllabus is not present for</td></tr>
<tr>
<td><strong>Course:<%=c.getCourse_name()%></strong>
</td>
<td><strong>Batch:<%=c.getBatch()%></strong></td>
<tr><td align="right"><input type= "button" name= "coursepapers" value="Set New Syllabus" onclick= "javascript:setpaper()"></td></tr>
</table>

<table>
<tr>
 <td>Batch:</td>
<td><select name= "copybatch" id= "batch">
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
<tr><td align="right"><input type="button" name= "copy existing" value="COPY FROM EXISTING" onclick= "javascript:copydraft()"></td></tr>
</table>

<input type= "hidden" name= "module" value= "coursepaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">
</form>
</body>
</html>
