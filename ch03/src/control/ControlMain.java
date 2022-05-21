package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score;
		String grade;

		// 조건이 맞을 동안 반복실행
		do {
			// 점수를 키보드로부터 입력
			score = Integer.parseInt(sc.nextLine());
			if (score == 0) {
				break;
			}

			if (score >= 90) {
				grade = "A등급";
			} else if (score >= 80) {
				grade = "B등급";
			} else if (score >= 70) {
				grade = "C등급";
			} else {
				grade = "D등급";
			}

			System.out.printf("%d 성적은 %s입니다.\n", score, grade);
		} while (true);
		System.out.println("프로그램 종료");
	}

}
