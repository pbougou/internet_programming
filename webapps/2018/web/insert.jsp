<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%
    String connectionURL = "jdbc:mysql://localhost:3306/calc?serverTimezone=UTC";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
%>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String num = request.getParameter("number");
    if (num != null) {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root",  "panatmysql_1994");
        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO type(word) VALUES ('" + num + "');");
%>
<jsp:forward page="index.jsp"/>
<% rs.close();
}%>

<h2>
    Error<br>
</h2>
</body>
</html>
