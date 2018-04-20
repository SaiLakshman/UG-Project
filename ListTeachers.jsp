<html>
<head>
<title> List Teachers </title>
<script type= "text/javascript"
src="CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %> 
<link rel= stylesheet href= "style.css">

<body>
<form  name="formListTeachers" method="post" action="/Project1/campusadmin">
<h1  align ="center"> List of Teachers</h1><h3 align="center">[To modify please click on Name]</h3></align>
<%
   ArrayList<TeacherBean> show= (ArrayList<TeacherBean>)request.getAttribute("inse");
%>
<table class= "Borders" cellspacing= "5" cellpadding= "10" align="center">
<tr>
 <th>   </th>
  <th class= "labelred"> Teacher Name</th>
  <th class= "labelred"> Qualification</th>
  <th class= "labelred"> Position</th>
  <th class= "labelred"> Department</th>
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
<tr>
<td class= "<%=style%>"><input type="checkbox" name="deleteBox" value="<%= show.get(i).getTeacherid()%>"></td>
<td class= "<%=style%>"><a href= "javascript:subteacher(<%= show.get(i).getTeacherid()%>)">
<%=
  show.get(i).getTeachername()
%>
</a></td>
<td class= "<%=style%>"><%= show.get(i).getQualification() %></td>
<td class= "<%=style%>"><%= show.get(i).getPosition() %></td>
<td class= "<%=style%>"><%= show.get(i).getDepartmentname()%></td>
</tr>
<%
}
%>
<tr>
<td class= "txt"><input type= "button" name= "delete" value= "DELETE" onclick="javascript:delteacher()"></td><td></td><td></td><td></td>
<td class= "txt"><input type= "button" name= "addnewteacher" value="ADDNEWTEACHER" onclick="javascript:addteacher()"></td>

<input type= "hidden" name= "teacher_id"value="">
<input type= "hidden" name="module" value="teacher">
<input type= "hidden" name="access" value=" ">
</tr>
</table>
</form>
</body>
</html>
