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
            <form:form modelAttribute="userAttribute" method="POST" action="update">
                <table >
                    <tr>
                        <td></td>
                        <td><form:hidden path="id" /></td>
                    </tr>
                    <tr>
                        <td>First name: </td>
                        <td><form:input path="firstName"/>
                            <form:errors path="firstName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td><form:input path="lastName"/>
                            <form:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Birth date :</td>
                        <td><form:input path="birthDate"/>
                            <form:errors path="birthDate" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><form:input path="gender"/>
                            <form:errors path="gender" cssClass="error"/></td>
                    </tr>
                </table>
                <input type="submit" value="Save"/>
            </form:form>

</div>
</body>
</html>