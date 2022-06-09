package com.yedam.java.ch1202;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
//		thread.start();
//
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		thread.setStop(true);

		System.out.println("===========================================");

		Thread sub = new Thread() {
			public void run() {
				while (true) {
					if (thread.interrupted()) {
						break;
					}
					System.out.println("실행중");
				}
				System.out.println("자원정리");
				System.out.println("종료");
			}
		};
		
		sub.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt();

	}

}
