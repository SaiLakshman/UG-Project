<html>
<head>
<title>
RoomAllocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h2 align= center>RoomView/Allocation</h2>
<form name= "roomview" method="post" action= "/Project1/hostelteacher">
<table align= "center">
  <tr class= "sai1">
     <td>Year:</td>
     <td class= "sai2"><input Name= "year" id= "year" type= "text"></td>
  </tr>
  <tr class= "sai1">
     <td class= "sai1">Semester:</td>
     <td class= "sai2"><input Name= "semester" id= "semester" type= "text"></td>
  </tr> 
  <tr class= "sai1">
     <td class= "sai1" align= "left"></td>
     <td class= "sai2" align= "right">
     <input Name= "Submit" type= "button" value="submit" onclick= "javascript: RoomAllocation()"></td>
  </tr>
</table>
<input Name= "module" type= "hidden" value="RoomAllocation" >
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
