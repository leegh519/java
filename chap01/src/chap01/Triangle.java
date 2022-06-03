package chap01;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {

		trianglearea();

	}

	public static void trianglearea() {
		double w, h, area;
		Scanner sc = new Scanner(System.in);

		System.out.print("밑변 : ");
		w = Double.parseDouble(sc.nextLine());

		System.out.print("높이 : ");
		h = Double.parseDouble(sc.nextLine());

		area = w * h / 2;
		System.out.printf("면적 : %.2f", area);

		sc.close();
	}

}
