package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoApplicationTest {

    private final DemoApplication demoApplication = new DemoApplication();

    // Passing Tests
    @Test
    public void testAdd() {
        assertEquals(6, demoApplication.add(1, 2, 3), "1 + 2 + 3 should equal 6");
        assertEquals(0, demoApplication.add(0, 0, 0), "0 + 0 + 0 should equal 0");
        assertEquals(-6, demoApplication.add(-1, -2, -3), "-1 + -2 + -3 should equal -6");
    }

    @Test
    public void testSub() {
        assertEquals(0, demoApplication.sub(3, 2, 1), "3 - 2 - 1 should equal 0");
        assertEquals(-1, demoApplication.sub(2, 3, 0), "2 - 3 - 0 should equal -1");
        assertEquals(5, demoApplication.sub(5, 0, 0), "5 - 0 - 0 should equal 5");
    }

    @Test
    public void testMul() {
        assertEquals(6, demoApplication.mul(1, 2, 3), "1 * 2 * 3 should equal 6");
        assertEquals(0, demoApplication.mul(0, 2, 3), "0 * 2 * 3 should equal 0");
        assertEquals(-6, demoApplication.mul(-1, 2, 3), "-1 * 2 * 3 should equal -6");
    }

    @Test
    public void testDiv() {
        assertEquals(1.5, demoApplication.div(3, 2, 1), "3 / 2 / 1 should equal 1.5");

        // Test division by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            demoApplication.div(5, 0, 1);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());

        exception = assertThrows(ArithmeticException.class, () -> {
            demoApplication.div(5, 2, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testCSRFtoken() {
        assertEquals(50.0, demoApplication.per(50, 100), "50 is 50% of 100");

        // Test percentage calculation with zero denominator
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            demoApplication.per(50, 0);
        });
        assertEquals("Division by zero is not allowed for percentage calculation.", exception.getMessage());
    }

    // Failing Tests
    @Test
    public void testAddFail() {
        assertNotEquals(7, demoApplication.add(1, 2, 3), "1 + 2 + 3 should not equal 7"); // This should fail
        assertNotEquals(1, demoApplication.add(0, 0, 0), "0 + 0 + 0 should not equal 1"); // This should fail
        assertNotEquals(-5, demoApplication.add(-1, -2, -3), "-1 + -2 + -3 should not equal -5"); // This should fail
    }

    @Test
    public void testSubFail() {
        assertNotEquals(1, demoApplication.sub(3, 2, 1), "3 - 2 - 1 should not equal 1"); // This should fail
        assertNotEquals(0, demoApplication.sub(5, 2, 2), "5 - 2 - 2 should not equal 0"); // This should fail
        assertNotEquals(-4, demoApplication.sub(5, 3, 0), "5 - 3 - 0 should not equal -4"); // This should fail
    }

    @Test
    public void testMulFail() {
        assertNotEquals(8, demoApplication.mul(1, 2, 3), "1 * 2 * 3 should not equal 8"); // This should fail
        assertNotEquals(-1, demoApplication.mul(0, 2, 3), "0 * 2 * 3 should not equal -1"); // This should fail
        assertNotEquals(6, demoApplication.mul(-1, -2, 3), "-1 * -2 * 3 should not equal 6"); // This should fail
    }

    @Test
    public void testDivFail() {
        assertNotEquals(2, demoApplication.div(5, 2, 1), "5 / 2 / 1 should not equal 2"); // This should fail
        assertNotEquals(3, demoApplication.div(9, 3, 1), "9 / 3 / 1 should not equal 3"); // This should fail
    }

    @Test
    public void testCSRFtokenFail() {
        assertNotEquals(60.0, demoApplication.per(50, 100), "50 is not 60% of 100"); // This should fail
        assertNotEquals(100.0, demoApplication.per(50, 0), "50 is not 100% of 0"); // This should fail
    }
}
