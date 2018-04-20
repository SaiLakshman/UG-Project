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
<form name= "courseseepaperForm" method= "post" action="/Project1/campusteacher">
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("paperbatch");
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("batchpaper");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
int a= 0,b= 1;
int d= c.getDuration() * 2;%>
<h1><u>View Syllabus of <%=c.getCourse_name()%> <%=c.getBatch()%> batch.</u></h1>

<table>
<tr>
<%
for(int i= 0;i < d;i++)
{
	if(i%2 == 0)
		a++;
%>
<tr></tr><tr></tr><tr></tr>
<td Class= "sai14"><strong><u><%=i+1%> SEM:</u></strong></td></tr><tr></tr>
<tr Class= "sai2">
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{%>
		<%if(show.get(cnt).getCourse_id() == c.getCourse_id() && show.get(cnt).getBatch() == c.getBatch() && show.get(cnt).getYear() == a && show.get(cnt).getSemester() == b)
		{
			
		%>
					<tr Class= "sai3"><td Class= "sai12"><%=pap.get(cnt).getPaper_code()%>--</td>
					<td Class= "sai4"><%=pap.get(cnt).getPaper_title()%>&nbsp;</td></tr>
		<%
					
		}
	}
	if(b == 1)
		b= 2;
	else if(b == 2)
		b= 1;
	%>
</tr>
<%
}
%>
</tr>
<td><input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()"></td>
<td align="center"><input type= "button" name= "coursepaper" value="Modify" onclick= "javascript:modifypaper()"></td></tr>

</table>
<input type= "hidden" name= "module" value= "coursepaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">

</form>
</body>
</html>
