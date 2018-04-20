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
<%Papers_Course c= (Papers_Course)request.getAttribute("coursename");%>
<body>
<center>
<h1 class="label"><u>** Result **</u></h1>
<form name= "StudentscheckForm" method= "post" action="/Project1/campusteacher">
<table>
<tr><td>Students are not present for</td>
<td><strong>Course:<%=c.getCourse_name()%></strong>
</td>
<td><strong>Batch:<%=c.getBatch()%></strong>. So it is <font color= "red">impossible</font> to set marks for students</td>
<tr><td align="right"><input type= "button" name= "coursepapers" value="Back" onclick= "javascript:Cancel()"></td></tr>
</table>


<input type= "hidden" name= "module" value= "marksstudents">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "ecoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "ebatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "year" value= "<%=c.getYear()%>">
<input type= "hidden" name= "semester" value= "<%=c.getSemester()%>">
</form>
</body>
</html>
