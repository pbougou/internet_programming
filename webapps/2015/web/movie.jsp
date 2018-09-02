<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    ResultSet avg = null;

    HttpSession session1 = request.getSession(true);
    session.setAttribute("SessionUsername", request.getParameter("name"));

    String username = (String) session.getAttribute("SessionUsername");
    if (username == null) {
        username = "You must enter a username in home section in order to grade";
    }

%>


<html>
<head>
    <title>Movies</title>
</head>
<body>
<h1><%=username%>
</h1>
<%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "panatmysql_1994");
        statement = connection.createStatement();
        String sqSelect = "SELECT * FROM movies";
        rs = statement.executeQuery(sqSelect);


        while (rs.next()) {
%>
<tr>
    <td><%=rs.getInt("id") %>
    </td>
    <td><%=rs.getString("title") %>
    </td>
    <td><%=rs.getString("year") %>
    </td>

</tr>
<br>
<%
    }
    rs.close();
    String avgRate = "SELECT movie_id, avg(rate) as AVG FROM rates GROUP BY movie_id";
    avg = statement.executeQuery(avgRate);

    while (avg.next()) {
%>
<tr>
    <td>
        <%=avg.getString("movie_id")%>
    </td>
    <td>
        <%=avg.getString("AVG")%>
    </td>
</tr>
<br>
<%
        }


    } catch (Exception e) {
        e.printStackTrace();
    }

%>

</body>
</html>
