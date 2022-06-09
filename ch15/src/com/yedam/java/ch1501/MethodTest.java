package com.yedam.java.ch1501;

public class MethodTest {

	public static void main(String[] args) {
		BoxA<Integer> intBox = Util.boxing(100);

		Pair<Integer, String> p1 = new Pair<>(1, "사과");
		Pair<Integer, String> p2 = new Pair<>(2, "사과");

		boolean result1 = Util.compare(p1, p2);
		if (result1) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		Util.<String, Integer>printInfo("홍길동");
	}

}
