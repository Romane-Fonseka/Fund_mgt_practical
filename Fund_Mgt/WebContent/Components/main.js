//form validation
$(document).ready(function()
		{ 
	if ($("#alertSuccess").text().trim() == "") 
	 { 
	 $("#alertSuccess").hide(); 
	 } 
	 $("#alertError").hide();
		});

//SAVE
$(document).on("click", "#btnSubmit", function(event)
		{ 		
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
	 
	// Form validation-
	var status = validateFundRForm(); 
	// If not valid-
	if (status != true) 
	 { 
	 $("#alertError").text(status); 
	 $("#alertError").show(); 
	 return; 
	 } 
	
	// If valid------------------------
	
	$.ajax( 
			 { 
			 url : "Fund_ReqAPI", 
			 type : type, 
			 data : $("#formFundReq").serialize(), 
			 dataType : "text", 
			 complete : function(response, status) 
			 { 
			 onItemSaveComplete(response.responseText, status); 
			 } 
			 }); 
	
	 $("#formFundReq").submit();
	 
			$("#alertSuccess").text("Request Sent Successfully.");
			$("#alertSuccess").show(); 
	 
			$("#formFundReq")[0].reset();
		});

//Update
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidItemIDSave").val($(this).data("UserID"));
 $("#txtrName").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#ddlfundingC").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#txtproject").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#txtemail").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#txtphone").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#txtaddress").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#txtAccNo").val($(this).closest("tr").find('td:eq(3)').text()); 
});

//Delete
$(document).on("click", ".btnDelete", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "Fund_ReqAPI", 
		 type : "DELETE", 
		 data : "UserID=" + $(this).data("UserID"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});



//Form Validation Function
function validateFundRForm()
	{ 
		//Validations 
		return true; 
	}

//Form Validation
function validateFundRForm()
{ 
// NAME
if ($("#txtrName").val().trim() == "") 
 { 
	return "Insert Researcher's name."; 
 } 

// Company
if ($("#ddlfundingC").val() == "0") 
 { 
 return "Select Funding Company."; 
 } 
return true; 
}

//Project name and Des
if ($("#txtproject").val().trim() == "") 
	{ 
		return "Insert Project name and description."; 
	} 

//Email
if ($("#txtemail").val().trim() == "") 
{ 
	return "Insert email."; 
} 

//Phone
if ($("#txtphone").val().trim() == "") 
{ 
	return "Insert phone."; 
} 

//Address
if ($("#txtaddress").val().trim() == "") 
{ 
	return "Insert address."; 
} 

//Account No
if ($("#txtAccNo").val().trim() == "") 
{ 
	return "Insert Account No."; 
} 

//Complete Save
function onFUnd_ReqstSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 14
 $("#hidItemIDSave").val(""); 
 $("#formItem")[0].reset(); 
}

//Complete Delete

function onFund_ReqstDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}








