package com.yedam.java.ch0701;

public class Phone {

	String model;
	String color;

	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	protected final void powerOn() {
		System.out.println("전원을 켭니다.");
	}

	protected final void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	protected void bell() {
		System.out.println("벨+진동이 울립니다.");
	}

	void call() {
		System.out.println("통화를 합니다.");
	}
	
	private void print() {
		System.out.println("test");
	}

}
