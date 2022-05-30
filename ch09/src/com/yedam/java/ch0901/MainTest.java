package com.yedam.java.ch0901;

public class MainTest {

	public static void main(String[] args) {

		A a = new A();
		System.out.println();

		// 인스턴스 멤버 클래스
		A.B b = a.new B();
		b.field1 = 1;
		b.method1();
		System.out.println();

		// 정적클래스 멤버
		A.C.field2 = 2;
		A.C.method2();

		// 정적멤버 클래스 C
		A.C c = new A.C();
		c.field1 = 1;
		c.method1();
		System.out.println();

		// 로컬 클래스
		a.method();

	}

}
