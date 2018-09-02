<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<html>
  <head>
      <script type="text/javascript" src="js/validate.js"></script>
      <title>Numchecker</title>
  </head>

  <body>
    <form action="insert.jsp" method="get">
        Enter a number:<br>
        <input id="number" type="text" onkeyup="validate()" name="number"><br>
        <span id="output"></span>
    </form>
  </body>
</html>

