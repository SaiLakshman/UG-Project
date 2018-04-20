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
<form name= "StudentmarksnotsetForm" method= "post" action="/Project1/campusteacher">
<%
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("coursesempaper");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
Papers_Course ep= (Papers_Course)request.getAttribute("selected paper");
%>
<h1 class="labelred"><u>**View Papers of <%=c.getCourse_name()%> <%=c.getBatch()%> batch of <%=c.getYear()%> year, <%=c.getSemester()%> semester**</u></h1>
<table>
<tr></tr><tr></tr><tr></tr><tr>
<td Class= "sai12"><strong><u>Result</u></strong></td></tr><tr></tr>
<tr>
	<%for(int i= 0;i < pap.size();i++){%>
		<td class= "sai1b"><%if(pap.get(i).getPaper_id() == ep.getPaper_id()) {%><%=pap.get(i).getPaper_code()%>--<%=pap.get(i).getPaper_title()%> </td>
	<%}}%>
</tr>

<tr>
<td>Marks are Not Yet allocated to Students</td>
</tr><tr>
<td><input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()"></td>
<td align="center"><input type= "button" name= "coursepaper" value="Set Marks" onclick= "javascript:setmarks()"></td></tr>

</table>
<input type= "hidden" name= "module" value= "marksstudents">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "smcoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "smbatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "smyear" value= "<%=c.getYear()%>">
<input type= "hidden" name= "smsemester" value= "<%=c.getSemester()%>">
<input type= "hidden" name= "smpaper" value= "<%=ep.getPaper_id()%>">
</form>
</body>
</html>
