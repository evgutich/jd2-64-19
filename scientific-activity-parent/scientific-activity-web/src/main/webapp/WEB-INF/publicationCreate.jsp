<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Publication</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/publicationCreate">
    <label> Type: <input type="text" name="type"/> </label>
    <br>
    <label> Title: <input type="text" name="title"/> </label>
    <br>
    <label> Edition: <input type="text" name="edition"/> </label>
    <br>
    <label> Authors: <input type="text" name="authors"/> </label>
    <br>
    <label> Print run: <input type="number" name="printRun"/> </label>
    <br>
    <label> Pages: <input type="number" name="pages"/> </label>
    <br>
    <input type="submit">
</form>
</body>
</html>