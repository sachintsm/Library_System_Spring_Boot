<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <title>Library System</title>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
     <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="container-fluid">
<div class="row topic-div">
    <p class="topic">Library Management System - Edit User</p>
</div>
<div class="container">
    <div class=row>
        <h1>Update User</h1>
        <form class="form-group" action="updateUser">
			 <input id="id" name="id" type="hidden" value="${User.userId}"/>
			 <label for="name">User First Name</label>
            <input class="form-control" type="text" name="fname" value="${User.fname}"><br>
            <label for="name">User Second Name</label>
            <input class="form-control" type="text" name="lname" value="${User.lname}"><br>
            <label for="name">User Address</label>
            <input class="form-control" type="text" name="address" value="${User.address}"><br>
            <label for="name">User Telephone</label>
            <input class="form-control" type="text" name="telephone" value="${User.telephone}"><br>
            <label for="name">User Email</label>
            <input class="form-control" type="text" name="email" value="${User.email}"><br>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary" type="submit" style="width:15%">Update</button>
               
                    <a class="btn btn-info" href="/userPage" style="width:15%">All Users </a>
                    <a class="btn btn-info" href="/" style="width:15%">Home </a>
                </div>

            </div>

        </form>
    </div>
    </div>
</body>
</html>