<html>
<head>
<title>Modify Room</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<% Room gt= (Room) request.getAttribute("modify");%>
<h2 align= center>Modify Room Details</h2>
<form name= "modifyroom" method="post" action= "/Project1/hosteladmin">
<table align= "center">
  <tr class= "sai1">
     <td class= "sai1">Room No:</td>
     <td class= "sai2"><input Name= "roomNo" type= "text" value= "<%= gt.getRoomNo() %>"></td>
  </tr>
  <tr class= "sai1">
     <td class= "sai1">No of Cupboards:</td>
     <td class= "sai2"><input Name= "numCupboards" type= "text" value= "<%= gt.getNumCupboards() %>"></td>
  </tr> 
  <tr class= "sai1">
     <td class= "sai1" align= "left">
     <input Name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelRoom()"></td>
     <td class= "sai2" align= "right">
     <input Name= "btnSubmit" type= "button" value="Submit" onclick= "javascript: updateRoom(<%= gt.getRoomId() %>)"></td>
  </tr>
</table>
<input Name= "roomId" type= "hidden" value="">


<input Name= "module" type= "hidden" value="rooms">
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
