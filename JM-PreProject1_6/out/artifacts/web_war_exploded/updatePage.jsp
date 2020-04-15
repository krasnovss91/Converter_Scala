<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>User update page</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/Update?id=${user.id}" method="POST">

    <h2> User update page:</h2><br>
    <h4><a href="${pageContext.request.contextPath}/Table">Go to user list page ... </a></h4>
    <h3>${message}</h3>

    <div class="form-group">
        <label for="userName">User name</label>
        <input placeholder="${user.name}" type="text" width=100px name="name" class="form-control" id="userName" aria-describedby="userNameHelp">
        <small id="userNameHelp" class="form-text text-muted">Enter user name</small>
    </div>
    <div class="form-group">
        <label for="userCountry">User country</label>
        <input placeholder="${user.country}" type="text"  width=100px name="country" class="form-control" id="userCountry" aria-describedby="userSurnameHelp">
        <small id="userCountryHelp" class="form-text text-muted">Enter user country</small>
    </div>
    <div class="form-group">
        <label for="userPassword">User password</label>
        <input placeholder="${user.password}" type="text"  width=100px name="password" class="form-control" id="userPassword" aria-describedby="userPasswordHelp">
        <small id="userPasswordHelp" class="form-text text-muted">Enter user password</small>
    </div>
    <div class="form-group">
        <label for="userAge">User age</label>
        <input placeholder="${user.age}" type="text"  width=100px name="age" class="form-control" id="userAge" aria-describedby="userAgeHelp">
        <small id="userAgeHelp" class="form-text text-muted">Enter user age</small>
    </div>

    <button type="submit" class="btn btn-primary">Update user</button>
</form>
</body>
</html>
