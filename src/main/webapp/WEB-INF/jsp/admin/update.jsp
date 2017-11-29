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
<title>Update Employee</title>
</head>
<body>
	<div class="container">
		<a href="../admin" class="btn btn-info">Back</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>PNC</td>
					<td>Name</td>
					<td>Username</td>
					<td>Password</td>
				</tr>
			</thead>
			<form:form action="update.upd" method="post" id="seachPatientForm"
				modelAttribute="employee">
				<tr class="${classSucess}">
					<td><form:input path="employeePNC"
							value="${employee.employeePNC}" readonly="true"
							class="form-control"
							cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
					<td><form:input class="form-control" path="employeeName"
							value="${employee.employeeName}" required="true" /></td>
					<td><form:input class="form-control" path="username"
							value="${employee.username}" required="true" /></td>
					<td><form:input class="form-control" path="password"
							value="${employee.password}" required="true" /></td>
					<td><form:select class="form-control" path="role"
							required="true">
							<c:forTokens items="Doctor,Secretary" delims="," var="rol">
								<form:option
									value="${rol == 'Doctor' ? 'ROLE_DOCTOR':'ROLE_SECRETARY'}">${rol}</form:option>
							</c:forTokens>
						</form:select></td>
					<td><input type="submit" class="btn btn-info" name="action"
						value="Update" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>