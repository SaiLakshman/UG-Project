<html>
<head>
<title>Teacher Form</title>
</head>
<script type= "text/javascript"
src="CA.js"></script>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<link rel= stylesheet href= "style.css">

<body>
<%
   ArrayList<DepartmentBean> show= (ArrayList<DepartmentBean>)request.getAttribute("dep");
%>
<h1 align= "center">Please Enter the Details</h1>
<form name="formAddTeacher" method= "post" action="/Project1/campusadmin">
<table cellspacing= "5" cellpadding= "5" border= "0" align="center">
<tr>
	<td class= "sai1">Name</td>
	<td> <input class= "text1" name= "Name"  id="1"type= "text"></td>
</tr>
<tr>
	<td class= "sai1">Qualification</td>
	<td ><input class= "text1" name= "Qualification" id="2" type= "text"</td>
</tr>
<tr>
	<td class= "sai1">Position</td>
	<td ><input class= "text1" name= "Position" id="3" type= "text"</td>
</tr>
<tr>
 	<td class= "sai1">Department</td>
	<td> <select name= "DepartmentId" id="4">
        <option value= "">SELECT
    	<% for(int k= 0;k<show.size();k++)
       	{ %>
           <option value= "<%= show.get(k).getDepartmentid()%>"><%= show.get(k).getDepartmentname() %>
    	<% }%>
     	</select>
    	</td>
</tr>
<tr>
	<td class= "sai1"><input type= "button" name= "delete" value= "CANCEL" onclick="javascript:cancelteacher()" ></td>
	<td class= "sai1" align= "right"><input type= "button" name= "add" value= "ADD" onclick="javascript:insertteacher()"></td>
</tr>
</table>
<input type= "hidden" name="module" value="teacher">
<input type= "hidden" name="access" value="">
</form>
</body>
</html>
