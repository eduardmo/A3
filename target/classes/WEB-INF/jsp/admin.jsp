<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/customerValidation.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/myCSS.css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
</head>
<body>


	<div class="container">
		<a class="btn btn-info" href="logout">Logout</a>
		<h1>Patients</h1>
		<!--Search Form -->
		<form:form action="admin.get" method="get" id="seachAdminForm"
			modelAttribute="employee">
			<div class="form-group col-xs-5">
				<form:input type="text" path="employeePNC" class="form-control"
					required="true" value="" />
			</div>
			<input type="submit" class="btn btn-info" name="action"
				value="Search" />
			<input type="submit" class="btn btn-info" name="action"
				value="Show All" />
			<br></br>
			<br></br>
		</form:form>

		<a href="admin/add" class="btn btn-info">Add Employee</a>

		<c:choose>
			<c:when test="${not empty employeeList}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>PNC</td>
							<td>Name</td>
							<td>Username</td>
							<td>Role</td>
						</tr>
					</thead>
					<c:forEach var="employeel" items="${employeeList}">
						<c:set var="classSucess" value="" />
						<form:form action="admin.action" method="post"
							id="seachPatientForm" modelAttribute="employee">
							<tr class="${classSucess}">
								<td><form:input path="employeePNC"
										value="${employeel.employeePNC}" readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><form:input path="employeeName"
										value="${employeel.employeeName}" readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><form:input path="username"
										value="${employeel.username}" readonly="true"
										cssStyle="border:0px; width:100px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td>
									<c:set var="rol" value="${employeel.role}" />
									<c:if test=""></c:if>
								<form:input path="role" value="${employeel.role}"
										readonly="true"
										cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
								<td><a
									href="admin/update?employeePNC=${employeel.employeePNC}"
									class="btn btn-info">Update</a> <input type="submit"
									class="btn btn-info" name="action" value="Delete" /></td>
							</tr>
						</form:form>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<br />
				<div class="alert alert-info">No people found matching your
					search criteria</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>