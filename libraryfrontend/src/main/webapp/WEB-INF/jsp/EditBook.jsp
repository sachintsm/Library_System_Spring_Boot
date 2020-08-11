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
    <p class="topic">Library Management System - Edit Book</p>
</div>
<div class="container">
    <div class=row>
        <h1>Update Book</h1>
        <form class="form-group" action="updateBook">
			 <input id="id" name="id" type="hidden" value="${Book.id}"/>
			<label for="name">Book name</label>
            <input class="form-control" type="text" name="name" value="${Book.name}"><br>
            <label for="name">Author</label>
            <input class="form-control" type="text" name="author" value="${Book.author}"><br>
            <label for="name">Stock</label>
            <input class="form-control" type="text" name="stock" value="${Book.stock}"><br>
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