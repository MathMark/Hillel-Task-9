<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bank App</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<p>Go to <a href="<c:url value="/accounts/accountList"/>">Accounts Page</a></p>
<p>Go to <a href="<c:url value="/users/usersList"/>">Users Page</a></p>

<div class="table">
    <form:form modelAttribute="accountAttribute" action="addAccount" method="post">
        <table>
            <tr>
                <td><form:label path="creationDate">Creation date (Format: yyyy-MM-dd)</form:label></td>
                <td><form:input path="creationDate"/>
                    <form:errors path="creationDate" cssClass="error" /></td>
            </tr>
            <tr>
                <td><span><form:label path="amount">Amount</form:label></span></td>
                <td><span><form:input path="amount"/>
                <form:errors path="amount" cssClass="error" /></span></td>
            </tr>
            <tr>
                <td><span><form:label path="userId">User id</form:label></span></td>
                <td><span><form:input path="userId"/>
                <form:errors path="userId" cssClass="error" /></span></td>
            </tr>
        </table>
        <input type="submit" value="Save"/>
    </form:form>
</div>
</body>
</html>