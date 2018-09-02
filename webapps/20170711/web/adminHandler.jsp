<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%
    String connectionURL = "jdbc:mysql://localhost:3306/polls?serverTimezone=UTC";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
%>

<html>
<head>
    <title>Handle</title>
</head>
<body>
<%
    String t = request.getParameter("thema");
    if(t != null) {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root",  "panatmysql_1994");
        statement = connection.createStatement();
        statement.executeUpdate("UPDATE poll SET text='"  + t + "' WHERE id=1;");
        statement.executeUpdate("delete from participation where username != 'admin' ");

        %>
<jsp:forward page="index.jsp"></jsp:forward>
<%
        rs.close();
    }

%>
</body>
</html>
