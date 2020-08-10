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
<div class="container">
    <div class=row>
        <h1>Update Issue</h1>
        <form class="form-group" action="updateIssue">
            <input id="id" name="id" type="hidden" value="${Issue.id}"/>
            <label for="name">User Name</label>
            <input class="form-control" type="text" name="author" value="${Issue.userName}"><br>
            <label for="name">Date</label>
            <input class="form-control" type="text" name="stock" value="${Issue.date}"><br>
            <label for="name">Book Id</label>
            <input class="form-control" type="text" name="stock" value="${Issue.bookId}"><br>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary" type="submit" style="width:15%">Update</button>

                    <a class="btn btn-warning" href="/cancel" style="width:15%">Cancel </a>
                </div>

            </div>

        </form>
    </div>
</div>
</body>
</html>