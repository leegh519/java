package com.yedam.java.ch0606;

public class CarTest {

	public static void main(String[] args) {

		Car myCar = new Car();

		myCar.setSpeed(-50);

		System.out.println("speed : " + myCar.getSpeed());
		
		myCar.setSpeed(50);
		System.out.println("speed : " + myCar.getSpeed());
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("speed : " + myCar.getSpeed());
		
	}

}
