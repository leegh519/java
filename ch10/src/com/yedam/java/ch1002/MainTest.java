package com.yedam.java.ch1002;

public class MainTest {

	public static void main(String[] args) {

		// 실행코드
		try {

		}
		// 예외처리 코드
		catch (Exception e) {

		}
		// 반드시 실행되어야하는 코드
		finally {

		}

		String data1 = null;
		String data2 = null;

		try {
			int value1 = Integer.parseInt(data2);
			data1 = args[0];
			data2 = args[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			// 예외코드 내용출력 메소드
			// e.printStackTrace();
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 입력해주세요.");
			return;
		} catch (Exception e) {
			System.out.println("error");
			return;
		}
		// 예외 발생시에도 주로 리소스 정리를 위해 실행
		finally {
			System.out.println("finally");
		}
		System.out.println("메인 메소드 종료");
		
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String");
	}

}
