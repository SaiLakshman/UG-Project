<html>
<head>
<title>
Exist Allocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	SRDAllocation get= (SRDAllocation) request.getAttribute("allocation");
	ArrayList<SRDAllocation> srdalloc= (ArrayList<SRDAllocation>) request.getAttribute("srd");
	ArrayList<SRDAllocation> srd= (ArrayList<SRDAllocation>) request.getAttribute("student");
%>
<body>
<form action="/Project1/hostelteacher" name="Exist Allocation" method="post">
	Year:&nbsp;<%= get.getYear()%>
	<% String a= "";
	if(get.getSemester() % 2 == 1)
	{
		a= "Odd";
	}
	if(get.getSemester() % 2 == 0)
	{
		a= "Even";
	}%>
	Semester:&nbsp;<%= a%>
<hr>
	<table align= "center">
	<% ArrayList<ArrayList<SRDAllocation>> BigList= (ArrayList<ArrayList<SRDAllocation>>) request.getAttribute("StList");
		ArrayList<SRDAllocation> StudentList= (ArrayList<SRDAllocation>) request.getAttribute("RmList");
	    for (int i = 0; i < StudentList.size(); i++) 
	    { %>
	    	<tr><td class= "sai1"><%=StudentList.get(i).getSrdName()%></td></tr>
			<%for (int j= 0; j < BigList.get(i).size(); j++) 
			{%>
				<tr><td><%= BigList.get(i).get(j).getName()%></td></tr>
			<%}%>
	   <% }%>
		
		<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
		<td></td>
		<td align= "right"><input Name= "Update" type= "button" value="Modify" onclick= "javascript: existUpdate()"></td>
	</table>
	<input Name= "module" type= "hidden" value="SrdAllocation">
	<input Name= "access" type= "hidden" value="">
	
	<input Name= "year" type= "hidden" value="<%= get.getYear()%>">
	<input Name= "semester" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
