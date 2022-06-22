package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MembersDAO;

public class LoginControl {
	private static Member loginInfo = null;
	Scanner sc = new Scanner(System.in);

	public static Member getLoginInfo() {
		return loginInfo;
	}

	public LoginControl() {
		while (true) {
			menuPrint();

			int menu = menuSelect();

			if (menu == 1) {
				login();
			} else if (menu == 2) {
				exit();
				break;
			} else {
				printInputErr();
			}
		}
	}

	private void login() {
		// ID, 비밀번호 입력
		Member member = inputMember();

		// 회원정보 받아오기
		loginInfo = MembersDAO.getInstance().selectOne(member);

		// 회원정보가 없으면 종료
		if (loginInfo == null) {
			return;
		}

		// 프로그램 실행
		new Management().run();

	}

	private Member inputMember() {
		Member member = new Member();

		System.out.print("ID입력> ");
		member.setMemberId(sc.nextLine());
		System.out.print("비밀번호입력> ");
		member.setMemberPassword(sc.nextLine());

		return member;
	}

	protected void printInputErr() {
		System.out.println("메뉴에 없는 기능입니다.");
	}

	protected void exit() {
		System.out.println("프로그램 종료");
	}

	protected int menuSelect() {
		System.out.print("선택> ");
		return inputNum();
	}

	protected int inputNum() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자입력하세요");
		}
		return menu;
	}

	protected void menuPrint() {
		System.out.println("----------------");
		System.out.println(" 1.로그인  2.종료");
		System.out.println("----------------");
	}

}
