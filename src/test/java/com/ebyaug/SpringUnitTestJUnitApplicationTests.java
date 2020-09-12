package com.ebyaug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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
	void multipleReturnTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	void genericReturnTest() {
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenReturn("HelloWorld");
		assertEquals("HelloWorld", mockList.get(0));
		assertEquals("HelloWorld", mockList.get(1));
	}

	@Test
	void verifyMethodCallTest() {
		List<String> mockList = mock(List.class);
		String val1 = mockList.get(0);
		String val2 = mockList.get(1);

		verify(mockList).get(0);
		verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);

	}

	@Test
	void calculateTest() {

		when(serviceMock.retrieveValues()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, bLObj.CalculateSum());
	}
	
	@Test 
	void argumentCaptorTest()
	{
		List<String> mocklist = mock(List.class);
		mocklist.add("abcd");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mocklist).add(captor.capture());
		assertEquals("abcd", captor.getValue());
		
	}

}
