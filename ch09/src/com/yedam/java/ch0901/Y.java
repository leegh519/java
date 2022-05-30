package com.yedam.java.ch0901;

public class Y {

	// 필드
	int field1;
	static int field2;

	// 메소드
	void method1() {
	}

	static void method2() {
	}

	// 인스턴스 멤버 클래스 >> Y클래스의 인스턴스가 반드시 존재함
	class B {
		void method() {
			field1 = 1;
			field2 = 2;

			method1();
			method2();
		}
	}

	// 정적 멤버 클래스 >> Y클래스의 인스턴스 존재여부를 알 수 없음 >> Y클래스의 정적 멤버외 접근불가
	static class C {
		void method() {
			// field1 = 1;
			field2 = 2;

			// method1();
			method2();
		}
	}

	// 로컬클래스
	void method(final int arg) {
		final int var = 1;
		// arg = 100;
		// var = 90;

		// method가 종료되어도 class D의 method가 살아있는 경우가 있음.
		// 그래서 arg, var값을 final로 고정해야 호출할때마다 같은 값을 반환함.
		class D {
			void method() {
				int result = arg + var;
			}
		}

	}

}
