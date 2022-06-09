package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		
		Thread main = Thread.currentThread();
		System.out.println("메인스레드 " + main.getName());
		
		//Thread thread = new Thread(new ThreadA());
		ThreadB thread = new ThreadB();
		thread.setName("threadA");
		System.out.println("작업스레드 "+thread.getName());
		thread.start();

		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 출력");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
