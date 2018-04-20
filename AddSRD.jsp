<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<head>
<title> Self-Reliance Department Page </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<h1 align= "center">@ Please Enter the Self-Reliance Departments @</h1>
<form name= "formAddSRD" method= "post" action= "/Project1/hosteladmin">
<table class= "Border" align= "center">
<tr>
   <td class= "sai1"> SRD_Name: </td>
   <td> <input class= "text1 " type= "text" name= "srdName"> </td>
</tr>
<tr>
   <td class= "label"> <input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:cancelSRD()"></td>
   <td class= "label" align= "right"> <input type= "button" name= "btnAdd" value= "Add" onclick= "javascript:insertSRD()"> </td>
</tr>
</table>
<input type= "hidden" name= "srdId" value= "">
<input type= "hidden" name= "module" value= "srd">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
