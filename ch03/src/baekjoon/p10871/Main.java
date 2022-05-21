package baekjoon.p10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; // n개 입력
		int x; // 비교대상
		int num; // 입력 숫자
		int i = 1;

		n = sc.nextInt();
		x = sc.nextInt();

		do {
			num = sc.nextInt();
			if (num < x) { // 입력 숫자가 x보다 작으면 출력
				System.out.print(num + " ");
			}
			i++;
		} while (i <= n);

	}

}
