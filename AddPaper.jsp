<html>
<head>
<title>Paper Form</title>
</head>
<%@ page errorPage="/ErrorPage.jsp" %>
<link rel= stylesheet href= "style.css">
<script type= "text/javascript"
src="CA.js"></script>
<body>
<h1 align= "center">Please Enter the Details</h1>
<form name="formAddPaper" method= "post" action="/Project1/campusadmin">
<table class= "Border" align="center">
<tr>
	<td class= "sai1">Title</td>
	<td> <input class= "text1" name= "Title" id= "1"type= "text"></td>
</tr>
<tr>
	<td class= "sai1"><input type= "button" name= "delete" value= "CANCEL" onclick="javascript:cancelpaper()" ></td>
	<td class= "sai2" align= "right"><input type= "button" name= "add" value= "ADD" onclick="javascript:insertpaper()"></td>
</tr>
</table>
<input type="hidden" name= "paper_id"value="">
<input type= "hidden" name="module" value="paper">
<input type= "hidden" name="access" value="">
</form>
</body>
</html>
