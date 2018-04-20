<html>
<head>
<title>Fresh Allocation</title>
</head>
<script type= "text/javascript"
src="SAC.js"></script>
<%@ page import= "bca.batch2011.project1.sac.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<link rel= stylesheet href= "style.css">
<body>
<%
   HouseBean house= (HouseBean) request.getAttribute("getyear"); 
   ArrayList<EventBean> show= (ArrayList<EventBean>)request.getAttribute("notexist");
   ArrayList<HouseBean> housenames= (ArrayList<HouseBean>)request.getAttribute("housenames");
   ArrayList<PositionBean> positions= (ArrayList<PositionBean>)request.getAttribute("positions");
%>
<center><h3>FreshAllocation</h3></center>
<b> Year: </b><em><%= house.getYear()%></em>
<form name= "formFreshAllocation" method="post" action="/Project1/sac">
<table align="center">
<tr>
	<th>EventName</th>
	<%
	for(int i= 0;i< housenames.size();i++)
	{%>
		<th><%= housenames.get(i).getHouseName()%></th>
		<input type= "hidden"  name="house_id" value="<%= housenames.get(i).getHouseid()%>">
	<%}%>
</tr>
<%
 String style= ""; 
 for(int i= 0;i< show.size();i++)
 {
	if(i%2 == 0)
		style= "sai12";
	else
		style= "sai13";
 %>
	<tr><td class= "<%=style%>"><%= show.get(i).getEventname()%></td>
	<input type= "hidden"  name="event_id" value="<%= show.get(i).getEventid()%>">
	<%for(int k= 0;k< housenames.size();k++)
	 { 	
	 %>
		<td><select name= "positionnames<%=i%><%=k%>" id="positionnames<%=i%><%=k%>" >
		 <option value="-1">select</option>
		 <%for(int j= 0;j< positions.size();j++)
		 {
			if(positions.get(j).getPositiontitle().equalsIgnoreCase("Winners") || positions.get(j).getPositiontitle().equalsIgnoreCase("Runners")){%>
			<option value="<%= positions.get(j).getPositionid()%>"><%= positions.get(j).getPositiontitle()%></option>
		 <%}}%>
		</select>
	<%}%>
	</tr>
<%}%>
<!-- This is for indentation for the insert button-->
<tr>
	<td class= "sai12"><input type= "button" name= "delete" value= "CANCEL" onclick="javascript:cancel()" ></td>
	<%for(int k= 0;k< housenames.size()-1;k++)
	 { 	
	 %>
		<td></td>
	 <%
	 }%>
	<td class="sai1b" align="right"><input type= "button" name= "add" value= "INSERT" onclick="javascript:inserthouseevent()"></td>
</tr>
</table>
<input type= "hidden" name="module" value="houseevent">
<input type= "hidden" name="access" value="">
<input type= "hidden"  name="row"   value="<%= show.size()%>"><!--events-->
<input type= "hidden"  name="column" value="<%= housenames.size()%>"><!--houses-->
<input type= "hidden"  name="houseyear" value="<%= house.getYear()%>">
</form>
</body>
</html>
