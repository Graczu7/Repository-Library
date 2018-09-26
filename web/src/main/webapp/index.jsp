<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/HomeServlet" method="post">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Lp.</th>
                <th>Title</th>
                <th>Isbn</th>
                <th>Category</th>
                <th>Release</th>
                <th>Pages</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.books}" var="book" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.category}</td>
                <td>${book.release}</td>
                <td>${book.pages}</td>
                <td>${book.authorName}</td>
                <td><input class="form-check-input" type="radio" name="bookId" value="${book.id}" checked></td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
        <input type="submit" class="btn btn-info" name="action" value="ADD">
        <input type="submit" class="btn btn-warning" name="action" value="EDIT">
        <input type="submit" class="btn btn-dark" name="action" value="SHOW">
        <input type="submit" class="btn btn-danger" name="action" value="DELETE">
    </form>
</div>
</body>
</html>
