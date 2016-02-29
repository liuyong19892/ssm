<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
				<table width="90%">
					<tr style="background-color: gray;">
						<th>Name</th>
						<th>Standard</th>
						<th>Age</th>
						<th>Sex</th>
					</tr>
					<c:forEach items="${users}" var="user">
						<tr style="background-color: silver;" id="${user.id}" onclick="setUpdateForm('${user.id}');">
							<td><c:out value="${user.name}"/></td>
							<td><c:out value="${user.standard}"/></td>
							<td><c:out value="${user.age}"/></td>
							<td><c:out value="${user.sex}"/></td>
						</tr>
					</c:forEach>
				</table>
				</center>
</body>
</html>