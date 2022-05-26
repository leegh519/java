package com.yedam.java.ex2;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	// field
	private PlayerManage pm = PlayerManage.getInstance();
	private Scanner sc = new Scanner(System.in);
	private int count;
	private int[] history = new int[10];
	private String id;
	private Random r;

	// constructor
	public NumberGame() {
		signUp();
		while (true) {
			printMenu();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				printHowToPlay();
				int num = numberGenerate();
				for (count = 1; count <= 10; count++) {
					guessNumber(num);
				}
			} else if (menuNo == 2) {
				printMyRecord();
			} else if (menuNo == 3) {
				exit();
				break;
			}

		}

	}

	private void exit() {
		System.out.println("게임 종료");
	}

	private void printMyRecord() {
		pm.printInfo(id).showInfo();
	}

	private int menuSelect() {
		System.out.print("메뉴 > ");
		return Integer.parseInt(sc.nextLine());
	}

	// method

	// 메뉴출력
	private void printMenu() {
		System.out.println("====================================");
		System.out.println("1. 게임시작 | 2. 기록확인 | 3. 종료");
		System.out.println("====================================");
	}

	// 게임설명 출력
	private void printHowToPlay() {
		System.out.println("============================");
		System.out.println("UP&DOWN으로 10번의 기회동안");
		System.out.println("1~100사이 숫자 맞히기 게임");
		System.out.println("============================");
	}

	// 플레이어 등록
	private void signUp() {
		System.out.print("플레이어 이름등록 > ");
		this.id = sc.nextLine();
		Player player = new Player(id);
		pm.insert(player);
	}

	// 랜덤숫자 생성
	private int numberGenerate() {
		r = new Random();
		return r.nextInt(100)+1;
	}

	// 추측한 숫자 입력
	private void guessNumber(int number) {
		printHistory();
		System.out.print("숫자입력 > ");
		int guessNum = Integer.parseInt(sc.nextLine());
		history[count - 1] = guessNum;
		if (number < guessNum) {
			System.out.println("DOWN!");
			remainChance();
		} else if (number > guessNum) {
			System.out.println("UP!");
			remainChance();
		} else {
			System.out.println("WIN!");
			if (count < pm.printInfo(id).getBestScore()) {
				pm.printInfo(id).setBestScore(count);
			}
			pm.printInfo(id).setWinCount();
			count = 11;
		}
	}

	// 이전기록 출력
	private void printHistory() {
		for (int i = 1; i < count; i++) {
			System.out.print(history[i - 1] + " ");
		}
		System.out.println();
	}

	// 남은 횟수 출력
	private void remainChance() {
		System.out.println("남은 기회 : " + (10 - count) + "번");
	}

	// 게임결과 출력

	// 다시하기

}
