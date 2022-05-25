package com.yedam.java.test;

public class StudentManage {

	private Student[] student;
	private int listSize;
	private int index = -100;

	// 학생 수 입력
	public void setListSize(int size) {
		this.listSize = size;
		student = new Student[size];
		index = -1;
	}

	// 학생 수 출력
	public int getListSize() {
		return listSize;
	}

	// 학생정보 입력가능 여부확인
	public boolean inputPossible() {
		if (index == -1) {
			return true;
		} else if (index == -100) {
			System.out.println("학생정보를 먼저 입력하세요.");
			return false;
		} else {
			System.out.println("더이상 입력할 수 없습니다.");
			return false;
		}
	}

	// 학생정보 입력
	public void setStudentInfo(int id, String name, int score) {
		student[++index] = new Student(id, name, score);
	}

	// 학생정보 전체조회
	public void printAll() {
		if (index < 0) {
			System.out.println("학생정보를 먼저 입력하세요.");
		} else {
			for (int i = 0; i < listSize; i++) {
				student[i].showInfo();
			}
		}
	}

	// 최고점수 학생
	private Student getHigh() {
		Student high = student[0];
		for (int i = 1; i < listSize; i++) {
			if (high.getScore() < student[i].getScore()) {
				high = student[i];
			}
		}
		return high;
	}

	// 최저점수 학생
	private Student getLow() {
		Student low = student[0];
		for (int i = 1; i < listSize; i++) {
			if (low.getScore() > student[i].getScore()) {
				low = student[i];
			}
		}
		return low;
	}

	// 최고, 최저 출력
	public void printInfo() {
		if (index < 0) {
			System.out.println("학생정보를 먼저 입력하세요.");
		} else {
			System.out.println("최고 점수 : " + getHigh().getScore() + "점, 학번 : " + getHigh().getStudentId());
			System.out.println("최저 점수 : " + getLow().getScore() + "점, 학번 : " + getLow().getStudentId());
			System.out.printf("최고점, 최저점을 제외한 평균 점수는 %.2f점 입니다.\n", getAvg());
		}
	}

	// 평균점수(최고, 최저 제외)
	private double getAvg() {
		if (listSize < 3) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i < listSize; i++) {
			sum += student[i].getScore();
		}
		sum = sum - getHigh().getScore() - getLow().getScore();
		return sum / (listSize - 2);
	}

}