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
<link href="../resources/css/myCSS.css" rel="stylesheet">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Patient</title>
</head>
<body>
	<div class="container">
		<a href="../doctor" class="btn btn-info">Back</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Details</td>
					<td>Status</td>
				</tr>
			</thead>
			<form:form action="update.upd" method="post" id="seachPatientForm"
				modelAttribute="consultation">
				<tr class="${classSucess}">
					<form:hidden path="consultationID"
						value="${consultation.consultationID}" />
					<form:hidden path="consultationDate"
						value="${consultation.consultationDate}" />
					<form:hidden path="consultationTime"
						value="${consultation.consultationTime}" />
					<form:hidden path="clientPNC"
						value="${consultation.clientPNC}" />
					<form:hidden path="employeePNC"
						value="${consultation.employeePNC}" />
					<td><form:textarea class="form-control"
							path="consultationDetails"
							value="${consultation.consultationDetails}" required="true" /></td>
					<td><form:input class="form-control" path="consultationStatus"
							value="${consultation.consultationStatus}" required="true" /></td>
					<td><input type="submit" class="btn btn-info" name="action"
						value="Update" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>