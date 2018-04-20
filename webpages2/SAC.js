//function for adding new house 
function AddHouse()
{
	if(confirm("Do you want to add new House?") == 1)
	{
    		document.forms[0].access.value= "addhouse";
    		document.forms[0].submit();
	}
}

//function for adding a new event
function AddEvent()
{
	if(confirm("Do you want to add new Event?") == 1)
	{
		document.forms[0].access.value= "addevent";
		document.forms[0].submit();
	}
}

//function for adding new position
function AddPosition()
{
	if(confirm("Do you want to add Position Details") == 1)
	{
		document.forms[0].access.value= "addposition";
		document.forms[0].submit();
	}
}

//function for inserting tthe house into the database//
function AddNewHouse()
{
	var str= document.forms[0].name.value;
	if(str.trim() == "")
	{
		alert("please fill the housename details"); 
		return;   
	}
	else
    	{
		if(confirm("you succesfully entered the details") == 1)
  		{	
      			document.forms[0].access.value= "insert";
      			document.forms[0].submit();
     		}
    	}
}
//function for inserting the position into the database//
function AddNewPosition()
{
   var s= document.forms[0].name.value;
   var a= document.forms[0].point.value;
   if(s.trim() == "")
   {
        alert("please fill the positiontitle details");
        return;
   }
   if(a.trim() == "")
   {
      alert("please fill the points details");
      return;
   }
   else
   {
       if(confirm("you succesfully entered the details") == 1)
       {
            document.forms[0].access.value="insertposition";
            document.forms[0].submit();
       }
   }
}           
//function for inserting the event into the database//
function AddNewEvent()
{
   var q= document.forms[0].name.value;
   if(q.trim() == "")
   {
     alert("please fill the eventname details");
     return;
   }
   else
   {
     alert("you succesfully enter the details");
     document.forms[0].access.value= "insertevent";
     document.forms[0].submit();
   }
}
// function for cancel button present in SACAddHouse.jsp,SACAddEvent.jsp,SACAddPosition.jsp//
function back()
{
  if(confirm("you can go back") == 1)
  {
    document.forms[0].access.value= "cancel";
    document.forms[0].submit();
  }  
}
//function for cancel button present in SACModifyHouse.jsp,SACModifyEvent.jsp,SACModifyPosition.jsp//
function modifyback()
{
  if(confirm("go back") == 1)
  {
      document.forms[0].access.value= "cancel";
      document.forms[0].submit();
  }
}
// function for going into SACModifyHouse.jsp inorder to modify the details//
function sub(x)
{
  if(confirm("do you really want to modify") == 1)
  {
    document.forms[0].access.value= "modify";
    document.forms[0].House_id.value= x;   
    document.forms[0].submit();
  }
}
// function for going into SACModifyEvent.jsp inorder to modify the details//
function sub1(x)
{
  if(confirm("do you really want to modify") == 1)
  {
    document.forms[0].access.value= "modify1";
    document.forms[0].Event_id.value= x;
    document.forms[0].submit();
  }
}
// function for going into SACModifyPosition.jsp inorder to modify the details//
function sub2(x)
{
  if(confirm("do you really want to modify")== 1)
  {
    document.forms[0].access.value= "modify";
    document.forms[0].position_id.value= x;   
    document.forms[0].submit();
  }
}
// function for update button in ModifyHouse.jsp//
function modifyhouse(x)
{
  if(confirm("succesfully go back")== 1)
   {
	document.forms[0].House_id.value= x;
	document.forms[0].access.value= "update";
  	document.forms[0].submit();
   }

}
//function for update button in ModifyPosition.jsp//
function modifyposition(x)
{
  if(confirm("succesfully go back")== 1)
   {
	  document.forms[0].position_id.value= x;
	  document.forms[0].access.value= "update";
  	  document.forms[0].submit();
   }

}
//function for update button in ModifyEvent.jsp//
function modifyevent(x)
{
  if(confirm("succesfully go back")== 1)
  {
     document.forms[0].access.value= "update";
     document.forms[0].event_id.value= x;
     document.forms[0].submit();
  }
}
//function for delete the Houses//
function check(x)
{
   if(!document.forms[0].hids.checked)
   {
	alert("None to Delete");
	return;
   }
   if(confirm("you really want to delete") == 1)
   { 
     document.forms[0].access.value= "delete";
     document.forms[0].House_id.value= x;
     document.forms[0].submit();
   }
}
// function for delete the Events //
function check1(x)
{
   if(!document.forms[0].eids.checked)
   {
	alert("None to Delete");
	return;
   }
   if(confirm("you really want to delete") == 1)
   { 
      document.forms[0].access.value= "deleted";
      document.forms[0].Event_id.value= x;
      document.forms[0].submit();
   }
}
// function for delete the Positions// 
function check2(x)
{  
   if(!document.forms[0].pids.checked)
   {
	alert("None to Delete");
	return;
   }
   if(confirm("you really want to delete") == 1)
   { 
      document.forms[0].access.value= "deleted1";
      document.forms[0].submit();
   }
}
/*function Allocation()
{
   alert("you really want to allocate");
   document.forms[0].access.value= "newallocation";
   document.forms[0].submit();
}
function InsertAllocation()
{
   alert("you entered succesfully");
   document.forms[0].access.value= "viewallocation";
   document.forms[0].submit();
}
function ModifyAllocation()
{
   alert("do you really want to modify the details");
   document.forms[0].access.value= "modify";
   document.forms[0].submit();
}
function back3()
{
  alert("you can go back");
  document.forms[0].access.value= "list";
  document.forms[0].submit();
}*/
//function for Going into Either SACFreshAllocation1.jsp (or) SACExistAllocation1.jsp//
function checking()
{
	if(confirm("Are you Sure") == 1)
	{
		document.forms[0].access.value="SUBMIT";
		document.forms[0].submit();
	}
}
function cancel()
{
	if(confirm("Go") == 1)
	{
		document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
//function for cancel button//
function cancelhouseevent()
{
	if(confirm("Go") == 1)
	{
		document.forms[0].access.value="CANCELHOUSE";
		document.forms[0].submit();
	}
}
//function for insert button//
function inserthouseevent()
{
	if(confirm("Inserting") == 1)
	{
		document.forms[0].access.value="INSERT";
		document.forms[0].submit();
	}
}
//function for modify button//
function modifyhouseevent()
{
	if(confirm("Modify") == 1)
	{
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}	
}
//function for Update button//
function updatehouseevent()
{
	if(confirm("Update") == 1)
	{
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}	
}
//frames
function Positionframe()
{
	document.forms[0].module.value= "position";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Houseframe()
{
	document.forms[0].module.value= "house";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Eventframe()
{
	document.forms[0].module.value= "event";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function HouseEventframe()
{
	document.forms[0].module.value= "houseevent";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}

