package br.com.uri.SpringDemo.controller;

import br.com.uri.SpringDemo.exception.NotFoundException;
import br.com.uri.SpringDemo.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;


    @Test
    public void givenAValidRequestWhenGettingHelloThenReturnOk() throws Exception {
        String URi = "/hello";
        when(helloService.sayHello()).thenReturn("Hello World");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URi)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test()
    public void givenAValidWithErrorRequestWhenGettingHelloThenReturnError500() throws Exception {
        String URi = "/hello";
        when(helloService.sayHello()).thenThrow(new NotFoundException("Error"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URi)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
