package com.ebyaug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebyaug.models.Item;
import com.ebyaug.repository.ItemRepo;
import com.ebyaug.services.BusinessServiceClass;

@RestController
public class HelloWorldController {
	@Autowired
	BusinessServiceClass bsObj;

	@GetMapping("/helloworld")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Foo", 10, 200);
	}

	@GetMapping("/dummyallitem")
	public Item getItemThroughBS() {
		return bsObj.getAllItems();
	}
	
	@GetMapping("/getfromdb")
	public List<Item> retrieveAllItem()
	{
		return bsObj.getAllFromDB();
	}

}
