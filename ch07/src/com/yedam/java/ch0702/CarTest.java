package com.yedam.java.ch0702;

public class CarTest {

	public static void main(String[] args) {

		Car car = new Car();

		for (int i = 0; i < 5; i++) {
			int problemLocation = car.run();

			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 Tire 교체");
				car.frontLeftTire = new KumhoTire("앞왼쪽", 15);
				break;
			case 2:
				System.out.println("앞오른쪽 Tire 교체");
				car.frontRightTire = new KumhoTire("앞오른쪽", 14);
				break;
			case 3:
				System.out.println("뒤왼쪽 Tire 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽", 13);
				break;
			case 4:
				System.out.println("뒤오른쪽 Tire 교체");
				car.backRightTire = new HankookTire("뒤오른쪽", 15);
				break;
			}
			System.out.println("=======================================");
		}

	}

}
