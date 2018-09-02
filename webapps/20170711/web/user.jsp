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
    <title>Hello user page</title>
</head>
<body>
<h1><%=request.getParameter("username") %>
</h1>
<%
    String username = request.getParameter("username");
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    connection = DriverManager.getConnection(connectionURL, "root", "panatmysql_1994");
    statement = connection.createStatement();
    rs = statement.executeQuery("SELECT * from participation where username='" + username + "';");
    while (rs.next()) {
        String vote = rs.getString("voted");
        if (vote == null) {
            response.addCookie(new Cookie("username", username));
%>
<form action="handleUser.jsp" method="get">
    <input type="radio" name="vote" value="yes"> Yes <br>
    <input type="radio" name="vote" value="no"> No <br>
    <input type="submit" value="submit">

</form>
<%
            ;
        }
        else {
%>
<h3> You voted <%=vote %></h3>
<%
        }
    }

%>
</body>
</html>
