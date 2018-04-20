
function RoomAllocation()
{
	if(confirm("Are you sure")== 1)
	{
		var x= document.getElementById("year");
		var y= document.getElementById("semester");
		if(x.value == "" && y.value != "")
		{
			alert("please enter year");
			return false;
		}
		if(y.value == "" && x.value != "")
		{
			alert("please enter semester");
			return false;
		}
		if(x.value == "" && y.value == "")
		{
			alert("please fill the requirements");
			return false;
		}
		else 
		{
			document.forms[0].access.value= "Submit";
			document.forms[0].submit();
		}
	}
}
function TeacherRoomAllocation()
{
	if(confirm("Are you sure")== 1)
	{
		var x= document.getElementById("year");
		var y= document.getElementById("semester");
		if(x.value == "" && y.value != "")
		{
			alert("please enter year");
			return false;
		}
		if(y.value == "" && x.value != "")
		{
			alert("please enter semester");
			return false;
		}
		if(x.value == "" && y.value == "")
		{
			alert("please fill the requirements");
			return false;
		}
		else 
		{
			document.forms[0].access.value= "Submit";
			document.forms[0].submit();
		}
	}
}
function SrdAllocation()
{
	if(confirm("Are you sure")== 1)
	{
		var x= document.getElementById("year");
		var y= document.getElementById("semester");
		if(x.value == "" && y.value != "")
		{
			alert("please enter year");
			return false;
		}
		if(y.value == "" && x.value != "")
		{
			alert("please enter semester");
			return false;
		}
		if(x.value == "" && y.value == "")
		{
			alert("please fill the requirements");
			return false;
		}
		else 
		{
			document.forms[0].access.value= "srdSubmit";
			document.forms[0].submit();
		}
	}
}
function cancelAllocation()
{
	document.forms[0].access.value= "Cancel";
	document.forms[0].submit();
}
function cancelfreshAllocation()
{
	document.forms[0].access.value= "Cancelfresh";
	document.forms[0].submit();
}
function cancelmodifyAllocation()
{
	document.forms[0].access.value= "Cancelmodify";
	document.forms[0].submit();
}

function freshAllocation()
{
	document.forms[0].access.value= "Freshallocation";
	document.forms[0].submit();
}
function teacherfreshAllocation()
{
	document.forms[0].access.value= "Freshallocation";
	document.forms[0].submit();
}
function updateAllocation()
{
	document.forms[0].access.value= "Updateallocation";
	document.forms[0].submit();
}
function teacherupdateAllocation()
{
	document.forms[0].access.value= "Updateallocation";
	document.forms[0].submit();
}
function updatemodifyAllocation()
{
	alert("sairam");
	document.forms[0].access.value= "Updatemodifyallocation";
	document.forms[0].submit();
}
function existUpdate()
{
	document.forms[0].access.value= "Modifyallocation";
	document.forms[0].submit();
}
function teacherexistUpdate()
{
	document.forms[0].access.value= "TeacherModifyallocation";
	document.forms[0].submit();
}
function copyAllocation()
{
	document.forms[0].access.value= "Copyallocation";
	document.forms[0].submit();
}

//-----------Fees_Amount Module
function searchFees()
{
	if(document.forms[0].year.value == "")
	{
		alert("Fill the Year");
		document.forms[0].year.focus();
		return;
	}
	if(document.forms[0].semester.value == "")
	{
		alert("Fill the Semester");
		document.forms[0].semester.focus();
		return;
	}
	if(confirm("Do You want the Information?") == 1)
	{
		document.forms[0].access.value= "find";
		document.forms[0].submit();
	}
}

function notExists()
{
	if(confirm("Do You Want to add Amount Fresh?") == 1)
	{
		document.forms[0].access.value= "freshAllocation";
		document.forms[0].submit();
	}
}

function copyExisting()
{
	if(confirm("Do You Want to Copy From the Given Year and Semester?") == 1)
	{
		document.forms[0].access.value= "copyExisting";
		document.forms[0].submit();
	}
}

function addFeesAmount()
{
	if(document.forms[0].feestype.options[document.forms[0].feestype.selectedIndex].value == "")
	{
		alert("Fill the Fees Type");
		document.forms[0].feestype.focus();
		return;
	}	
	if(document.forms[0].amount.value == "")
	{
		alert("Fill the Amount");
		document.forms[0].amount.focus();
		return;
	}
	if(confirm("Are You Sure to Enter") == 1)
	{
		document.forms[0].access.value= "insertfees";
		document.forms[0].submit();
	}
}

function feescancel()
{
	if(confirm("Do You want to Cancel the Process") == 1)
	{
		document.forms[0].access.value= "frames";
		document.forms[0].submit();
	}
}

function modifyfeesAmount()
{
	if(confirm("Do You want to Modify") == 1)
	{
		document.forms[0].access.value= "modifyfees";
		document.forms[0].submit();
	}
}

function updatefeestype()
{
	if(confirm("Are You Sure to Update") == 1)
	{
		document.forms[0].access.value= "updatefees";
		document.forms[0].submit();
	}
}

//--------Student Fees Module
function searchStudentfees()
{
	if(document.forms[0].year.value == "")
	{
		alert("Fill the Year");
		document.forms[0].year.focus();
		return;
	}
	if(document.forms[0].semester.value == "")
	{
		alert("Fill the Semester");
		document.forms[0].semester.focus();
		return;
	}
	if(confirm("Do You want the Information?") == 1)
	{
		document.forms[0].access.value= "search";
		document.forms[0].submit();
	}
}

function notExisting()
{
	document.forms[0].access.value= "freshAllocation";
	document.forms[0].submit();
}

function studentcancel()
{
	if(confirm("Do You want to Cancel the Process") == 1)
	{
		document.forms[0].access.value= "frames";
		document.forms[0].submit();
	}
}

function addStudentFees()
{
	if(document.forms[0].student.options[document.forms[0].student.selectedIndex].value == "")
	{
		alert("Select one Student");
		document.forms[0].student.focus();
		return;
	}
	if(confirm("Are You Sure to Enter") == 1)
	{
		document.forms[0].access.value= "insertstudentfees";
		document.forms[0].submit();
	}
}

function modifystudentFees()
{
	if(confirm("Do You want to modify the Details?") == 1)
	{
		document.forms[0].access.value= "modifystudentfees";
		document.forms[0].submit();
	}
}

function updatestudentFees()
{
	if(confirm("Changes will be made Permanently") == 1)
	{
		document.forms[0].access.value= "updatestudentfees";
		document.forms[0].submit();
	}
}

//Student Bank Module

function banknotExists()
{
	document.forms[0].access.value= "addnew";
	document.forms[0].submit(); 
}
function addStudentbank()
{
	if(confirm("Do you want add details of bank?") == 1)
	{
		document.forms[0].access.value= "insertbank";
		document.forms[0].submit();
	}
}

function cancel()
{
	if(confirm("Back to Previous page") == 1)
	{
		document.forms[0].access.value= "search";
		document.forms[0].submit();
	}
}

function modifystudentbank(x)
{
	if(confirm("Are You to mify the details?") == 1)
	{
		document.forms[0].studentId.value= x;
		document.forms[0].access.value= "modifybank";
		document.forms[0].submit();
	}
}

function updatestudentbank()
{
	if(confirm("The Changes will be made Permanently") == 1)
	{
		document.forms[0].access.value= "updatebank";
		document.forms[0].submit();
	}
}

//Frames
function RoomAllocationframe()
{
	document.forms[0].module.value= "RoomAllocation";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function TeacherRoomAllocationframe()
{
	document.forms[0].module.value= "TeacherRoomAllocation";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function SrdAllocationframe()
{
	document.forms[0].module.value= "SrdAllocation";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Student_Feesframe()
{
	document.forms[0].module.value= "studentfees";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Fees_Amountframe()
{
	document.forms[0].module.value= "fees_Amount";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Student_Bankframe()
{
	document.forms[0].module.value= "studentbank";
	document.forms[0].access.value= "search";
	document.forms[0].submit();
}
