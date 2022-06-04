package com.yedam.java.q1;

public class Human {

	// 필드
	private String name;
	private int height;
	private int weight;

	// 생성자
	public Human() {
	}

	public Human(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	// getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	// method
	public void getInformation() {
		System.out.println(name + "님의 신장 " + height + ", 몸무게 " + weight + "입니다.");
	}
}
