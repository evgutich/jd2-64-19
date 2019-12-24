<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@include file="../include/header.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/publicationCreate">
    <table>
        <tr>
            <td><label>Type:</label></td>
            <td><input type="text" name="type"/></td>
        </tr>
        <tr>
            <td><label>Title:</label></td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td><label>Edition:</label></td>
            <td><input type="text" name="edition"/></td>
        </tr>
        <tr>
            <td><label>Authors:</label></td>
            <td><input type="text" name="authors"/></td>
        </tr>
        <tr>
            <td><label>Print run:</label></td>
            <td><input type="text" name="printRun"/></td>
        </tr>
        <tr>
            <td><label>Pages:</label></td>
            <td><input type="text" name="pages"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
<%@include file="../include/footer.jsp" %>