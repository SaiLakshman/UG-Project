<html>
<head>
<title> Semester Setup </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h1 align= center><u><b>List Of Semesters</b></u></h1><br>
<form action="/Project1/campusadmin" name="ListSemesters" method="post">
<%
  ArrayList<Semester> list= (ArrayList<Semester>) request.getAttribute("arraylist");
%>
<table border= "0" align= "center" width= "800">
<tr class= "sai1">
  <th class= "sai6">Year</th>
  <th class= "sai6">Semester</th>
  <th class= "sai6">StartingDate</th>
  <th class= "sai6">EndingDate</th>
</tr>
<% 
String style= "";
for(int i= 0; i < list.size(); i++)
{
  if(i % 2 == 0)
    style= "sai1";
  else
    style= "sai2";
%>
<tr class="sai1">
 <td class= "<%= style%>" align="center">
<%= list.get(i).getYear()%><input type="hidden" name="year" value="<%= list.get(i).getYear()%>">
 </td>
<td class="<%= style%>" align="center">
<% String s= "";
   s= String.valueOf(list.get(i).getSemester());
   if(s.equals("1"))
       s= "odd";
   else
       s= "even";
%>
<%= s%><input type="hidden" name="semester" value= "<%= list.get(i).getSemester()%>">
</td>
<td class="<%= style%>" align="center">
  <h4> <input type= "text" name= "sdate" value= "<%=list.get(i).getStartingDate()%>">
 </h4></td>
<td class="<%= style%>" align="center">
  <h4> <input type= "text" name= "edate" value= "<%=list.get(i).getEndingDate()%>">
 </h4></td>
<%
}
%>
</tr>
<tr>
  <td class="sai6"></td>
  <td class="sai6"></td>
  <td class="sai6"></td>
  <td align="right" class="sai6"><input type= "button" name= "btnUpdate" value= "Update" onclick = "javascript: updateSemesters()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "semesters">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
