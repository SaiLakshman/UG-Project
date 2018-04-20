<html>
<head>
<title>Add Courses</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% ArrayList<DepartmentBean> show= (ArrayList<DepartmentBean>) request.getAttribute("dep"); %>
<body>
<h2 align= center>Add Course Details</h2>
<form name= "addcourses" method="post" action= "/Project1/campusadmin">
<table align= "center">
  <tr>
     <td class= "sai1">Course Name:</td>
     <td><input class= "text1" name= "coursename" id= "coursename" type= "text"></td>
  </tr>
  <tr>
     <td class= "sai1">Course Title:</td>
     <td><input class= "text1" name= "coursetitle" id= "coursetitle" type= "text"></td>
  </tr> 
  <tr>
     <td class= "sai1">Duration:</td>
     <td><input class= "text1" name= "duration" id= "duration" type= "text"></td>
  </tr>
  <tr>
 	<td class= "sai1">Department</td>
	<td> <select name= "DepartmentId" >
        <option value= "">SELECT
    	<% for(int k= 0;k<show.size();k++)
       	{ %>
           <option value= "<%= show.get(k).getDepartmentid()%>"><%= show.get(k).getDepartmentname() %>
    	<% }%>
     	</select>
    	</td>
</tr>
  <tr>
     <td class= "sai1" align= "left">
     <input name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelCourse()"></td>
     <td class= "sai2" align= "right">
     <input name= "btnAdd" type= "button" value="Add" onclick= "javascript: insertCourse()"></td>
  </tr>
</table>
<input name= "courseId" type= "hidden" value= "">
<input name= "module" type= "hidden" value="courses" >
<input name= "access" type= "hidden" value="">
</form>
</body>
</html>
