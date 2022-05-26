package com.yedam.java.ex1;

public class Vip extends Customer {

	// 할인율, 담당 전문 상담원
	// 등급 VIP
	// 적립율 5%
	// 할인율 15%
	private double discountRatio;
	private String counselor;

	
	
	public Vip() {
		this.grade = "VIP";
		this.bonusRatio = 0.05;
		this.discountRatio = 0.15;
		this.counselor = "???";
	}
	
	public Vip(int id, String name, String counselor) {
		super(id, name);
		this.grade = "VIP";
		this.bonusRatio = 0.05;
		this.discountRatio = 0.15;
		this.counselor = counselor;
	}
	
	

	@Override
	public int calPrice(int price) {
		return (int) (super.calPrice(price)*(1-discountRatio));
	}

	@Override
	public String showInfo() {
		return super.showInfo()+"\n담당 상담원은 "+counselor+"입니다.";
	}

	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}
	

}
