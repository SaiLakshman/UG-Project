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

<form name= "copyteacherpapercheckForm" method= "post" action="/Project1/campusteacher">
<table>
<tr><td>Teachers are not yet allocated.so it is impossible to set exams for:</td></tr>
<tr>
<td><strong>Course:<%=c.getCourse_name()%></strong>
</td>
<td><strong>Batch:<%=c.getBatch()%></strong></td>
<tr><td align="right"><input type= "button" name= "teachernotpresentpapers" value="Back" onclick= "javascript:Cancel()"></td></tr>
</table>


<input type= "hidden" name= "module" value= "exampaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">
</form>
</body>
</html>
