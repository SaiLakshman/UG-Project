<%@ page isErrorPage= "true"%>
<%@ page import= "bca.batch2011.project1.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.io.*"%>
<% String exc= (String)request.getAttribute("exc");%>
<html>
<head>
<link rel= stylesheet href= "style.css">
<title>Error Page</title>
</head>
<body>
<h3 class= "label" align= "center"><u>ERROR HAS OCCURED.</u></h3>
<%= exc %></br>
<% exception.printStackTrace(response.getWriter()); %>
</body>
</html>
