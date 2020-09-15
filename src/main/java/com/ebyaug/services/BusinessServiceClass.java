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
		
		List<Item> items = itrepo.findAll();
		for(Item i:items)
			i.setValue(i.getPrice() * i.getQuantity());
		return items;
	}

}
