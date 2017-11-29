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
		<a href="../secretary" class="btn btn-info">Back</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>PNC</td>
					<td>Name</td>
					<td>Id Card</td>
					<td>Birth date</td>
					<td>Address</td>
				</tr>
			</thead>
			<form:form action="update.upd" method="post" id="seachPatientForm"
				modelAttribute="client">
				<tr class="${classSucess}">
					<td><form:input path="clientPNC" value="${client.clientPNC}"
							readonly="true" class="form-control"
							cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
					<td><form:input class="form-control" path="clientName"
							value="${client.clientName}" required="true" /></td>
					<td><form:input class="form-control" path="clientIDCard"
							value="${client.clientIDCard}" pattern="^[A-Z]{2}[0-9]{6}$" required="true"
							placeholder="ID123456" /></td>
					<td><form:input class="form-control" path="birthdate"
					pattern="^\d{2}-\d{2}-\d{4}$" value="${client.birthdate}" required="true"
					placeholder="dd-MM-yyyy" /></td>
					<td><form:input class="form-control" path="address" value="${client.address}" required="true"/></td>
					<td><input type="submit" class="btn btn-info" name="action"
						value="Update" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>