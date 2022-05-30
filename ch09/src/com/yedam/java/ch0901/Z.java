package com.yedam.java.ch0901;

public class Z {

	
	// 인스턴스 멤버 >> Z 클래스의 인스턴스가 존재
	B field1 = new B();
	C field2 = new C();

	// 정적멤버 >> B클래스는 Z클래스 인스턴스가 존재해야 사용가능
	// static B field3 = new B();
	static C field4 = new C();

	void method1() {
		B var1 = new B();
		C var2 = new C();
	}

	static void method2() {
		// B var1 = new B();
		C var2 = new C();
	}

	// 인스턴스 멤버 클래스
	class B {

	}

	// 정적 멤버 클래스
	static class C {

	}

}
