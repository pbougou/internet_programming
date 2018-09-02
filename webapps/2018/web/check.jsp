<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String connectionURL = "jdbc:mysql://localhost:3306/calc?serverTimezone=UTC";
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
%>
<html>
<head>
    <script type="text/javascript" src="js/split.js"></script>
    <title>Check</title>
</head>
<body>
<form name="form2" id="numbers" onsubmit="split();" method="get" action="check.jsp">
    <input type="text" name="numbers"/>
    <input type="submit" value="submit"></input>
</form>
<%
    String numbers = request.getParameter("numbers");
    if (numbers != null) {
        String nums[] = numbers.split(" ");
        if (nums != null) {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "panatmysql_1994");
            statement = connection.createStatement();
            for (String s : nums) {
                String query = "select * from type where word='" + s + "';";
                rs = statement.executeQuery(query);
                if (rs == null) {
                    System.out.println("NO");
                }
                while (rs.next()) {
                    String t = rs.getString("word");
%>
<tr>
    <td><%=t %>
    </td>
</tr>
<%
                }
            }
        }
    }
%>


</body>
</html>
