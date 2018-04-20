<html>
<head>
<title> List Rooms </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h1 align= center><u><b>List Of Rooms</b></u></h1><br><h3 align= center>(Click on <u>RoomNo</u> to Modify)</h3>
<form action="/Project1/hosteladmin" name="listrooms" method="post">
<%
  ArrayList<Room> list= (ArrayList<Room>) request.getAttribute("show");
%>
<table border= "0" align= "center" width= "800">
<tr>
   <th class= "sai6">        		</th>
   <th class= "sai6">Room No: 		</th>
   <th class= "sai6">Num of Cupboards:  </th>
</tr>
<% 
String style= "";
for(int i= 0; i < list.size(); i++)
{
	if(i % 2 == 0)
	    style= "sai1";
	else
	    style= "sai2";
%>
<tr class= "sai1">
  <td class= "<%=style%>" align= "center"><input type= "checkbox" name= "deleteBox" value= "<%= list.get(i).getRoomId()%>"></td>
  <td class= "<%=style%>" align= "center"><a href= "javascript:modifyRoom(<%= list.get(i).getRoomId()%>)"> <%= list.get(i).getRoomNo() %> </a></td>
  <td class= "<%=style%>" align= "center"><%= list.get(i).getNumCupboards() %></td>
<% } %>
</tr>
<tr>
  <td align="left" class="sai2"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript: deleteRoom()"></td>
  <td class="sai2"></td>
  <td align="right" class="sai2"><input type= "button" name= "btnAdd New Room" value= "Add New Room" onclick= "javascript: addnewRoom()"></td>
</tr>
</table>
<input type= "hidden" name= "roomId" value= "">
<input type= "hidden" name= "module" value= "rooms">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
