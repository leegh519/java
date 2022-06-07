package com.yedam.java.q3;

import java.util.Scanner;

import com.yedam.java.q2.ArcadeGame;
import com.yedam.java.q2.Keypad;
import com.yedam.java.q2.RPGgame;

public class RandomGameProgram {

	// 필드
	private Keypad game;

	// 생성자
	public RandomGameProgram() {

		setRandomGame();

		while (true) {
			printMenu();
			int menu = selectMenu();
			if (menu == 1) {
				game.leftUpButton();
			} else if (menu == 2) {
				game.leftDownButton();
			} else if (menu == 3) {
				game.rightUpButton();
			} else if (menu == 4) {
				game.rightDownButton();
			} else if (menu == 5) {
				game.changeMode();
			} else if (menu == 0) {
				changeGame();
			} else if (menu == 9) {
				exit();
				break;
			} else {
				printErrMsg();
			}
		}
	}

	// 메소드
	private void printMenu() {
		System.out
				.println("===========================================================================================");
		System.out
				.println("<<1.LeftUp | 2.LeftDown | 3.RightUp | 4.RightDown | 5.ModeChange | 0.GameChange | 9.EXIT>>");
		System.out
				.println("===========================================================================================");
	}

	private int selectMenu() {
		System.out.print("choice>>");
		return new Scanner(System.in).nextInt();
	}

	private void changeGame() {
		if (game instanceof RPGgame) {
			game = new ArcadeGame();
		} else if (game instanceof ArcadeGame) {
			game = new RPGgame();
		}
	}

	private void exit() {
		System.out.println("EXIT");
	}

	private void printErrMsg() {
		System.out.println("입력이 잘못되었습니다.");
	}

	private void setRandomGame() {
		int random = (int) (Math.random() * 2);
		if (random % 2 == 0) {
			game = new RPGgame();
		} else if (random % 2 == 1) {
			game = new ArcadeGame();
		}
	}

}
