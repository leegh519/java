package com.yedam.java.q1;

public class ObesityInfo extends StandardWeightInfo {

	public ObesityInfo(String name, int height, int weight) {
		super(name, height, weight);
	}

	@Override
	public void getInformation() {
		System.out
				.println(getName() + "님의 신장 " + getHeight() + ", 몸무게 " + getWeight() + ", " + checkObesity() + "입니다.");
	}

	private String checkObesity() {
		double obesity = getObesity();
		if (obesity < -10) {
			return "저체중";
		} else if (obesity < 10) {
			return "정상";
		} else if (obesity < 20) {
			return "과체중";
		} else if (obesity >= 20) {
			return "비만";
		} else {
			return "측정불가";
		}
	}

	public double getObesity() {
		return (getWeight() - getStandardWeight()) / getStandardWeight() * 100;
	}

}
