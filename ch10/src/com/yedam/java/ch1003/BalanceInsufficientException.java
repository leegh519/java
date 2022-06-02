package com.yedam.java.ch1003;

// 잔액부족 예외 클래스

public class BalanceInsufficientException extends Exception{

	public BalanceInsufficientException() {	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
