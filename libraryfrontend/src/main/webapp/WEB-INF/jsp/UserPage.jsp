<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Library System</title>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body class="container-fluid">
<div class="container">
    <div class=row>
        <h1>Users</h1>
        	<div class="table-div">
                <table class="table table-striped" id="userList">
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Second Name</th>
                        <th>Address</th>
                        <th>Telephone</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${User}" var="data">
                        <tr>
                            <td>${data.userId}</td>
                            <td>${data.fname}</td>
                            <td>${data.lname}</td>
                            <td>${data.address}</td>
                            <td>${data.telephone}</td>
                            <td>${data.email}</td>
                            <td>
                            <form action="getUser" method="get">
								<button class="btn btn-primary" name="id" value="${data.userId}">Edit</button>
							</form>
							</td>
                            <td><a class="btn btn-danger" href="/deleteUser/${data.userId}">Delete</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div><div class="row">
            <div class="col-md-6">
                <a class="btn btn-primary" href="/" style="width:15%">Home </a>
            </div>

            </div>
    </div>
    </div>
</body>
</html>