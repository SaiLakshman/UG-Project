<html>
<head>
<title> Position information</title>
<script type= "text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%ArrayList<PositionBean> positionarray1= (ArrayList<PositionBean>)request.getAttribute("positionlist"); %>
<h1 align= "center"><u>List of Positions And Points</u></h1>
<p align= "center">[click on the Position Title to modify]</p>
<form name= "Addform" method= "post" action= "/Project1/sac">
<table border= "1" align= "center">
<tr>
<th></th>
<th class="labelred">Position Title</th>
<th class="labelred">Points</th>
</tr>
<%
String style= ""; 
for(int i= 0;i< positionarray1.size();i++)
  {
      if(i%2 == 0)
		style= "sai1";
 	else
		style= "sai2";

%>

<tr class= "sai1">
<td class= "<%= style%>"><input type= "checkbox" align= "center" name= "pids" value= "<%=positionarray1.get(i).getPositionid()%>"></td>
<td><a href= "javascript:sub2(<%=positionarray1.get(i).getPositionid()%>)"><%= positionarray1.get(i).getPositiontitle()%></a></td>
<td class= "<%=style%>"><%= positionarray1.get(i).getPoints() %></td>
</tr>
<%
}
%>
<tr class="sai1">
<td class="sai2"><input type= "button" name= "delete" value= "Delete" onclick= "javascript:check2()"></td><td></td>
<td class="txt"><input type= "button" name= "add" value= "AddNewPosition" onclick= "javascript:AddPosition()"></td>
</tr>
</table>
<input type= "hidden" name="position_id" value= "">
<input type= "hidden" name= "module" value= "position">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>

