<html>
<head>
<title>Department Form</title>
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
   DepartmentBean show= (DepartmentBean)request.getAttribute("inse");
%>
<h1 align= "center">Modifying <%= show.getDepartmentname()%>'s Details</h1>
<form name="formModifyDepartment" method= "post" action="/Project1/campusadmin">
<table cellspacing= "5" cellpadding= "5" border= "0" align="center">
<tr>
<td>Department Name</td>
<td> <input name= "Name" type= "text" value="<%=show.getDepartmentname()%>"></td>
</tr>

<td>Department Title</td>
<td> <input name= "Title" type= "text" value="<%=show.getDepartmenttitle()%>"></td>
</tr>

<tr>
<td><input type= "button" name= "back" value= "CANCEL" onclick="javascript:canceldepartment()"></td><td></td>
<td><input type= "button" name= "change" value= "UPDATE" onclick="javascript:modifydepartment(<%= show.getDepartmentid()%>)"></td>
</tr>
</table>
<tr>
<input type= "hidden" name="module" value="department">
<input type= "hidden" name="access" value="">
<input type="hidden"  name="department_id" value=""></td>
</tr>
</form>
</body>
</html>
