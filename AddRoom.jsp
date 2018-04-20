<html>
<head>
<title>Add Room</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h2 align= center>Add Room Details</h2>
<form name= "addRoom" method="post" action= "/Project1/hosteladmin">
<table align= "center">
  <tr>
     <td class= "sai1">Room No:</td>
     <td><input class= "text1" Name= "roomNo" type= "text"></td>
  </tr>
  <tr>
     <td class= "sai1">No. of Cupboards:</td>
     <td><input class= "text1" Name= "numCupboards" type= "text"></td>
  </tr> 
  <tr>
     <td align= "left" class= "sai1"><input Name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelRoom()"></td>
     <td align= "right" class= "sai2"><input Name= "btnAdd" type= "button" value="Add" onclick= "javascript: insertRoom()"></td>
  </tr>
</table>
<input Name= "module" type= "hidden" value="rooms" >
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
