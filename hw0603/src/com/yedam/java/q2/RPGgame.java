package com.yedam.java.q2;

public class RPGgame implements Keypad {

	// 필드
	private int presentMode;

	// 생성자
	public RPGgame() {
		this.presentMode = NORMAL_MODE;
		System.out.println("RPGgame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if (presentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 한칸단위로 점프한다.");
		} else if (presentMode == HARD_MODE) {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}
	}

	@Override
	public void rightDownButton() {
		if (presentMode == NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격.");
		} else if (presentMode == HARD_MODE) {
			System.out.println("캐릭터가 HIT 공격.");
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
