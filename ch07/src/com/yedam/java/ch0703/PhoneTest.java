package com.yedam.java.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
//		Phone p = new Phone("Z filp", "블랙");
//		p.powerOn();

		DmbPhone dmb = new DmbPhone("Z filp", "블랙");
		dmb.powerOn();
		dmb.showDmb();
	}

}
