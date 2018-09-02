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
    <title>handle user vote</title>
</head>
<body>
<%
    String t = request.getParameter("vote");
    Cookie[] cookies = request.getCookies();
    String username = "";
    for(int i = 0; i < cookies.length; i++) {
        if(cookies[i].getName().equals("username")) {
            username = cookies[i].getValue();
        }
    }
    if(t != null) {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root",  "panatmysql_1994");
        statement = connection.createStatement();
            statement.executeUpdate("UPDATE participation SET voted='"  + t + "' WHERE username='" + username + "';");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
        rs.close();
    }
%>

</body>
</html>
