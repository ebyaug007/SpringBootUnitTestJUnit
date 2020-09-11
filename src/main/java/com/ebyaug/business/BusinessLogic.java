package com.ebyaug.business;

import com.ebyaug.service.BasicService;

public class BusinessLogic {

	private BasicService basicServiceObj;

	public void setBasicServiceObj(BasicService basicServiceObj) {
		this.basicServiceObj = basicServiceObj;
	}

	public int CalculateSum() {
		int sum = 0;
		int[] data = basicServiceObj.retrieveValues();
		for (int val : data)
			sum += val;
		return sum;
	}
}
