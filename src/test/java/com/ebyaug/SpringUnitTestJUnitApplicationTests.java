package com.ebyaug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebyaug.business.BusinessLogic;
import com.ebyaug.service.BasicService;

@SpringBootTest
class SpringUnitTestJUnitApplicationTests {
	BusinessLogic bLObj = new BusinessLogic();
	BasicService serviceMock = mock(BasicService.class);

	@BeforeEach
	public void before() {
		bLObj.setBasicServiceObj(serviceMock);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void calculateTest() {

		when(serviceMock.retrieveValues()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, bLObj.CalculateSum());
	}

}
