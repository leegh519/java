package com.yedam.java.test;

import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		StudentManage sm = new StudentManage();

		while (run) {
			System.out.println("=== 1. 학생수 입력  2. 학생정보 등록  3. 학생정보 전체조회  4. 학생정보 분석  5. 종료 ===");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			int id;
			String name;
			int score;
			switch (menu) {
			case 1:
				System.out.print("학생수 > ");
				int size = Integer.parseInt(sc.nextLine());
				sm.setListSize(size);
				break;
			case 2:
				if (sm.inputPossible()) {
					for (int i = 0; i < sm.getListSize(); i++) {
						System.out.print("학번 > ");
						id = Integer.parseInt(sc.nextLine());
						System.out.print("이름 > ");
						name = sc.nextLine();
						System.out.print("점수 > ");
						score = Integer.parseInt(sc.nextLine());
						sm.setStudentInfo(id, name, score);
					}
				}
				break;
			case 3:
				sm.printAll();
				break;
			case 4:
				sm.printInfo();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("1~5사이 입력하세요.");
			}

		}
		System.out.println("프로그램 종료");
		sc.close();
	}

}
