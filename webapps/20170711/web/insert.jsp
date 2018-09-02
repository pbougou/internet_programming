<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String connectionURL = "jdbc:mysql://localhost:3306/polls?serverTimezone=UTC";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
%>
<html>
<head>
    <title>Insert username</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    if (username != null) {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root", "panatmysql_1994");
        statement = connection.createStatement();
        rs = statement.executeQuery("select * from participation where username='" + username + "';");
        if (!rs.next()) {
            statement.executeUpdate("INSERT INTO participation(username) VALUES ('" + username + "');");
        }
        if (username.equals("admin")) {
%>

<jsp:forward page="admin.jsp"/>
<%
    ;
} else {
%>
<jsp:forward page="user.jsp"/>
<%
        }
        rs.close();
    }%>
</body>
</html>
