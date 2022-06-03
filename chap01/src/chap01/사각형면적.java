package chap01;

import java.util.Scanner;

public class 사각형면적 {

	public static void main(String[] args) {


		int w, h, area;
		Scanner sc = new Scanner(System.in);

		System.out.print("가로길이 입력 : ");
		w = Integer.parseInt(sc.nextLine());
		
		System.out.print("세로길이 입력 : ");
		h = Integer.parseInt(sc.nextLine());
		
		area = w * h;
		System.out.println("면적 : " + area);

	
	}

}
