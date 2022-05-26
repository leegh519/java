package com.yedam.java.ex1;

import java.util.Scanner;

public class CustomerSystem {
	// 필드
	private Repo repo = new Repo(); // repo가 싱글톤이면 하나의 db를 공유함
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 선택
			int menuNo = menuSelect();
			// 메뉴 1. 회원가입
			if (menuNo == 1) {
				signUp();
			}
			// 메뉴 2. 정보조회
			else if (menuNo == 2) {
				myPage();
			}
			// 메뉴 3. 결제시 금액
			else if (menuNo == 3) {
				payInfo();
			}
			// 메뉴 4. 종료
			else if (menuNo == 4) {
				exit();
				break;
			}
		}
	}
	
	

	/*
	 * 메소드 하나의 문장으로 정리할 수 있는 기능으로 메소드를 분리함
	 * 
	 */

	// 프로그램 종료
	private void exit() {
		System.out.println("프로그램 종료");
	}

	// 결제금액 정보출력
	private void payInfo() {
		int id = inputOne();
		Customer info = repo.selectOne(id);
		System.out.print("구매금액 > ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calPrice(price);
		System.out.println("결제 금액 : " + pay);
	}

	// 고객 ID 입력
	private int inputOne() {
		System.out.print("고객 ID > ");
		return Integer.parseInt(sc.nextLine());
	}

	// 고객 정보 조회
	private void myPage() {
		int id = inputOne();
		Customer info = repo.selectOne(id);
		System.out.println(info.showInfo());
	}

	// 메뉴 출력
	private void menuPrint() {
		System.out.println("======================================");
		System.out.println("1.회원가입 | 2.회원정보 | 3.결제금액 | 4.종료");
		System.out.println("======================================");
	}

	// 메뉴 입력
	private int menuSelect() {
		System.out.print("메뉴 > ");
		return Integer.parseInt(sc.nextLine());
	}

	// 회원가입
	private void signUp() {
		Customer info = inputAll();
		repo.insert(info);
	}

	
	// id, 이름 같이 입력
	private Customer inputAll() {
		// 등급 선택

		System.out.print("ID> ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름> ");
		String name = sc.nextLine();

		// 회원 정보 입력
		Customer customer = null;
		switch (selectGrade()) {
		case 1:
			customer = new Customer(id, name);
			break;
		case 2:
			customer = new Gold(id, name);
			break;
		case 3:
			customer = new Vip(id, name, "이한나");
			break;
		}

		return customer;
	}

	private int selectGrade() {
		System.out.println("1.Silver | 2.Gold | 3.VIP");
		System.out.println("--------------------------");
		System.out.print("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

}
