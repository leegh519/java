package com.yedam.java.ch1201;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		Thread info = Thread.currentThread();
		System.out.println("현재스레드 " + info.getName() + "  memory " + this.memory);		
	}
}
