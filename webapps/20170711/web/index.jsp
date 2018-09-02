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
    <title>Page 1</title>
</head>
<body>
<form action="insert.jsp" method="get">
    Enter username:<br>
    <input id="username" type="text" name="username"><br>
    <span id="output"></span>
</form>
<table>
    <%
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "root", "panatmysql_1994");
        statement = connection.createStatement();
        String query = "select voted, count(voted) as c from participation group by voted";
        rs = statement.executeQuery(query);
        while (rs.next()) {
            String ans = rs.getString("voted");
            String t = rs.getString("c");
    %>
    <tr>
        <td><%=ans %></td>
        <td><%=t %>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
