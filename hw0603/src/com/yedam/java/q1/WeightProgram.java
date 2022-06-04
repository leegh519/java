package com.yedam.java.q1;

import java.util.Scanner;

public class WeightProgram {

	// 필드
	private Human human;
	private String name;
	private int height;
	private int weight;
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public WeightProgram() {
		while (true) {
			printMenu();
			int menu = selectMenu();
			if (menu == 1) {
				inputAll();
			} else if (menu == 2) {
				showStdWeight();
			} else if (menu == 3) {
				showObesity();
			} else if (menu == 4) {
				exit();
				break;
			} else {
				System.out.println("1~4 입력");
			}

		}
	}

	// 메소드
	private void printMenu() {
		System.out.println("=========================================");
		System.out.println("1.입력 | 2.표준체중확인 | 3.비만도확인 | 4. 종료");
		System.out.println("=========================================");
	}

	private int selectMenu() {
		System.out.print("선택> ");
		return Integer.parseInt(sc.nextLine());
	}

	private void inputAll() {
		System.out.print("이름> ");
		name = sc.nextLine();
		System.out.print("키> ");
		height = Integer.parseInt(sc.nextLine());
		System.out.print("몸무게> ");
		weight = Integer.parseInt(sc.nextLine());
	}

	private void showStdWeight() {
		human = new StandardWeightInfo(name, height, weight);
		human.getInformation();
	}

	private void showObesity() {
		human = new ObesityInfo(name, height, weight);
		human.getInformation();
	}

	private void exit() {
		System.out.println("프로그램 종료");
	}

}
