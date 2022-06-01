package com.yedam.java.ch0902;

public class Product {

	// 필드
	RemoteControl field = new RemoteControl() {
		// 필드
		String message = "스마트TV";

		// 메소드
		void print() {
			System.out.println("제품종류 : " + message);
		}

		@Override
		public void turnOn() {
			print();
			System.out.println("전원켜기");
		}

		@Override
		public void turnOff() {
			print();
			System.out.println("전원끄기");
		}
	};

	// 생성자

	// 메소드
	RemoteControl method1() {

		// final 특성을 가짐
		int volume = 0;

		RemoteControl var = new RemoteControl() {
			// 필드
			String message = "Audio";

			// 메소드
			void print() {
				System.out.println("제품종류 : " + message);
			}

			@Override
			public void turnOn() {
				print();
				System.out.println("전원켜기");
				System.out.println("볼륨" + volume);
			}

			@Override
			public void turnOff() {
				print();
				System.out.println("전원끄기");
			}
		};

		var.turnOn();
		var.turnOff();

		return var;
	}

	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
