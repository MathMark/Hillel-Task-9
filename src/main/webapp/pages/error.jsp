<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>${error}</h1>
    <p>Status: ${status}</p>
    <p>${message}</p>
    <p>${exception}</p>
    <p>Go back to <a href="<c:url value="/" />">main page</a></p>
    <p><b>Stack trace is</b><br>
        <pre>${trace}</pre>
    </p>
</body>
</html>