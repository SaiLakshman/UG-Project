<html>
<head>
<title> Events</title>
<script type="text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%ArrayList<EventBean> eventarray1= (ArrayList<EventBean>)request.getAttribute("eventlist");  %>
<h1 align= "center"><u>List of Events</u></h1>
<p align= "center">[click on the Event_Name to modify]</p>
<form name= "listform" method= "post" action= "/Project1/sac">
<table border= "1" colspan= "1" align= "center">
<tr class = "sai1">
<th></th>
<th align= "center">Event Name</th>
<th align= "center">Group Or Individual</th>
<th align= "center">Sports Or Cultural Or Athletic</th>
<%
String style= ""; 
String s= ""; 
String q= "";
for(int i= 0;i< eventarray1.size();i++)
  {
      if(i%2 == 0)
		style= "sai1";
 	else
		style= "sai2";

%>
</tr>
<tr class= "sai1">
<td class= "<%= style%>" align="center"><input type= "checkbox" align= "center" name= "eids" value= "<%=eventarray1.get(i).getEventid()%>"></td>
<td class= "<%= style%>" align="center"><a href= "javascript:sub1(<%=eventarray1.get(i).getEventid()%>)"><%= eventarray1.get(i).getEventname()%></a></td>
<td align="center">
<%
          if(eventarray1.get(i).getGroup_individual() == 0)
            s= "Group";
          else
            s= "Individual";
	%>

       <%= s %>
</td>
<td align="center">
<%
      if(eventarray1.get(i).getSports_cultural_athletic() == 1)
         q= "Sports";
      else if(eventarray1.get(i).getSports_cultural_athletic() == 2)
         q= "Cultural";
      else if(eventarray1.get(i).getSports_cultural_athletic() == 3)
         q= "Athletic";  
%>
        <%= q %>
</td>
<%}%>
<tr>
<td><input type= "button" name= "delete" value= "Delete" onclick="javascript:check1()">
<td colspan="3" align="right"><input type= "button" name= "add" value= "Add New Event" onclick="javascript:AddEvent()">
</td></tr>
</table>
<input type= "hidden" name= "Event_id" value="">
<input type= "hidden" name= "module" value= "event">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
