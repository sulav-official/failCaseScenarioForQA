//package com.example;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithAnonymousUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class HomePageRedirectionTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @WithAnonymousUser // Simulates an unauthenticated user
//    public void testInvalidHomePageRedirection() throws Exception {
//        mockMvc.perform(get("/")) // Simulate GET request to the home page
//                .andExpect(status().is3xxRedirection()) // Expect a 3xx redirection status
//                .andExpect(redirectedUrl("login.jsp")); // Expect redirection to the login page
//    }
//}