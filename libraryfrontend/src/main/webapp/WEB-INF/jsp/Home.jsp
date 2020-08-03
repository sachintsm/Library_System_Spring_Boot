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
    <div class="button-bar">
        <div class="row">
            <div class="col-md-2">
                <Form action="IssueBook">
                    <button type="submit" class="btn btn-primary">Issue Book</button>
                </Form>
            </div>
            <div class="col-md-2">
                <Form action="addMe">
                    <button type="submit" class="btn btn-primary">Add Book</button>
                </Form>
            </div>
            <div class="col-md-3"></div>
            <div class="col-md-5">
                <div class="row">
                    <form onsubmit="event.preventDefault(); onFormSubmit();">
                        <div class="col-md-9">
                            <input type="text" class="form-control" placeholder="Search by ID"/>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-primary">Search</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="table-div">
                <table class="table table-striped" id="bookList">
                    <caption>Books List</caption>
                    <thead>
                    <tr>
                        <th>Book Number</th>
                        <th>Book Name</th>
                        <th>Author</th>
                        <th>Stock</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Book}" var="data">
                        <tr>
                            <td>${data.id}</td>
                            <td>${data.name}</td>
                            <td>${data.author}</td>
                            <td>${data.stock}</td>
                            <td>
                            <form action="getBook" method="get">
								<button class="btn btn-primary" name="id" value="${data.id}">edit</button>
							</form>
							</td>
                            <td><a class="btn btn-danger" href="/deleteBook/${data.id}">Delete Book</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>