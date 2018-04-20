<html>
<head>
<title> List Departments </title>
<script type= "text/javascript"
src="CA.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<form  name="formListDepartments" method="post" action="/Project1/campusadmin">
<h1  align ="center"> List of Departments</h1><h3 align="center">[To modify please click on Name]</h3></align>
<%
   ArrayList<DepartmentBean> show= (ArrayList<DepartmentBean>) request.getAttribute("inse");
%>
<table cellspacing= "5" cellpadding= "20" border= "1" align="center">
<tr align= "center">
 <th class= "bkgnd">   </th>
  <th class= "bkgnd"> Department Name</th>
  <th class= "bkgnd"> Department Title</th>
</tr>
<%
String style= ""; 
 for(int i= 0;i< show.size();i++)
{
	if(i%2 == 0)
		style= "sai11";
	else
		style= "sai12";
%>
<tr>
<td class= "<%=style%>"><input type="checkbox" name="deleteBox" value="<%= show.get(i).getDepartmentid()%>"></td>
<td class= "<%=style%>"><a href= "javascript:subdepartment(<%= show.get(i).getDepartmentid()%>)">
<%=
  show.get(i).getDepartmentname()
%>
</a></td>
<td class= "<%=style%>"><%=show.get(i).getDepartmenttitle() %>
</tr>
<%
}
%>
<tr>
<td class= "input.btn"><input type= "button" name= "btndelete" value= "DELETE" onclick="javascript:deldepartment()"></td><td></td>
<td class= "input.btn" align="right"><input type= "button" name= "btnaddnewdepartment" value="ADDNEWDEPARTMENT" onclick="javascript:adddepartment()"></td>
<input type= "hidden" name= "department_id"value="">
<input type= "hidden" name="module" value="department">
<input type= "hidden" name="access" value=" ">
</tr>
</table>
</form>
</body>
</html>
