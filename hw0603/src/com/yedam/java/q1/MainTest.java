package com.yedam.java.q1;

public class MainTest {

	public static void main(String[] args) {
		// new WeightProgram();

		Human human = new StandardWeightInfo("홍길동", 168, 45);
		human.getInformation();

		human = new ObesityInfo("박둘이", 168, 90);
		human.getInformation();
	}

}
