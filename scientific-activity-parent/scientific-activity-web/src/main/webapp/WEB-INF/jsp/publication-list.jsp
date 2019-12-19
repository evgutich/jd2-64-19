<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Publication List</title>
</head>
<body>

<table>
    <tr>
        <td>Id</td>
        <td>Form</td>
        <td>Type</td>
        <td>Title</td>
        <td>Edition</td>
        <td>Authors</td>
        <td>Print run</td>
        <td>Pages</td>
        <td>Entry date</td>
    </tr>
    <c:forEach items="${publicationList}" var="publication">
        <tr>
            <td><c:out value="${publication.id}"/></td>
            <td><c:out value="${publication.form}"/></td>
            <td><c:out value="${publication.type}"/></td>
            <td><c:out value="${publication.title}"/></td>
            <td><c:out value="${publication.edition}"/></td>
            <td><c:out value="${publication.authors}"/></td>
            <td><c:out value="${publication.printRun}"/></td>
            <td><c:out value="${publication.pages}"/></td>
            <td><c:out value="${publication.entryDate}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>