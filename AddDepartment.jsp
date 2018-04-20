<html>
<head>
<title>Department Form</title>
</head>
<%@ page errorPage="/ErrorPage.jsp" %>
<link rel= stylesheet href= "style.css">
<script type= "text/javascript"
src="CA.js"></script>
<body>
<h1 align= "center">Please Enter the Details</h1>
<form name="formAddDepartment" method= "post" action="/Project1/campusadmin">
<table class= "Border" align="center">
<tr>
<td class= "sai1">Department Name</td>
<td> <input class= "text1" name= "Name"  id="1" type= "text"></td>
</tr>

<tr>
<td class= "sai1">Department Title</td>
<td> <input class= "text1" name= "Title"  id="2" type= "text"></td>
</tr>

<tr>
<td><input type= "button" name= "delete" value= "CANCEL" onclick="javascript:canceldepartment()" ></td>
<td align= "right"><input type= "button" name= "add" value= "ADD" onclick="javascript:insertdepartment()"></td>
</tr>
</table>
<input type="hidden" name= "department_id"value="">
<input type= "hidden" name="module" value="department">
<input type= "hidden" name="access" value="">
</form>
</body>
</html>
