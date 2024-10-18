<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>

<form action="calculate" method="get">
    Number 1: <input type="text" name="num1" required/><br/>
    Number 2: <input type="text" name="num2" required/><br/>
    Number 3: <input type="text" name="num3" required/><br/>
    Operation:
    <select name="operation">
        <option value="add">Add</option>
        <option value="sub">Subtract</option>
        <option value="mult">Multiply</option>
        <option value="div">Divide</option>
        <option value="per">Percentage</option>
    </select><br/>
    <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}"/> <!-- CSRF Token -->
    <input type="submit" value="Calculate"/>
</form>

<% if (request.getAttribute("result") != null) { %>
<h3>Result: ${requestScope.result}</h3>
<% } %>

<% if (request.getAttribute("error") != null) { %>
<div style="color:red;"><%= request.getAttribute("error") %></div>
<% } %>

<a href="logout">Logout</a> <!-- Link to logout -->
</body>
</html>