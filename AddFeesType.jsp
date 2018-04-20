<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<head>
<title> Fees Page </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<!--Fees Type Details-->
<h1 align= "center">@ Please Enter the Fees Type @</h1>
<form name= "formAddFees" method= "post" action= "/Project1/hosteladmin">
<table class= "Border" align= "center">
<tr>
   <td class= "sai1"> Fees_Name: </td>
   <td> <input class= "text1" type= "text" name= "feesName"> </td>
</tr>
<tr>
   <td class= "label"> <input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:cancelFees()"></td>
   <td class= "label" align= "right"> <input type= "button" name= "btnAdd" value= "Add" onclick= "javascript:insertFees()"> </td>
</tr>
</table>
<input type= "hidden" name= "feesId" value= "">
<input type= "hidden" name= "module" value= "fees">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
