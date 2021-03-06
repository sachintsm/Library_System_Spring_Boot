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
<div class="row topic-div">
    <p class="topic">Library Management System - Issue Book</p>
</div>
<div class="container">

    <div class=row>
        <h1>Add Issue Book</h1>
        <form class="form-group" action="issueBookClick">
            <label for="name">User name</label>
            <input class="form-control" type="text" name="userName"><br>
            <label for="name">Book Id</label>
            <input class="form-control" type="text" name="bookId"><br>
            <label for="name">Date</label>
            <input class="form-control" type="date" name="date"><br>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary" type="submit" style="width:15%">Submit</button>
                    <a class="btn btn-warning" href="/cancel" style="width:15%">Cancel </a>
                </div>

            </div>
        </form>

        <div class="table-div">
            <table class="table table-striped" id="issueList">
                <caption>Issue List</caption>
                <thead>
                <tr>
                    <th>Issue ID</th>
                    <th>User Name</th>
                    <th>Book ID</th>
                    <th>Date</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${IssueBook}" var="data">
                    <tr>
                        <td class="col-md-1">${data.id}</td>
                        <td class="col-md-4">${data.userName}</td>
                        <td class="col-md-1">${data.bookId}</td>
                        <td class="col-md-2">${data.date}</td>
                        <td class="col-md-2">
                            <form action="editIssue" method="get">
                                <button class="btn btn-primary" name="id" value="${data.id}">Edit Issue</button>
                            </form>
                        </td>
                        <td class="col-md-2">
                            <a class="btn btn-danger" href="/deleteIssue/${data.id}">Delete Issue</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>