package com.ebyaug.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebyaug.models.Item;

@RestController
public class HelloWorldController {
	@GetMapping("/helloworld")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Foo", 10, 200);
	}

}
