package com.cognizant.auth;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest(properties="eureka.client.enabled=false") @AutoConfigureMockMvc class AuthControllerTest {
 @Autowired MockMvc mvc; @Test void issuesJwt() throws Exception { mvc.perform(post("/auth/token").param("username","udbhaw")).andExpect(status().isOk()).andExpect(jsonPath("$.access_token").isNotEmpty()); }
}
