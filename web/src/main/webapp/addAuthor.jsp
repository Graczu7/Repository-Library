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
        <label for="exampleInputFirst_name1">First name</label>
        <input type="text" class="form-control" id="exampleInputFirst_name1" name="first_name" placeholder="First_name">
    </div>
    <div class="form-group">
        <label for="exampleInputLast_name1">Last name</label>
        <input type="text" class="form-control" id="exampleInputLast_name1" name="last_name" placeholder="Last_name">
    </div>
    <div class="form-group">
        <label for="exampleInputBirth_place1">Birth place</label>
        <input type="text" class="form-control" id="exampleInputBirth_place1" name="birth_place" placeholder="Birth_place">
    </div>
    <div class=“btn-group” role="group">
        <button type="submit" class="btn btn-secondary" name="action" value="add">Add</button>
        <button type="button" class="btn btn-danger" name="action" value="cancel">Cancel</button>
    </div>
</form>
</body>
</html>