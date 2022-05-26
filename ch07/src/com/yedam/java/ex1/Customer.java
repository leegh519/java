package com.yedam.java.ex1;

public class Customer {

	// 아이디, 이름, 등급, 보너스 포인트, 포인트 적립율
	protected int id;
	protected String name;
	protected String grade;
	protected int bonusPoint;
	protected double bonusRatio;

	// 생성자
	public Customer() {
		this.grade = "Silver";
		this.bonusRatio = 0.01;
	}

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		this.grade = "Silver";
		this.bonusRatio = 0.01;
	}

	// 메소드
	public int calPrice(int price) {
		this.bonusPoint += price * this.bonusRatio;
		return price;
	}

	public String showInfo() {
		return name + "님의 등급은 " + grade + "이며, 보너스포인트는 " + bonusPoint + "입니다.";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

}
