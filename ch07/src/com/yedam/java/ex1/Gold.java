package com.yedam.java.ex1;

public class Gold extends Customer {

	// 아이디, 이름, 등급, 보너스포인트, 적립율, 할인율
	// 기본등급 골드
	// 적립율 2%, 할인율 10%

	private double discountRatio;

	// 생성자
	public Gold() {
		this.grade = "Gold";
		this.bonusRatio = 0.02;
		this.discountRatio = 0.1;		
	}
	
	public Gold(int id, String name) {
		super(id, name);
		this.grade = "Gold";
		this.bonusRatio = 0.02;
		this.discountRatio = 0.1;
	}


	@Override
	public int calPrice(int price) {
		return (int) (super.calPrice(price) * (1 - discountRatio));
	}

	@Override
	public String showInfo() {
		return super.showInfo();
	}

	public double getDiscountRatio() {
		return discountRatio;
	}
	
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
}
