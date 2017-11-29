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
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function poll() {
		$.ajax({
			url : 'check',
			success : function(data) {

				data = data;
				if (data[0] != "") {
					$("#che").css('visibility', 'visible');
					$("#div1").html(data[0]);
					$("#consID").val(data[1]);
					console.log($("#consID").val());
				}
			}
		});
	}
	setInterval(poll, 5000);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor</title>
</head>
<body>
	<!--<a href="user">Back</a>-->

	<div class="container">
		<a href="logout" class="btn btn-info">Logout</a>
		<h1>Doctor</h1>
		<table>
			<tr>
				<form:form action="doctor.acc" method="post"
					modelAttribute="consultation">
					<td><h3 style="color: green; width: 300px;" id="div1"></h3></td>
					<td><form:hidden id="consID" path="consultationID"
							class="form-control" /></td>
					<td><input id="che" style="visibility: hidden;" type="submit"
						class="btn btn-info" name="action" value="Accept Patient" /></td>
				</form:form>
			</tr>
		</table>
		<br> <br>
		<!--Search Form -->
		<form:form action="doctor.get" method="get" id="seachPatientForm"
			modelAttribute="client">
			<div class="form-group col-xs-5">
				<form:input type="text" path="clientPNC" class="form-control"
					required="true" value="" />
			</div>
			<input type="submit" class="btn btn-info" name="action"
				value="Show Patient Previous Consultations" />
			<input type="submit" class="btn btn-info" name="action"
				value="Show All Previous Consultations" />
			<br></br>
			<br></br>
		</form:form>
		<c:choose>
			<c:when test="${not empty consl}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Consultation ID</td>
							<td>Date</td>
							<td>Time</td>
							<td>Patient PNC</td>
							<td>Patient Name</td>
							<td>Actions</td>
						</tr>
					</thead>
					<c:forEach var="cons" items="${consl}">
						<c:set var="serv" value="${ser}" />
						<tr class="${classSucess}">
							<td>${cons.consultationID}</td>
							<td>${cons.consultationDate}</td>
							<td>${cons.consultationTime}</td>
							<td>${cons.clientPNC}</td>
							<td>${serv.getClientByPNC(cons.clientPNC).getClientName()}</td>
							<td><a
								href="doctor/update?consultationID=${cons.consultationID}"
								class="btn btn-info">Update/View Details</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<br />
				<div class="alert alert-info">No consultations found for the
					specified client</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>