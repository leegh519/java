package chap01;

import java.util.Scanner;

public class ScannerUtil {

	public static void main(String[] args) {

		String name;
		String job;
		int age;

		// 문자열 입력
		Scanner scan = new Scanner(System.in);
		// 프롬프트출력
		System.out.print("이름입력 : ");
		// 입력받아서 변수에 저장
		name = scan.nextLine();
		// 프롬프트출력
		System.out.print("직업입력 : ");
		// 입력받아서 변수에 저장
		job = scan.nextLine();
		// 프롬프트출력
		System.out.print("나이입력 : ");
		// 입력받아서 변수에 저장
		age = Integer.parseInt(scan.nextLine());
		// 입력받은 문자열 출력
		System.out.printf("이름 %s, 직업 %s, 나이 %s", name, job, age);

	}

}
