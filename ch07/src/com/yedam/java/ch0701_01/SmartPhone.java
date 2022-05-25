package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {

	public SmartPhone(String model, String color) {
		super(model, color);
	}

	
	void p() {
		//super.print();
	}
	
	//@Override
	void print() {
		System.out.println("휴대폰이 종료됩니다.");
		super.powerOff();
	}
	
	
	
	@Override
	protected void bell() {
		super.bell();
		System.out.println("~~~~~~~~~~~~~~");
	}

//	@Override
//	protected void call() {
//		super.call();
//		System.out.println("~~~~~~~~~~~");
//	}
	
	
	
	

}
