package com.yedam.java.ch1102;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class StringTest1 {

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		System.out.println();

		// String -> byte -> String
		String str = "안녕하세요";
		byte[] byte1 = str.getBytes();
		System.out.println(byte1);

		String strs1 = new String(byte1);
		System.out.println(strs1);

		try {
			byte[] byte2 = str.getBytes("EUC-KR");
			System.out.println(byte2);
			String strs2 = new String(byte2, "EUC-KR");
			System.out.println(strs2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println();

		// charAt
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}

		for (int i = 0; i < ssn.length(); i++) {
			System.out.println(ssn.charAt(i));
		}
		System.out.println();

		// equals
		String val1 = "신민철";
		String val2 = "신민철";
		// val1, val2는 같은 인스턴스를 공유
		String val3 = new String("신민철");
		// val3은 새로운 인스턴스 생성

		if (val1.equals(val2)) {
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		if (val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		if (val1 == val2) {
			System.out.println("val1과 val2는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val2는 다른 인스턴스입니다.");
		}
		if (val1 == val3) {
			System.out.println("val1과 val3는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val3는 다른 인스턴스입니다.");
		}
		System.out.println();

		// indexOf
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련없는 책");
		}
		System.out.println();

		// substring
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);

		String ssn1 = "880815-1234567";
		System.out.println(ssn1.substring(0, 6));
		System.out.println(ssn.substring(7));

		// length
		String[] temp = { "1", "2" };
		int val = temp.length;

		System.out.println(ssn1.length());

		// replace
		String oldStr = "Java 프로그래밍";
		String newStr = oldStr.replace("Java", "자바");
		System.out.println(oldStr + " -> " + newStr);

		System.out.println("\n\n\n\n\n\n\n\n");

		// toLowerCase & toUpperCase
		String str3 = "Java Programming";
		String str4 = "JAVA PROGRAMMING";
		if (str3.equals(str4)) {
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}

		String val4 = str3.toLowerCase();
		String val5 = str4.toLowerCase();
		if (val4.equals(val5)) {
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}

		if (str3.equalsIgnoreCase(str4)) { // 대소문자 구분없이 비교가능
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}

		// trim
		String str5 = "      자바     프로그래밍    ";
		String s1 = str5.trim();
		String s2 = s1.substring(s1.indexOf("프로그래밍"));
		s1 = s1.substring(0, s1.indexOf(' '));
		System.out.println(s1 + " " + s2);

		StringTokenizer st = new StringTokenizer(str5);
		String newstr1 = st.nextToken();
		String newstr2 = st.nextToken();
		System.out.println(newstr1 + " " + newstr2);

		// valueOf
		String val6 = String.valueOf(10);
		String val7 = String.valueOf(10.5);
		String val8 = String.valueOf(true);

		String val9 = "" + 100;

	}

}
