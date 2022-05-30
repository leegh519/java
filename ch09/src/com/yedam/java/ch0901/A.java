package com.yedam.java.ch0901;

public class A {

	A() {
		System.out.println("A 인스턴스 생성");
	}

	// 인스턴스 멤버 클래스
	class B {

		// 필드
		int field1;
		// static int field2;

		// 생성자
		B() {
			System.out.println("B 인스턴스 생성");
		}

		// 메서드
		void method1() {
		}
	}

	// 정적 멤버 클래스
	static class C {
		int field1;
		static int field2;

		C() {
			System.out.println("C 인스턴스 생성");
		}

		void method1() {
		}

		static void method2() {
		}
	}

	void method() {

		// 로컬클래스
		class D {

			// 필드
			int field1;

			// 생성자
			D() {
				System.out.println("D 인스턴스 생성");
			}

			// 메소드
			void method1() {
			}
		}

		D d = new D();
		d.field1 = 1;
		d.method1();

	}
}
