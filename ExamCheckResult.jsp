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
<%Papers_Course c= (Papers_Course)request.getAttribute("coursename");%>

<form name= "exampapercheckForm" method= "post" action="/Project1/campusteacher">
<table>
<tr><td>The Syllabus is not present for</td></tr>
<tr>
<td><font color="red"><strong>Course:<%=c.getCourse_name()%></font>,</strong>
<font color="blue"><strong>Batch:<%=c.getBatch()%></font>,</strong>
<font color="green"><strong>Year:<%=c.getYear()%></font>,</strong>
<font color="orange"><strong>Semester:<%=c.getSemester()%>.</font></strong></td>
<tr><td align="right"><input type= "button" name= "coursepapers" value="Back" onclick= "javascript:Cancel()"></td></tr>
</table>
<input type= "hidden" name= "module" value= "exampaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "ecoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "ebatch" value= "<%=c.getBatch()%>">
</form>
</body>
</html>
