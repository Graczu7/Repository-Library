<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Table rows%cols</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<form action="addBookServlet" method="POST">


    <div class="form-group">
        <label for="exampleInputCategory1">Category</label>
        <input type="text" class="form-control" id="exampleInputCategory1" name="category" placeholder="Category">
    </div>
    <div class="form-group">
        <label for="exampleInputIsbn1">Isbn</label>
        <input type="text" class="form-control" id="exampleInputIsbn1" name="isbn" placeholder="Isbn">
    </div>
    <div class="form-group">
        <label for="exampleInputPages1">Pages</label>
        <input type=number" class="form-control" id="exampleInputPages1" name="pages" placeholder="Pages">
    </div>

    <div class="form-group">
        <label for="exampleInputRelease_date1">Release date</label>
        <input type="email" class="form-control" id="exampleInputRelease_date1" aria-describedby="emailHelp" name="release_date" placeholder="Release_date">
    </div>
    <div class="form-group">
        <label for="exampleInputSummary1">Summary</label>
        <input type="text" class="form-control" id="exampleInputSummary1" name="summary" placeholder="Summary">
    </div>
    <div class="form-group">
        <label for="exampleInputTitle1">Title</label>
        <input type="text" class="form-control" id="exampleInputTitle1" name="title" placeholder="Title">
    </div>
    <div class=“btn-group” role=“group”>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“add”>Add</button>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“edit”>Cancel</button>
    </div>
</form>
</body>
</html>