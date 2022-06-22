package com.yedam.app.deal;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.Management;
import com.yedam.app.products.Product;

public class ProductStockManagement extends Management {

	// 제품 입고, 출고, 재고관리 프로그램
	public ProductStockManagement() {
		while (true) {
			boolean role = selectRole();
			menuPrint(role);
			int menu = menuSelect();

			if (menu == 1 && role) {
				// 입고
				productIn();
			} else if (menu == 2 && role) {
				// 출고
				productOut();
			} else if (menu == 3) {
				// 재고확인
				productStock();
			} else if (menu == 4 && role) {
				// 제품 거래내역
				productDeal();
			} else if (menu == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				printInputErr();
			}

		}

	}

	private void productDeal() {
		// 입고or출고 선택
		int choice = inputSelect();
		List<DealInfo> list = new ArrayList<DealInfo>();
		if (choice == 1) {
			list = rDAO.selectAll();
		} else if (choice == 2) {
			list = tDAO.selectAll();
		}

		for (DealInfo info : list) {
			System.out.println(info);
		}

	}

	private int inputSelect() {
		System.out.println("<1.입고  2.출고>");
		int select = Integer.parseInt(sc.nextLine());
		if (select == 1) {
			System.out.println("====입고내역====");
		} else if (select == 2) {
			System.out.println("====출고내역====");
		}
		return select;
	}

	private void productStock() {
		// 이름 입력
		String productName = inputName();
		Product product = pDAO.selectOneName(productName);

		if (product == null) {
			System.out.println("등록되지않은 제품입니다.");
			return;
		}

		// 해당제품 정보 출력
		System.out.println(product);
	}

	private String inputName() {
		System.out.print("제품이름> ");
		return sc.nextLine();
	}

	private void productOut() {
		// 제품이름과 출고 수량을 입력
		DealInfo info = inputAmount();

		// 제품 등록여부 확인
		Product product = pDAO.selectOneName(info.getProductName());
		if (product == null) {
			System.out.println("등록되지않은 제품입니다.");
			return;
		}

		// 제품 재고와 출고량 비교
		if (product.getProductStock() < info.getProductAmount()) {
			System.out.println("재고가 부족합니다. (현재재고: " + product.getProductStock() + ")");
			return;
		}

		// -출고처리
		info.setProductId(product.getProductId());
		tDAO.insert(info);

		// 제품정보- 재고량 수정
		updateProductStock(product.getProductId());
	}

	private DealInfo inputAmount() {
		DealInfo info = new DealInfo();
		System.out.print("제품이름> ");
		info.setProductName(sc.nextLine());
		System.out.print("수량> ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));

		return info;
	}

	private void productIn() {
		// 제품이름과 입고 수량을 입력
		DealInfo info = inputAmount();

		// 제품 등록여부 확인
		Product product = pDAO.selectOneName(info.getProductName());
		if (product == null) {
			System.out.println("등록되지않은 제품입니다.");
			return;
		}

		// -입고처리
		info.setProductId(product.getProductId());
		rDAO.insert(info);

		// 제품정보- 재고량 수정
		updateProductStock(product.getProductId());

	}

	// 해당 제품의 재고확인 및 수정
	private void updateProductStock(int productId) {
		Product product = new Product();
		// 입고량
		int inputAmount = rDAO.selectAmount(productId);
		// 출고량
		int outputAmount = tDAO.selectAmount(productId);
		// 재고수정
		int stock = inputAmount - outputAmount;
		product.setProductStock(stock);
		product.setProductId(productId);
		pDAO.updateStock(product);

	}

	protected void menuPrint() {
		System.out.println("--------------------------------------------------");
		System.out.println(" 1.제품입고  2.제품출고  3.재고확인  4.거래내역  9.뒤로가기");
		System.out.println("--------------------------------------------------");
	}

	@Override
	protected void menuPrint(boolean role) {

		String menu = "";
		if (role) {
			menu += " 1.제품입고  2.제품출고 ";
		}
		menu += " 3.재고확인 ";
		if (role) {
			menu += " 4.거래내역 ";
		}
		menu += " 9.뒤로가기";
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(menu);
		System.out.println("--------------------------------------------------------------------------");
	}

}
