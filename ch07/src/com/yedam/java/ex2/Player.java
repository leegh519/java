package com.yedam.java.ex2;

public class Player {

	// field
	private String id;
	private int bestScore=10;
	private int winCount;

	// constructor
	public Player() {
	}

	public Player(String id) {
		this.id = id;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount() {
		this.winCount++;;
	}

	public void showInfo() {
		System.out.println(id + "의 최고기록은 " + bestScore + "번이고,\n맞춘 횟수는 " + winCount + "입니다.");
	}

}