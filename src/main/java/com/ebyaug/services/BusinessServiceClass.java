package com.ebyaug.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebyaug.models.Item;
import com.ebyaug.repository.ItemRepo;

@Service
public class BusinessServiceClass {

	@Autowired
	ItemRepo itrepo;
	
	public Item getAllItems() {
		// TODO Auto-generated method stub
		return new Item(1, "Foo", 10, 200);
	}

	public List<Item> getAllFromDB() {
		
		return itrepo.findAll();
	}

}
