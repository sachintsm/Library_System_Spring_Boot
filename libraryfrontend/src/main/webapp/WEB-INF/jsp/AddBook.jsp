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
    <div class="row topic-div">
        <p class="topic">Library Management System</p>
    </div>
    <div class=row>
        <h1>Add New Book Form</h1>
        <form class="form-group" action="addBook">
            <label for="name">Book name</label>
            <input class="form-control" type="text" name="name"><br>
            <label for="name">Author</label>
            <input class="form-control" type="text" name="author"><br>
            <label for="name">Stock</label>
            <input class="form-control" type="text" name="stock"><br>
            <div class="row">
                <div class="col-md-6">
                    <button class="btn btn-primary" type="submit" style="width:100%">Submit</button>
                </div>
                <div class="col-md-6">
                    <a class="btn btn-warning" href="/cancel" style="width:100%">Cancel </a>
                </div>

            </div>

        </form>
    </div>
</div>
</body>
</html>
