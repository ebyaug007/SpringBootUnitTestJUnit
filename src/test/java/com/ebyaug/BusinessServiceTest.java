package com.ebyaug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ebyaug.models.Item;
import com.ebyaug.repository.ItemRepo;
import com.ebyaug.services.BusinessServiceClass;

@ExtendWith(MockitoExtension.class)
public class BusinessServiceTest {
	
	@InjectMocks
	BusinessServiceClass bsObj;
	
	@Mock
	ItemRepo repo;
	
	@Test
	public void testBusinessServiceValue()
	{
		when(repo.findAll()).thenReturn(Arrays.asList(
				new Item(1,"ABc",20,20),
				new Item(2,"DBc",10,20)));
		List<Item> allFromDB = bsObj.getAllFromDB();
		assertEquals(400, allFromDB.get(0).getValue());
		assertEquals(200, allFromDB.get(1).getValue());
	}

}
