<html>
<head>
<title> List Courses </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h1 align= center><u><b>List Of Courses</b></u></h1><br><h3 align= center>(Click on <u>CourseNames</u> to Modify)</h3>
<form action="/Project1/campusadmin" name="ListCourses" method="post">
<%
  ArrayList<Course> list= (ArrayList<Course>) request.getAttribute("inse");
%>
<table border= "0" align= "center" width= "800">
<tr class= "sai1">
  <th class= "labelred"></th>
  <th class= "labelred">Course Name</th>
  <th class= "labelred">Course Title</th>
  <th class= "labelred">Duration</th>
  <th class= "labelred">Department Name</th>
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
 <td class= "<%= style%>" align="center"><input type= "checkbox" name= "deleteBox" value= "<%= list.get(i).getCourseid() %>"></td>
 <td class= "<%= style%>" align="center"><a href= "javascript: modifyCourse(<%= list.get(i).getCourseid() %>)"><%=list.get(i).getCoursename()
%></a></td>
<td class="<%= style%>" align="center"><%= list.get(i).getCoursetitle()%></td>
<td class="<%= style%>" align="center"><%= list.get(i).getDuration()%></td>
<td class="<%= style%>" align="center"><%= list.get(i).getDepartmentname()%></td>
<%
}
%>
</tr>
<tr>
<td align="left" class="txt"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript: deleteCourse()"></td><td></td><td></td><td></td>
<td align="right" class="txt"><input type= "button" name= "btnAddNewCourse" value= "Add New Course" onclick= "javascript: addCourse()"></td>
</tr>
</table>
<input type= "hidden" name= "courseId" value= "">
<input type= "hidden" name= "module" value= "courses">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
