package kr.gamso.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.gamso.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    UsersService usersService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public  void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    @Transactional
    @DisplayName("id 중복체크")
    public void duplicateCheckIdTest() throws Exception{
        String id = "asd";
        String url = "/users/"+id;

        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

//        result.andExpect(status().isOk())
//                .andExpect(jsonPath("$.userIdCheck").value(1));
    }
}
