package control;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		
		while(run){
			System.out.println("---------------------------------------------");
			System.out.println("  1. 예금  |  2. 출금  |  3. 잔고  |  4. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");
			int s = Integer.parseInt(sc.nextLine());
			int n;
			
			if(s==1) {
				System.out.print("예금액> ");
				n=Integer.parseInt(sc.nextLine());
				balance+=n;
			}else if(s==2) {
				System.out.print("출금액> ");
				n=Integer.parseInt(sc.nextLine());
				balance-=n;
			}else if(s==3) {
				System.out.print("잔고> ");
				System.out.println(balance);
			}else if(s==4) {
				break;
			}
			System.out.println();
		}
		
		
		System.out.println("프로그램 종료");
		
		
	}

}
