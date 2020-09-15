package com.ebyaug;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemIntegrationTest {
	
	@Autowired
	TestRestTemplate trt;
	
	@Test
	void test() throws JSONException {
		String forObject = trt.getForObject("/getfromdb", String.class);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]", forObject, false);
	}

}
