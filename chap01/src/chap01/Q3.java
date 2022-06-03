package chap01;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name, idNum, telNum;
		
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름 : ");
		name = sc.nextLine();
		System.out.print("2. 주민번호 앞 6자리 : ");
		idNum = sc.nextLine();
		System.out.print("3. 전화번호 : ");
		telNum = sc.nextLine();
		
		System.out.println();
		System.out.println("[입력한 내용]");
		System.out.println(name+"\n"+idNum+"\n"+telNum);
		
		
		sc.close();
		
		
	}

}
