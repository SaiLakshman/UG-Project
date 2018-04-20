<html>
<head>
<title>Add Exam</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h2 align= center>Add Exam Details</h2>
<form name= "addexam" method="post" action= "/Project1/campusadmin">
<table align= "center">
  <tr>
     <td class= "sai1">Exam Code:</td>
     <td><input class= "text1" Name= "examcode" id= "examcode" type= "text"></td>
  </tr>
  <tr>
     <td class= "sai1">Exam Title:</td>
     <td><input class= "text1" Name= "examtitle" id= "examtitle" type= "text"></td>
  </tr> 
  <tr>
     <td align= "left" class= "sai1"><input Name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelExam()"></td>
     <td align= "right" class= "sai2"><input Name= "btnAdd" type= "button" value="Add" onclick= "javascript: addExam()"></td>
  </tr>
</table>
<input Name= "module" type= "hidden" value="exams" >
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
