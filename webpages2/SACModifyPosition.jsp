<html>
<head>
<title> Position information</title>
<script type="text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%
  PositionBean position= (PositionBean)request.getAttribute("positiondetails");
%>
<form name= "modifyform" method= "post" action= "/Project1/sac">
<table cellspacing= "2" align= "center">
<center><h2>Modifying <i><font color="blue"><%= position.getPositiontitle()%></font></i>'s Details</h2>

<tr class= "sai1">
            <td class="sai1">Position Title</td>
            <td class="sai2"><input name= "name" type= "text" value= "<%= position.getPositiontitle()%>"></td></tr>
<tr class= "sai1">
            <td class="sai1">Points</td>
            <td class="sai2"><input name= "point" type= "text" value= "<%= position.getPoints()%>"></td></tr>


<td><input type= "button" name="btncancel" value="Cancel" onclick= "javascript:modifyback()"></td>
<td class= "sai2" align= "right"><input type= "button" name= "back" value= "Submit" onclick= "javascript:modifyposition(<%= position.getPositionid()%>)"></td>
</tr>
</table>
<input type= "hidden" name= "position_id" value= "">
<input type= "hidden" name= "module" value= "position">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
