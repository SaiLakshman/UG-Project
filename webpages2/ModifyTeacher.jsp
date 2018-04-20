<html>
<head>
<title>Teacher Form</title>
<script type= "text/javascript"
src="CA.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import="java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<%
   TeacherBean show= (TeacherBean)request.getAttribute("inse");
   ArrayList<DepartmentBean> dept= (ArrayList<DepartmentBean>)request.getAttribute("dep");
%>
<h1 align= "center">Modifying <i><font color="blue"><%= show.getTeachername()%></i></font> Details</h1>
<form name="formModifyTeacher" method= "post" action="/Project1/campusadmin">
<table cellspacing= "5" cellpadding= "5" border= "0" align="center">
<tr>
	<td class="label">Name</td>
	<td class= "labelred"> <input name= "Name" type= "text" value="<%=show.getTeachername()%>"></td>
</tr>
<tr>
	<td class="label">Qualification</td>
	<td><input name= "Qualification" type= "text" value="<%=show.getQualification()%>"></td>
</tr>
<tr>
	<td class="label">Position</td>
	<td><input name= "Position" type= "text" value="<%=show.getPosition()%>"></td>
</tr>
<td>Department</td>
	<td> <select name= "DepartmentId">
    	<% for(int k= 0;k<dept.size();k++)
       	{ if(show.getDepartmentid() == dept.get(k).getDepartmentid()){%>
           <option value= "<%= dept.get(k).getDepartmentid()%>"selected><%= dept.get(k).getDepartmentname() %>
	<%} else{%>
                 <option value= "<%= dept.get(k).getDepartmentid()%>"><%= dept.get(k).getDepartmentname() %><%}%>
    	<% }%>
     	</select>
    	</td>
<tr>
	<td class="label"><input type= "button" name= "back" value= "CANCEL" onclick="javascript:cancelteacher()"></td>
	<td class="label" align="right"><input type= "button" name= "change" value= "UPDATE" onclick="javascript:modifyteacher(<%= show.getTeacherid()%>)"></td>
</tr>
</table>
<tr>
	<input type= "hidden" name="module" value="teacher">
	<input type= "hidden" name="access" value="">
	<input type="hidden"  name="teacher_id" value="">
</tr>
</form>
</body>
</html>
