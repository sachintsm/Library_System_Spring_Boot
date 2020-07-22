<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>
    <script src="js/index.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
</head>
<body class="container-fluid">
<div class="container">
    <div class="row topic-div">
        <p class="topic">Library Management System</p>
    </div>
    <div class="button-bar">
        <div class="row">
            <div class="col-md-2">
                <button class="btn btn-primary">Issue Book</button>
            </div>
            <div class="col-md-5"></div>
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
                    <tr>
                        <td>1</td>
                        <td>Famous Five-1</td>
                        <td>Sachin Muthumala</td>
                        <td>10</td>
                        <td><a class="btn btn-warning" href="/edit">Edit Book</a></td>
                        <td><a class="btn btn-danger" href="/delete">Delete Book</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>