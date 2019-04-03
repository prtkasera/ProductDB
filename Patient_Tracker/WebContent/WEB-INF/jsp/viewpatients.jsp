
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
</head>
<body>

<table>
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name </th>
<th>Contact Number</th>
<th>Email ID</th>
<!-- <th>Age</th>
<th>Gender</th>
<th>Date of Birth</th>
<th>Address Line</th>
<th>City</th>
<th>State</th>
<th>Zip Code</th>
 -->
</tr>
<c:forEach items="${patientList}" var="patient">
<tr>
<td>
<a href="viewonepatient.htm?patientId=${patient.patientId}">
<c:out value="${patient.patientId}"></c:out></a>
</td>
<td><c:out value="${patient.firstName}"/></td>
<td><c:out value="${patient.lastName}"/></td>
<td><c:out value="${patient.contactNumber}"/></td>
<td><c:out value="${patient.emailId}"/></td>
<%-- <td><c:out value="${patient.dob}"/></td>
<td><c:out value="${patient.age}"/></td>
<td><c:out value="${patient.gender}"/></td>
<td><c:out value="${patient.addressLine1}"/></td>
<td><c:out value="${patient.city}"/></td>
<td><c:out value="${patient.state}"/></td>
<td><c:out value="${patient.zipCode}"/></td> --%>
</tr>

</c:forEach>
</table>
<h3 style="color:red;">${status1}</h3>

<form method="post" action="addpatientform.htm">
<input type="submit" value="Add Patient"/>
</form>
<br>
<form method="post" action="afterlogin.htm">
<input type="submit" value="Home"/>
</form>



</body>
</html>