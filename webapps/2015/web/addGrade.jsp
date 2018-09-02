<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add rate</title>
</head>
<body>
<%
    Connection connection = null;
    Statement statement = null;

    String username = (String) session.getAttribute("SessionUsername");
    try {
        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        int rate = Integer.parseInt(request.getParameter("rate"));

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "panatmysql_1994");
        statement = connection.createStatement();
        String insert_query = "insert into rates(movie_id, username, rate) values (" + movie_id + ",'" + username + "'," + rate + ");";
        if (username != null) {
            statement.executeUpdate(insert_query);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>
