package com.yedam.java.ch1601;

public class RamdaTest {

	public static void main(String[] args) {

		FuncInterfaceA fia = () -> {
			System.out.println("FuncInterfaceA1");
		};
		fia.method();

		fia = () -> {
			System.out.println("FuncInterfaceA2");
		};
		fia.method();

		fia = () -> System.out.println("FuncInterfaceA3");
		fia.method();

		FuncInterfaceB fib = (num) -> {
			System.out.println(num * 5);
		};
		fib.method(5);

		fib = (num) -> {
			System.out.println(num * 5);
		};
		fib.method(4);

		fib = num -> System.out.println(num * 5);
		fib.method(3);

		FuncInterfaceC fic = (x, y) -> {
			return x + y;
		};
		System.out.println(fic.method(2, 3));

		fic = (x, y) -> {
			return x + y;
		};
		System.out.println(fic.method(5, 3));

		fic = (x, y) -> x + y;
		System.out.println(fic.method(5, 10));

		int val1 = 10;
		int val2 = 20;

		fia = () -> {
			System.out.println(val1 + val2);
		};
		// 익명 객체, 중첩 클래스 처럼 local 변수가 final 특성을 가짐
		// val1=1213;

		fia.method();

	}

}
