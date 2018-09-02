<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/code.js"></script>
    <title>Rate</title>
</head>
<body>
<h2>Hello <%=session.getAttribute("SessionUsername")%>
</h2>
<form action="addGrade.jsp" method="post">
    <input type="text" name="movie_id"/>
    <input id="rate" type="text" onkeyup="validate()" name="rate"/>
    <span id="output"></span>
</form>
</body>
</html>
