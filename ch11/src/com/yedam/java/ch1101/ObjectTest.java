package com.yedam.java.ch1101;

public class ObjectTest {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 논리적으로 같음");
		}

		if (obj1 == obj2) {
			System.out.println("obj1과 obj2는 논리적으로 같음");
		}
		
		String mem1 = new String("1");
		String mem2 = new String("1");
		
		if (mem1.equals(mem2)) {
			System.out.println("obj111과 obj2는 논리적으로 같음");
		}

		if (mem1 == mem2) {
			System.out.println("obj1과 obj2222는 논리적으로 같음");
		}
	}

}
