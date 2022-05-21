package operator;

import java.io.IOException;
import java.util.Scanner;

public class 연산자 {

	public static void main(String[] args) {

		// 술연산();
		// 짝수검사();

		// incDecOp();
		// denyLogicOp();
		// toLower();
		// compareOp();

		// isDigit();
		// isChar();
		conditionOp();
	}

	public static void conditionOp() {

		int score = 79;
		String grade = score >= 90 ? "A등급" : score >= 80 ? "B등급" : "C등급";
		System.out.printf("%d점은 %s입니다.", score, grade);

	}

	public static void isChar() {

		try {
			int key = System.in.read();
			boolean result = ((key >= 65) && (key <= 90)) || (key >= 97) && (key <= 122);
			System.out.println(result ? "문자" : "문자아님");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void isDigit() {

		try {
			int key = System.in.read();
			boolean result = (key >= 48) && (key <= 57);
			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void compareOp() {
		int year = 2022;
		boolean result = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

		System.out.println(result);
	}

	// 대문자 -> 소문자
	public static void toLower() {

		char c = 'A';
		char p = (char) (c + 32);
		System.out.println(c);
		System.out.println(p);
	}

	// 논리 부정 연산
	public static void denyLogicOp() {

		boolean play = true;
		play = !play;
		System.out.println(play);
	}

	// 증감연산
	public static void incDecOp() {

		int x, y;
		x = 10;
		y = 10;

		x--;
		x = x - 1;
		y++;

		System.out.println(x);
		System.out.println(y);

		int a = 10;
		int b = 10;
		int c = ++a + b++;
		System.out.println(c);

	}

	// 부호연산자
	public static void 부호연산자() {

		int n1 = +100;
		int n2 = -100;

		byte x = 100;
		int result = -x; // 부호연산의 결과는 int
	}

	// 짝수인지 검사
	public static void 짝수검사() {
		int n1 = 6;
		boolean result = (n1 % 2 == 0);
		System.out.println(result);
	}

	// 산술연산자
	public static void 산술연산() {
		int n1 = 10;
		int n2 = 3;

		int n3 = n1 / n2; // 몫
		int n4 = n1 % n2; // 나머지
		System.out.println("몫 " + n3 + " 나머지 " + n4);
	}

}
