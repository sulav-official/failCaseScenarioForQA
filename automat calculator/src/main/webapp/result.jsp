<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Calculation Result</h2>
<% if (request.getAttribute("error") != null) { %>
<div style="color:red;"><%= request.getAttribute("error") %></div>
<% } else { %>
<div>The result is: <strong>${result}</strong></div>
<% } %>
<a href="logout">Logout</a>
</body>
</html>