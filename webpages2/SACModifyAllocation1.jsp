<html>
<head>
<title>Fresh Allocation</title>
</head>
<script type= "text/javascript"
src="SAC.js"></script>
<link rel= stylesheet href= "style.css">
<%@ page import= "bca.batch2011.project1.sac.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<%
   HouseBean house= (HouseBean) request.getAttribute("getyear");
   ArrayList<HouseBean> housenames= (ArrayList<HouseBean>)request.getAttribute("selecthouses");
   ArrayList<EventBean> event= (ArrayList<EventBean>)request.getAttribute("events");
   ArrayList<PositionBean> position= (ArrayList<PositionBean>)request.getAttribute("positions");
   ArrayList<HouseBean> houseevent= (ArrayList<HouseBean>)request.getAttribute("housearrays");
   ArrayList<HouseBean> houseevent1= (ArrayList<HouseBean>)request.getAttribute("housearrays");
%>
<body>
<center><h3>View Details</h3></center>
<table align="center">
<b>Year: </b><em><%= house.getYear()%></em>
<tr>
	<th class= "labelred">HouseName	</th>
	<th class= "labelred">EventName   </th>
	<th class= "labelred">Position    </th>
</tr>
<% 
String style1= "";
for(int i= 0; i < houseevent1.size(); i++)
{
  if(i % 2 == 0)
    style1= "sai12";
  else
    style1= "sai13";
%>
<tr>
	<td class= "<%= style1%>"><%= houseevent1.get(i).getHouseName() %></td>
	<td class= "<%= style1%>"><%= houseevent1.get(i).getEventname() %></td>
	<td class= "<%= style1%>"><%= houseevent1.get(i).getPositionname() %></td>
</tr>
<%
}
%>
</table>
<input type= "hidden" name="module" value="houses">
<input type= "hidden" name="access" value="">
<input type= "hidden"  name="houseyear" value="<%= house.getYear()%>">


<h2 align="center"> Modifying <%=house.getYear() %>'s Allocation</h2>
Year: <%=house.getYear() %>
<form name= "formModifyAllocation" method="post" action="/Project1/sac">
<table align= "center">
<tr>
	<th class="labelred">EventName</th>
	<%
	for(int i= 0;i< housenames.size();i++)
	{%>
		<th class="labelred"><%= housenames.get(i).getHouseName()%></th>
		<input type= "hidden"  name="house_id" value="<%= housenames.get(i).getHouseid()%>">
	<%}%>
</tr>
<% String style= ""; 
for(int i= 0;i< event.size(); i++)
{
	if(i%2 == 0)
		style= "sai12";
	else
		style= "sai13";
%>
	<tr><td class= "<%=style%>"><%= event.get(i).getEventname()%></td>
	<input type= "hidden"  name="event_id" value="<%= event.get(i).getEventid()%>">
	<%for(int k= 0;k< housenames.size();k++)
	  { %>
		  <td><select name= "positionnames<%=i%><%=k%>">
			<option value="-1">select</option>
		  <%for(int j= 0;j< position.size();j++)
		  {%>
			   <option value="<%= position.get(j).getPositionid()%>"> <%= position.get(j).getPositiontitle()%> </option>
		  <%}%>	
		 </select>
	<%}%>

<%}%>
<tr>
<!-- This loop is for indentation of the insert button-->
	<td class= "sai12"><input type= "button" name= "delete" value= "CANCEL" onclick="javascript:cancelhouseevent()" ></td>
	<%for(int k= 0;k< housenames.size()-1;k++)
	 { 	
	 %>
		<td></td>
	 <%
	 }%>
	<td class="sai2" align="right"><input type= "button" name= "updatebutton" value="SUBMIT" onclick="javascript:updatehouseevent()"></td>
</tr>
</table>
<input type= "hidden" name="module" value="houseevent">
<input type= "hidden" name="access" value="">
<input type= "hidden"  name="row" value="<%= event.size()%>"><!--events-->
<input type= "hidden"  name="column" value="<%= housenames.size()%>"><!--houses-->
<input type= "hidden"  name="houseyear" value="<%= house.getYear()%>">
</form>
</body>
</html>

