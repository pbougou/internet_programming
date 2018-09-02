<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello admin page</title>
</head>
<body>
<h1>Welcome <%=request.getParameter("username") %>! </h1>
<form action="adminHandler.jsp" method="get">
    Enter text<input id="thema" name="thema" type="text">
</form>

</body>
</html>
