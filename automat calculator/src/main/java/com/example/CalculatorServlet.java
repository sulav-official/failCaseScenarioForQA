package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Pattern;

public class CalculatorServlet extends HttpServlet {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern OPERATION_PATTERN = Pattern.compile("^(add|sub|mult|div|per)$");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String num1Str = request.getParameter("num1");
            String num2Str = request.getParameter("num2");
            String num3Str = request.getParameter("num3");
            String operation = request.getParameter("operation");
            String csrfToken = request.getParameter("csrfToken");
            HttpSession session = request.getSession(false);

            if (session == null) {
                request.setAttribute("error", "Session expired. Please log in again.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            if (!isValidCSRFToken(session, csrfToken)) {
                request.setAttribute("error", "Invalid CSRF Token.");
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

            if (!isValidNumber(num1Str) || !isValidNumber(num2Str) || !isValidNumber(num3Str)) {
                request.setAttribute("error", "Invalid input. Please enter valid numbers.");
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

            if (!isValidOperation(operation)) {
                request.setAttribute("error", "Invalid operation.");
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int num3 = Integer.parseInt(num3Str);

            DemoApplication demoApplication = new DemoApplication();
            double result = 0;

            switch (operation) {
                case "add":
                    result = demoApplication.add(num1, num2, num3);
                    break;
                case "sub":
                    result = demoApplication.sub(num1, num2, num3);
                    break;
                case "mult":
                    result = demoApplication.mul(num1, num2, num3);
                    break;
                case "div":
                    if (num2 == 0 || num3 == 0) {
                        request.setAttribute("error", "Cannot divide by zero!");
                    } else {
                        result = demoApplication.div(num1, num2, num3);
                    }
                    break;
                case "per":
                    if (num2 == 0) {
                        request.setAttribute("error", "Cannot calculate percentage with zero as denominator!");
                    } else {
                        result = demoApplication.per(num1, num2);
                    }
                    break;
                default:
                    request.setAttribute("error", "Invalid operation.");
                    break;
            }

            request.setAttribute("result", result);
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input. Please enter valid numbers.");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }

    private boolean isValidNumber(String numberStr) {
        return numberStr != null && NUMBER_PATTERN.matcher(numberStr).matches();
    }

    private boolean isValidOperation(String operation) {
        return operation != null && OPERATION_PATTERN.matcher(operation).matches();
    }

    private boolean isValidCSRFToken(HttpSession session, String csrfToken) {
        String sessionToken = (String) session.getAttribute("csrfToken");
        return sessionToken != null && sessionToken.equals(csrfToken);
    }
}