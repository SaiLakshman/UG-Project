<html>
<head>
<title>View Syllabus</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "teachernotallocatedForm" method= "post" action="/Project1/campusteacher">
<%
Papers_Course c= (Papers_Course)request.getAttribute("coursename");%>

<h3> Teachers are not Allocated for all Papers.Please allocate teachers for all the papers.</h3>

<td><input type= "button" name= "cancel" value= "Back"  onclick= "javascript:setteacher()"></td>

</table>
<input type= "hidden" name= "module" value= "teacherpaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">

</form>
</body>
</html>
