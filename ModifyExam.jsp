<html>
<head>
<title>Modify Exam</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<% Exam gt= (Exam) request.getAttribute("modify");%>
<h2 align= center>Modify Exam Details</h2>
<form name= "modifyexam" method="post" action= "/Project1/campusadmin">
<table align= "center">
  <tr class= "sai1">
     <td class= "sai1">Exam Code:</td>
     <td class= "sai2"><input Name= "examcode" type= "text" value= "<%= gt.getExamCode() %>"></td>
  </tr>
  <tr class= "sai1">
     <td class= "sai1">Exam Title:</td>
     <td class= "sai2"><input Name= "examtitle" type= "text" value= "<%= gt.getExamTitle() %>"></td>
  </tr> 
  <tr class= "sai1">
     <td class= "sai1" align= "left">
     <input Name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelExam()"></td>
     <td class= "sai2" align= "right">
     <input Name= "btnSubmit" type= "button" value="Submit" onclick= "javascript: updateExam(<%= gt.getExamId() %>)"></td>
  </tr>
</table>
<input Name= "examId" type= "hidden" value="">
<input Name= "module" type= "hidden" value="exams">
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
