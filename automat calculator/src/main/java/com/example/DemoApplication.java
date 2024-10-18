package com.example;

/**
 * Core business logic for arithmetic operations.
 */
public class DemoApplication {

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int sub(int a, int b, int c) {
        return a - b - c;
    }

    public int mul(int a, int b, int c) {
        return a * b * c;
    }

    public double div(int a, int b, int c) {
        if (b == 0 || c == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b / c; // Adjust as needed for your logic
    }

    public double per(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed for percentage calculation.");
        }
        return ((double) a / b) * 100; // Calculate percentage
    }
}