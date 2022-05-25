package com.yedam.java.test;

public class Student {
	private int studentId;
	private String name;
	private int score;

	public Student(int id, String name, int score) {
		this.studentId = id;
		this.name = name;
		this.score = score;
	}

	public int getStudentId() {
		return this.studentId;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void showInfo() {
		System.out.println(studentId + " 학번의 점수는 " + score + "점 입니다.");
	}
}
