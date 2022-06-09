package com.yedam.java.ch1201;

public class User extends Thread {

	private int serial = 0;
	private Calculator cal;
	
	public User(Calculator cal, int n) {
		this.serial = n;
		this.setName("User" + serial);
		this.cal = cal;
	}

	public void setCalculator(Calculator cal) {
		serial+=100;
		this.setName("User" + serial);
		this.cal = cal;
	}
	
	public void run() {
		cal.setMemory(serial);
	}
}
