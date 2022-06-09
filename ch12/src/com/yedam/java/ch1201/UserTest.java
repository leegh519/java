package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();

		User user1 = new User(c, 100);
		user1.start();		
		
		User user2 = new User(c, 200);
		user2.start();
		
		user1 = new User(c,500);
		user1.start();

	}

}
