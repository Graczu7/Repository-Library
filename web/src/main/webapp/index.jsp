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
<jsp:include page="WEB-INF/header.jsp"/>
<form action=“HomeServlet” method=“POST”>
    <table class=“table”>
        <thead class=“thead-light”>
        <tr>
            <th scope=“col”>Title</th>
            <th scope=“col”>First Name</th>
            <th scope=“col”>Last Name</th>
            <th scope=“col”>ISBN</th>
            <th scope=“col”>Category</th>
            <th scope=“col”></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${requestScope.book}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author_id.first_name}</td>
            <td>${book.author_id.last_name}</td>
            <td>${book.isbn}</td>
            <td>${book.category}</td>
            <td><input type=“radio” name=“checkboxBookChoice” value=${book.id_book}>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class=“btn-group” role=“group”>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“add”>Add</button>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“edit”>Edit</button>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“delete”>Delete</button>
        <button type=“submit” class=“btn btn-secondary” name=“action” value=“show”>Show</button>
    </div>
</form>

</body>
</html>
