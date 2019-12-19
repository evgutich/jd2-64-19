<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<%@include file="include/header.jsp" %>
<%@include file="include/menu.jsp" %>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <table border="0">
        <tr>
            <td><fmt:message key="login.page.user.name"/></td>
            <td><input type="text" name="userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="login.page.user.password"/></td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td><fmt:message key="login.page.user.remember"/></td>
            <td><input type="checkbox" name="rememberMe" value="Y"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key="login.page.submit"/>"/>
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="include/footer.jsp"/>
</body>
</html>