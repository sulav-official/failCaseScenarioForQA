<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        /* Calculator styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        h1 {
            margin-bottom: 20px;
            color: #2c3e50;
        }
        input {
            margin: 15px 10px;
            padding: 10px;
            width: 60px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            margin: 10px 5px;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #2980b9;
        }
        .result {
            margin-top: 20px;
            font-size: 1.5em;
            color: #e74c3c;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("role") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="container">
    <h1>Calculator</h1>
    <form action="calculate" method="get">
        <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
        <input type="number" name="num1" placeholder="First Number" required>
        <input type="number" name="num2" placeholder="Second Number" required>
        <input type="number" name="num3" placeholder="Third Number" required>
        <br>
        <button type="submit" name="operation" value="add">Add</button>
        <button type="submit" name="operation" value="sub">Subtract</button>
        <button type="submit" name="operation" value="mult">Multiply</button>
        <button type="submit" name="operation" value="div">Divide</button>
        <button type="submit" name="operation" value="per">Percentage</button>
    </form>
    <div class="result">
        <c:if test="${not empty error}">
            <span class="error">${error}</span>
        </c:if>
        <c:if test="${not empty result}">
            Result: ${result}
        </c:if>
    </div>
</div>

</body>
</html>
