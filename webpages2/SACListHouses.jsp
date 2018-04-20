<html>
<head>
<title>House</title>
<script type="text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%
   ArrayList<HouseBean> housearray= (ArrayList<HouseBean>)request.getAttribute("houselist");  %>
<h1 align= "center"><u>List of Houses</u></h1>
<p align= "center">[click on the House_Name to modify]</p>
<form name= "listform" method= "post" action= "/Project1/sac">
<table  align= "center">
<tr class = "sai1">
<th colspan="2" align= "center">House_Name</th>
<%
String style= ""; 
for(int i= 0;i< housearray.size();i++)
  {
      if(i%2 == 0)
		style= "sai1";
 	else
		style= "sai2";

%>
</tr>
<tr class= "sai1">
<td class= "<%= style%>"><input type= "checkbox" align= "center" name= "hids" value= "<%=housearray.get(i).getHouseid()%>"></td>
<td><a href= "javascript:sub(<%=housearray.get(i).getHouseid()%>)"><%= housearray.get(i).getHouseName()%></a></td></tr>
<%
}
%>
</tr>
<tr>
<td><input type= "button" name= "delete" value= "Delete" onclick="javascript:check()">
<td align="right"><input type= "button" name= "add" value= "Add New House" onclick="javascript:AddHouse()">
</td></tr>
</table>
<input type= "hidden" name= "House_id" value="">
<input type= "hidden" name= "module" value= "house">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>


