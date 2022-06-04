package com.yedam.java.q2;

public class ArcadeGame implements Keypad {

	// 필드
	private int presentMode;

	// 생성자
	public ArcadeGame() {
		this.presentMode = NORMAL_MODE;
		System.out.println("ArcadeGame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if (presentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격.");
		} else if (presentMode == HARD_MODE) {
			System.out.println("캐릭터가 연속 공격.");
		}
	}

	@Override
	public void rightDownButton() {
		if (presentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 HIT 공격.");
		} else if (presentMode == HARD_MODE) {
			System.out.println("캐릭터가 Double HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		if (presentMode == NORMAL_MODE) {
			this.presentMode = HARD_MODE;
			System.out.println("현재 모드 : HARD_MODE");
		} else if (presentMode == HARD_MODE) {
			this.presentMode = NORMAL_MODE;
			System.out.println("현재 모드 : NORMAL_MODE");
		}
	}

}
