package com.ebyaug;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ebyaug.controller.HelloWorldController;

@WebMvcTest(HelloWorldController.class)
class ControllerTest {
	@Autowired
	MockMvc mockmvc;
	@Test
	void helloWorldBasic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/helloworld").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals("Hello World", result.getResponse().getContentAsString());
				
	}
	
	@Test
	void getItemBasic() throws Exception
	{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item").accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request)
				.andExpect(content().json("{\"id\": 1,\"name\":\"Foo\",\"price\":10,\"quantity\":200}"))
				.andReturn();
	}

}
