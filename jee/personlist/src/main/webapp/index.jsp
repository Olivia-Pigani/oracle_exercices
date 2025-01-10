<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Person List</title>
</head>
<body>
<h1><%= "Person List" %>
</h1>
<br/>

<table class="table my-5">
    <thead>
    <tr>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">age</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:if test="${personsList != null}">
    <c:forEach items="${personsList}" var="person">
    <td>${person.firstName()}</td>
    <td>${person.lastName()}</td>
    <td>${person.birthDate()}</td>
    </tr>

    </c:forEach>
    </c:if>
    </tbody>

</table>


</body>
</html>