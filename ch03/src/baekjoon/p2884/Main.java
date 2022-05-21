package baekjoon.p2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int h, m;
		
		h=sc.nextInt();
		m=sc.nextInt();
		
		if(m-45<0) {
			m=m-45+60;
			h--;
			if(h<0) {
				h+=24;
			}
		}
		else {
			m-=45;
		}
		System.out.println(h+" "+m);
		
		
	}

}
