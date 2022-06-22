package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ProductStockManagement;
import com.yedam.app.deal.ReceivingDAO;
import com.yedam.app.deal.TakeOutDAO;
import com.yedam.app.products.ProductInfoManagement;
import com.yedam.app.products.ProductsDAO;

public class Management {

	protected Scanner sc = new Scanner(System.in);
	protected ProductsDAO pDAO = ProductsDAO.getInstance();
	protected ReceivingDAO rDAO = ReceivingDAO.getInstance();
	protected TakeOutDAO tDAO = TakeOutDAO.getInstance();

	// 생성자로 호출하면 자식클래스가 생성될때
	// 부모클래스 생성자가 다시 호출되므로
	// 정상적으로 동작이 안됨
	public void run() {

		while (true) {
			menuPrint();
			int menu = menuSelect();
			if (menu == 1) {
				// 제품정보관리
				new ProductInfoManagement();
			} else if (menu == 2) {
				// 제품재고관리
				new ProductStockManagement();
			} else if (menu == 9) {
				// 프로그램 종료
				exit();
				break;
			} else {
				printInputErr();
			}

		}
	}

	protected boolean selectRole() {
		int memberRole = LoginControl.getLoginInfo().getMemberRole();
		if (memberRole == 0) {
			return true;
		}

		return false;
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

		System.out.println("-------------------------------------");
		System.out.println(" 1.제품정보관리  2.제품재고관리  9.로그아웃");
		System.out.println("-------------------------------------");
	}
	
	protected void menuPrint(boolean role) {

	}

	protected void back() {
		System.out.println("이전화면으로 돌아갑니다.");
	}

}
