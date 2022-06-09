package com.yedam.java.ch1202;

public class PrintThread extends Thread {

	@Override
	public void run() {
		while (true) {
			try {

				System.out.println("실행중");
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println("interrupt method 실행");

			}
//			System.out.println("자원정리");
//			System.out.println("종료");
		}

	}

}
