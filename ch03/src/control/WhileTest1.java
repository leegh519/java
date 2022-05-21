package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest1 {

	public static void main(String[] args) throws FileNotFoundException {

		// while1();
		// for1();
		// for2();
		// gugudan();
		//findMax();
		//findMin();
		findMaxMin();

	}
	
	
	public static void findMaxMin() throws FileNotFoundException {

		// 10번 반복
		// 숫자입력받아서 60보다 크면 출력
		Scanner sc = new Scanner(new File("score.txt"));
		
		int n;
		int min = sc.nextInt();
		int max = min;
		for (int i = 0; i < 10; i++) {
			n = sc.nextInt();
			if (n < min) {
				min = n;
			}
			if( n>max) {
				max=n;
			}
		}
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
	}
	
	

	public static void findMin() throws FileNotFoundException {

		// 10번 반복
		// 숫자입력받아서 60보다 크면 출력
		int n;
		int min = 100;
		Scanner sc = new Scanner(new File("score.txt"));
		for (int i = 0; i < 10; i++) {
			n = sc.nextInt();
			if (n < min) {
				min = n;
			}
		}
		System.out.println("최솟값 : "+min);
	}
	
	
	
	// 최댓값
	public static void findMax() throws FileNotFoundException {

		// 10번 반복
		// 숫자입력받아서 60보다 크면 출력
		int n;
		int max = 0;
		Scanner sc = new Scanner(new File("score.txt"));
		for (int i = 0; i < 10; i++) {
			n = sc.nextInt();
			if (n > max) {
				max = n;// System.out.println(n);
			}
		}
		System.out.println("최댓값 : "+max);
	}

	// 5단 출력
	public static void gugudan() {
		Scanner sc = new Scanner(System.in);

		int dan = sc.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %2d\n", dan, i, (i * dan));
		}

	}

	// 10~1까지 출력
	public static void for2() {
		for (int i = 10; i >= 1; i--) {
			System.out.println(i + "반복");
		}

	}

	// 1~10까지 반복 : for
	public static void for1() {
		for (int i = 1; i <= 10; i = i + 2) {
			System.out.println(i + "반복");
		}
	}

	// 1~10까지 반복 : do-while
	public static void while1() {
		int count = 1;

		do {
			System.out.println(count++);

		} while (count <= 10);

	}

}
