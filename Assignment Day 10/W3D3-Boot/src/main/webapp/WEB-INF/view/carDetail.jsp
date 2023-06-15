<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Car</title>
</head>
<body>
	<form:form action="${action}" method="post" modelAttribute="car"  >	
	<table>
		<tr>
			<td>Make:</td>
			<td><form:input path="make" /></td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><form:input path="model" /></td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><form:input path="year" /></td>
		</tr>
		<tr>
			<td>Color:</td>
			<td><form:input path="color" /></td>
		</tr>
	</table>
	<c:if test="${msg == 'Update'}">
		<button type="submit">Update</button>
	</c:if>
	<c:if test="${msg == 'Add'}">
		<button type="submit">Add</button>
	</c:if>

</form:form>
	<!-- <input type="submit" value="${msg}"/> -->
	 <c:if test="${msg == 'Update'}">
		<form:form action="/cars/delete/${car.id}" method="post">
			<input type="hidden" name="carId" value="${car.id}" />
			<button type="submit">Delete</button>
		</form:form>
		
	</c:if>
</body>
</html> 
