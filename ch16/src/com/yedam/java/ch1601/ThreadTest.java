package com.yedam.java.ch1601;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable r = ()->{
			System.out.println("람다식으로 구현");
			for(int i=0;i<10;i++) {
				System.out.println(i);
			}
		};
		
		Thread th = new Thread(r);
		th.start();
		
		th = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.print(i+" ");
			}
		});
		th.start();
		
		th = new Thread(r);
		th.start();
	}

}
