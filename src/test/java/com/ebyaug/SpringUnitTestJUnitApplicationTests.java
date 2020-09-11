package com.ebyaug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebyaug.business.BusinessLogic;
import com.ebyaug.service.BasicService;

@SpringBootTest
class SpringUnitTestJUnitApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void calculateTest()
	{
		BusinessLogic bLObj= new BusinessLogic();
		BasicService serviceMock = mock(BasicService.class);
		when(serviceMock.retrieveValues()).thenReturn(new int[] {1,2,3});
		bLObj.setBasicServiceObj(serviceMock);
		assertEquals(6,bLObj.CalculateSum());
	}

}
