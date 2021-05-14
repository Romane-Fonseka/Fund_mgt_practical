<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Request</title>
<script src="Components/main.js"></script>
<script src="src/com/Fund_Reqst_Function.java"></script>
</head>

<body>
<div>
<form id="formFundReq">

<!-- NAME -->
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
 <span class="input-group-text" id="lblrName">Researcher's Name: </span>
</div>
<input type="text" id="txtrName" name="txtrName">
</div>

<!-- YEAR -->
<div class="input-group input-group-sm mb-3">
<div class="input-group-prepend">
 <span class="input-group-text" id="lblFundC">Select Funding Companies </span>
</div>

<select id="ddlfundingC1" name="ddlfundingC1">
 <option value="0">--Select Funding Companies--</option>
 <option value="1">Sand Box</option>
 <option value="2">Valley</option>
 <option value="3">99X</option>
 <option value="4">Octave</option>
</select>

<select id="ddlfundingC2" name="ddlfundingC2">
 <option value="0">--Select Funding Companies--</option>
 <option value="1">Sand Box</option>
 <option value="2">Valley</option>
 <option value="3">99X</option>
 <option value="4">Octave</option>
</select>

<select id="ddlfundingC3" name="ddlfundingC3">
 <option value="0">--Select Funding Companies--</option>
 <option value="1">Sand Box</option>
 <option value="2">Valley</option>
 <option value="3">99X</option>
 <option value="4">Octave</option>
</select>
</div>

<!-- Project Name and Description -->
<div>
<span class="input-group-text" id="lblproject">Project Name and Description: </span>
<textarea id ="txtproject" name ="txtproject" rows="5" cols="50"></textarea>
</div>

<!-- Email -->
<div>
<span class="input-group-text" id="lblemail">Email: </span>
</div>
<div>
<input type="text" id="txtemail" name="txtemail">
</div>

<!-- Phone -->
<div>
<span class="input-group-text" id="lblPhone">Address: </span>
</div>
<div>
<input type="text" id="txtPhone" name="txtPhone">
</div>

<!-- Address -->
<div>
<span class="input-group-text" id="lbladdress">Address: </span>
</div>
<div>
<textarea id ="txtaddress" name ="txtaddress" rows="5" cols="6"></textarea>
</div>

<!-- Account no -->
<div>
<span class="input-group-text" id="lblAcc">Address: </span>
</div>
<div>
<input type="text" id="txtAccNo" name="txtAccNo">
</div>

<input type="button" id="btnSubmit" value="Submit" class="btn btn-primary">


</form>
</div>
</body>
</html>



