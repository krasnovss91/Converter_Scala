<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="userList" scope="request" type="java.util.List"/>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>User table</title>
</head>

<h2>User list</h2>
<h4><a href="${pageContext.request.contextPath}/Create">Go to User create page ... </a></h4>
<h3>${message}</h3>

<form action="${pageContext.request.contextPath}/Delete" method="POST">
    <input type="submit" value="Delete"><br><br>

    <table  class="table table-bordered">

        <thead class="thead-dark">
        <tr>
            <th scope="col">Delete</th>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Country</th>
            <th scope="col">Age</th>
            <th scope="col">Password</th>
        </tr>
        </thead>

        <tbody class="table-striped table-hover">

        <c:forEach var="user" items="${userList}">

            <tr>
                <th scope="row"><input type="checkbox" name="deleteList" value="${user.getId()}"></th>
                <th scope="row">
                    <a href="${pageContext.request.contextPath}/Update?id=${user.getId()}">
                            ${user.getId()}
                    </a>
                </th>
                <td>${user.getName()}</td>
                <td>${user.getCountry()}</td>
                <td>${user.getAge()}</td>
                <td>${user.getPassword()}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</form>
</body>
</html>
