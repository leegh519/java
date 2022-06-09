package com.yedam.java.ch1202;

import java.util.Scanner;

public class PrintThreadTest {

	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();
		
		
		int result = new Scanner(System.in).nextInt();
		if(result != 0) {
			thread.interrupt();
		}

	}

}
