package control;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num[] = new int[10];
		int n;
		String result = "";

		do {
			int rand = (int) (Math.random() * 100) + 1;
			System.out.println("1~100 숫자맞히기");
			System.out.println("게임시작");
			for (int i = 0; i < 10; i++) {
				if(i!=0) {
					System.out.println("이전 기록");
				}
				for (int j = 0; j < i; j++) {
					System.out.print(num[j]+" ");
				}
				System.out.print("\n숫자입력>> ");
				num[i] = Integer.parseInt(sc.nextLine());
				if (num[i] > rand) {
					result = "크다";
				} else if (num[i] < rand) {
					result = "작다";
				} else if (num[i] == rand) {
					result = "정답";
					System.out.println("정답");
					break;
				}
//				if (9 - count == 0) {
//					System.out.println("실패");
//					break;
//				}
				System.out.println(result);
				System.out.println(9 - i + "번 남았습니다.");
				System.out.println();
			}
			System.out.println();
			System.out.println("1. 다시하기  2. 종료");
			System.out.print("선택>> ");
			n = Integer.parseInt(sc.nextLine());
		} while (n != 2);

		// 반복
		// 키보드 정수 값을 읽어서 num 변수에 저장
		// rand > num "크다" 출력
		// rand < num "작다" 출력
		// rand == num break

	}

}
