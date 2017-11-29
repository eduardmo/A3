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
<title>Add Consultation</title>
</head>
<body>
	<div class="container">
		<a href="../secretary" class="btn btn-info">Back</a>
		<form:form action="consultation.add" method="post"
			modelAttribute="consultation" data-toggle="validator">
			<h2>Consultation</h2>
			<div class="form-group col-xs-4">
				<label class="control-label col-xs-4">Date:</label>
				<form:input class="form-control" path="consultationDate"
					id="datepicker1" required="true" />
				<label class="control-label col-xs-4">Time:</label>
				<form:input class="form-control" path="consultationTime"
					id="timepicker1" required="true" />
				<label class="control-label col-xs-4">Doctor:</label>
				<form:select class="form-control" path="employeePNC" required="true">
					<c:forEach items="${employee}" var="employeel">
						<form:option value="${employeel.employeePNC}">${employeel.employeeName}</form:option>
					</c:forEach>
				</form:select>
				<form:hidden class="form-control" path="clientPNC"
					value="${clientPNC}" />
				<br /> <input type="submit" class="btn btn-info" name="action"
					value="Add" />
				<script type="text/javascript">
					$(function() {
						$("#datetimepicker1").datetimepicker();
					});
				</script>
			</div>
		</form:form>
		<br />
		<table class="table table-striped">
			<thead>
				<tr>
					<td>ConsultationID</td>
					<td>Date</td>
					<td>Time</td>
					<td>Doctor</td>
				</tr>
			</thead>
			<c:forEach var="consl" items="${consList}">
				<c:set var="classSucess" value="" />
				<form:form action="consultation.delete" method="post"
					modelAttribute="consultation">
					<tr class="${classSucess}">
						<form:input path="clientPNC" hidden="true"
								value="${consl.clientPNC}" readonly="true"
								cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" />
						<td><form:input path="consultationID"
								value="${consl.consultationID}" readonly="true"
								cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
						<td><form:input path="consultationDate"
								value="${consl.consultationDate}" readonly="true"
								cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
						<td><form:input path="consultationTime"
								value="${consl.consultationTime}" readonly="true"
								cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
						<td><form:input path="employeePNC"
								value="${consl.employeePNC}" readonly="true"
								cssStyle="border:0px; cursor:default; background-color:rgba(0,0,0,0.0);" /></td>
						<td><a href="secretary" class="btn btn-info">Update</a> <input
							type="submit" class="btn btn-info" name="action" value="Delete" />
					</tr>
				</form:form>
			</c:forEach>
		</table>
	</div>
</body>
</html>