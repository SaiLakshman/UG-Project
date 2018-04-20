<html>
<head>
<title>View Allocation</title>
</head>
<script type= "text/javascript"
src="SAC.js"></script>
<%@ page import= "bca.batch2011.project1.sac.*"%>
<%@ page import= "java.util.*"%>
<link rel= stylesheet href= "style.css">
<body>
<% ArrayList<HouseBean> houseevent= (ArrayList<HouseBean>)request.getAttribute("exist");
   HouseBean house1= (HouseBean) request.getAttribute("getyear");%>
<center><h3>View Details</h3></center>
<form name= "formExistAllocation" method="post" action="/Project1/sac">
<table align="center">
<b>Year: </b><em><%= house1.getYear()%></em>
<tr>
	<th class= "labelred">HouseName	</th>
	<th class= "labelred">EventName   </th>
	<th class= "labelred">Position    </th>
</tr>
<% 
String style= "";
for(int i= 0; i < houseevent.size(); i++)
{
  if(i % 2 == 0)
    style= "sai12";
  else
    style= "sai13";
%>
<tr>
	<td class= "<%= style%>"><%= houseevent.get(i).getHouseName() %></td>
	<td class= "<%= style%>"><%= houseevent.get(i).getEventname() %></td>
	<td class= "<%= style%>"><%= houseevent.get(i).getPositionname() %></td>
</tr>
<%
}
%>
<tr>
	<td class="sai2"><input type= "button" name="cancelbutton" value="CANCEL" onclick="javascript:cancel()"></td><td></td>
	<td class="sai2" align= "right"><input type= "button" name="modify" value="MODIFY" onclick="javascript:modifyhouse()"></td>
</tr>
</table>
<input type= "hidden" name="module" value="houseevent">
<input type= "hidden" name="access" value="">
<input type= "hidden"  name="houseyear" value="<%= house1.getYear()%>">
</form>
</body>
</html>
