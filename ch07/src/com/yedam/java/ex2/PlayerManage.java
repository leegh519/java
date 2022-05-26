package com.yedam.java.ex2;

public class PlayerManage {

	// field
	private Player[] playerList;
	private int listIndex;
	private static PlayerManage pm = new PlayerManage();

	// constructor
	private PlayerManage() {
		playerList = new Player[10];
		listIndex = -1;
	}

	// method
	static PlayerManage getInstance() {
		return pm;
	}

	// 계정등록
	public void insert(Player player) {
		playerList[++listIndex] = player;

	}

	// 계정조회
	public Player printInfo(String id) {
		Player player = null;
		for (int i = 0; i <= listIndex; i++) {
			if(playerList[i].getId().equals(id)) {
				player = playerList[i];
				break;
			}
		}
		return player;
	}

}
