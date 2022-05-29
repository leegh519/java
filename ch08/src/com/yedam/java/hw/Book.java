package com.yedam.java.hw;

public class Book {

	// field
	private static long serialNum = 9791100000003l;
	private long isbn;
	private String name;
	private int price;

	// constructor
	public Book() {
	}

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
		serialNum += 100;
		this.isbn = serialNum;
	}

	// getter setter

	public static long getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(long serialNum) {
		Book.serialNum = serialNum;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void showInfo() {
		System.out.println(name + "의 가격은 " + price + "원이고, ISBN은 " + isbn + "입니다.");
	}

}