package com.ebyaug.services;

import org.springframework.stereotype.Service;

import com.ebyaug.models.Item;

@Service
public class BusinessServiceClass {

	public Item getAllItems() {
		// TODO Auto-generated method stub
		return new Item(1, "Foo", 10, 200);
	}

}
