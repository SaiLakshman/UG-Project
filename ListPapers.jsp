<html>
<head>
<title> List Papers </title>
<script type= "text/javascript"
src="CA.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<form  name="formListPapers" method="post" action="/Project1/campusadmin">
<h1  align ="center"> List of Papers</h1><h3 align="center">[To modify please click on Name]</h3></align>
<%
   ArrayList<PaperBean> show= (ArrayList<PaperBean>) request.getAttribute("inse");
%>
<table class = "Borders" align="center" cellspacing="5" cellpadding="10" ">
<tr>
 <th class= "labelred">   </th>
  <th class= "labelred"> Paper Name</th>
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
<td class= "<%=style%>"><input type="checkbox" name="deleteBox" value="<%= show.get(i).getPaperid()%>"></td>
<td class= "<%=style%>"><a href= "javascript:subpaper(<%= show.get(i).getPaperid()%>)">
<%=
  show.get(i).getPapertitle()
%>
</a></td>
</tr>
<%
}
%>
<tr>
<td  class= "txt"><input type= "button" name= "delete" value= "DELETE" onclick="javascript:delpaper()"></td>
<td  class= "txt" align="right"><input type= "button" name= "addnewpaper" value="ADDNEWPAPER" onclick="javascript:addpaper()"></td>
<input type= "hidden" name= "paper_id"value="">
<input type= "hidden" name="module" value="paper">
<input type= "hidden" name="access" value=" ">
</tr>
</table>
</form>
</body>
</html>
