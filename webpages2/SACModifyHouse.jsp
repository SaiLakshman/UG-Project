<html>
<head>
<title> House information</title>
<script type="text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%
  HouseBean bean= (HouseBean)request.getAttribute("housedetails");
%>
<form name= "modifyform" method= "post" action= "/Project1/sac">
<table cellspacing= "2" align= "center">
<tr>
    <th colspan= "2">Modify House Details</th>
<tr>
<tr class= "sai1">
            <td class="sai1">House_Name</td>
            <td class="sai2"><input name= "name" type= "text" value= "<%= bean.getHouseName()%>"></td></tr>
<td><input type= "button" name="btncancel" value="Cancel" onclick= "javascript:modifyback()"></td>
<td class= "sai2" align= "right"><input type= "button" name= "back" value= "Submit" onclick= "javascript:modifyhouse(<%= bean.getHouseid()%>)"></td>
</tr>
</table>
<input type= "hidden" name= "House_id" value= "">
<input type= "hidden" name= "module" value= "house">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>

