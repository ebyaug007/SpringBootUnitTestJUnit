package com.ebyaug;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ebyaug.business.BusinessLogic;
import com.ebyaug.service.BasicService;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
class OptimizingTestCode {
	
	@InjectMocks
	BusinessLogic blObj;
	
	@Mock
	BasicService bsObj;
	
	@Test
	void calculateSumTest() {
		
		when(bsObj.retrieveValues()).thenReturn(new int[] {1,2,3});
		assertEquals(6, blObj.CalculateSum());
		
	}

}
