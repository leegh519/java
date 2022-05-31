package com.yedam.java.ch0902;

public class Anonymous {

	// 필드
	Person field = new Person() {
		// 필드
		String job = "회사원";

		// 메소드
		void work() {
			System.out.println("출근");
		}

		@Override
		void wake() {
			System.out.println("6시 기상");
			work();
		}
	};

	// 생성자

	// 메소드
	void method1() {
		// 로컬변수
		Person var = new Person() {
			String job = "백수";

			void walk() {
				System.out.println("산책");
			}

			@Override
			void wake() {
				System.out.println("7시 기상");
				walk();
			}
		};

		var.wake();
	}

	void method2(Person person) {
		person.wake();
	}

}
