<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="../resources/js/customerValidation.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery.timepicker.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker1").datepicker({
			altFormat : "dd-MM-yyyy"
		});
		$("#timepicker1").timepicker({
			timeFormat : "hh:mm"
		});
	});
</script>
<link href="../resources/css/jquery-ui.css" rel="stylesheet">
<link href="../resources/css/jquery.timepicker.min.css" rel="stylesheet">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet"></link>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
</head>
<body>
	<div class="container">
		<a href="../secretary" class="btn btn-info">Back</a>
		<form:form action="add.add" method="post" modelAttribute="client"
			data-toggle="validator">
			<h2>Client</h2>
			<div class="form-group col-xs-4">
				<label class="control-label col-xs-4">PNC:</label>
				<form:input class="form-control" path="clientPNC" value=""
					required="true" pattern="^[1-9]{1}[0-9]{12}$"/>
				<label class="control-label col-xs-4">Name:</label>
				<form:input class="form-control" path="clientName" value=""
					required="true" />
				<label class="control-label col-xs-4">ID Card:</label>
				<form:input class="form-control" path="clientIDCard" value=""
					pattern="^[A-Z]{2}[0-9]{6}$" required="true" placeholder="ID123456"/>
				<label class="control-label col-xs-4">Birthdate:</label>
				<form:input id="datepicker1" class="form-control" path="birthdate"
					pattern="^\d{2}/\d{2}/\d{4}$" value="" required="true"
					placeholder="dd/MM/yyyy" />
				<label class="control-label col-xs-4">Address:</label>
				<form:input class="form-control" path="address" value=""
					required="true" />
				<input type="submit" class="btn btn-info" name="action" value="Add" />
			</div>
		</form:form>
	</div>
</body>
</html>