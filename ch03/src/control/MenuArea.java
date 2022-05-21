package control;

import java.util.Scanner;

/*
 * 1. 사각형     2. 삼각형        0. 종료
 * 
 */
public class MenuArea {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu;

//		반복
//		menu입력
//		1이면 "사각형"출력
//		2이면 "삼각형"출력
//		0이면 break

		do {
			menu = Integer.parseInt(sc.nextLine());

			if (menu == 0) {
				break;
			} else if (menu == 1) {
				System.out.println("사각형");
			} else if (menu == 2) {
				System.out.println("삼각형");
			} else {
				System.out.println("다시 입력");
			}

		} while (true);

		System.out.println("프로그램 종료");
	}

}
