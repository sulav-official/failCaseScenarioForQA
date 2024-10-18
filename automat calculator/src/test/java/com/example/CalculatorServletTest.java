//package com.example;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CalculatorServletTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @WithMockUser // Simulates an authenticated user
//    public void testForbiddenWithoutCSRFToken() throws Exception {
//        mockMvc.perform(post("/calculate") // Simulate POST request to calculate endpoint
//                        .param("num1", "1")
//                        .param("num2", "2")
//                        .param("num3", "3")
//                        .param("operation", "add")) // No CSRF token provided
//                .andExpect(status().isForbidden()); // Expect 403 Forbidden response
//    }
//
//    @Test
//    @WithMockUser // Simulates an authenticated user
//    public void testSuccessfulRequestWithCSRFToken() throws Exception {
//        String csrfToken = "validCsrfToken"; // Replace with actual token generation logic
//
//        mockMvc.perform(post("/calculate") // Simulate POST request to calculate endpoint
//                        .param("num1", "1")
//                        .param("num2", "2")
//                        .param("num3", "3")
//                        .param("operation", "add")
//                        .param("csrfToken", csrfToken)) // Include valid CSRF token
//                .andExpect(status().isOk()); // Expect 200 OK response
//    }
//}