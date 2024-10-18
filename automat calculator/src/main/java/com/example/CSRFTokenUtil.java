package com.example;

import java.security.SecureRandom;
import java.math.BigInteger;

/**
 * Utility class to generate secure CSRF tokens.
 */
public class CSRFTokenUtil {

    private static SecureRandom secureRandom = new SecureRandom();

    /**
     * Generates a secure random CSRF token.
     */
    public static String generateToken() {
        return new BigInteger(130, secureRandom).toString(32);
    }
}