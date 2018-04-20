<html>
<head>
<title>Paper Form</title>
<script type= "text/javascript"
src="CA.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%//@ page import="java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<%
   PaperBean show= (PaperBean)request.getAttribute("inse");
%>
<h1 align= "center">Modifying <%= show.getPapertitle()%>'s Details</h1>
<form name="formModifyPaper" method= "post" action="/Project1/campusadmin">
<table cellspacing= "5" cellpadding= "5" border= "0" align="center">
<tr>
<td class="label">Title</td>
<td> <input name= "Title" type= "text" value="<%=show.getPapertitle()%>"></td>
</tr>
<tr>
<td class="label"><input type= "button" name= "back" value= "CANCEL" onclick="javascript:cancelpaper()"></td><td></td>
<td><input type= "button" name= "change" value= "UPDATE" onclick="javascript:modifypaper(<%= show.getPaperid()%>)"></td>
</tr>
</table>
<tr>
<input type= "hidden" name="module" value="paper">
<input type= "hidden" name="access" value="">
<input type="hidden"  name="paper_id" value=""></td>
</tr>
</form>
</body>
</html>
