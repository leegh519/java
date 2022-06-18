package com.yedam.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.history.History;
import com.yedam.app.history.HistoryDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ProductDAO pDao = ProductDAO.getInstance();
	private HistoryDAO hDao = HistoryDAO.getInstance();

	public StockManagement() {

		while (true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			int menu = selectMenu();
			// 각 기능 실행
			// 1.제품등록 2.입고 3.출고 4.제품재고확인 5.전체재고확인 9.종료
			if (menu == 1) {
				insertProduct();
			} else if (menu == 2) {
				inProduct();
			} else if (menu == 3) {
				outProduct();
			} else if (menu == 4) {
				selectProductStock();
			} else if (menu == 5) {
				selectAllProductStock();
			} else if (menu == 0) {
				deleteProduct();
			} else if (menu == 9) {
				exit();
				break;
			} else {
				printMenuErrMsg();
			}

		}
	}

	private void deleteProduct() {
		System.out.println("제품이름>>");
		String productName = inputString();
		int id = pDao.selectOneName(productName).getProductId();
		hDao.deleteInput(id);
		hDao.deleteOutput(id);
		pDao.delete(id);
	}

	private void selectProductStock() {
		System.out.println("제품이름>>");
		String productName = inputString();
		Product product = pDao.selectOneName(productName);
		if (product != null) {
			int historyId = product.getProductId();
			int stock = hDao.selectOne(historyId);
			System.out.println(productName + "의 재고는 " + stock + "입니다.");
		} else {
			System.out.println("등록되지 않은 제품입니다.");
		}

	}

	private String inputString() {
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	private void outProduct() {
		// 입력
		Info info = outputAmount();

		// 등록여부 확인
		Product product = pDao.selectOneName(info.getProductName());

		// -1 등록된 제품
		if (product != null) {
			// 재고 있음
			if (hDao.selectOne(product.getProductId()) >= info.getProductAmount()) {
				History history = new History();
				history.setProductId(product.getProductId());
				history.setProductCategory(2);
				history.setProductAmount(info.getProductAmount());
				hDao.insert(history);
			}
			// 재고 부족
			else {
				System.out.println("재고가 부족합니다.");
			}
		}
		// -2 등록안된 제품
		else if (product == null) {
			System.out.println("등록되지 않은 제품입니다.");
		}

	}

	private Info outputAmount() {
		Info info = new Info();
		System.out.println("제품이름>> ");
		info.setProductName(inputString());
		System.out.println("출고량>> ");
		info.setProductAmount(inputNumber());
		return info;
	}

	private void inProduct() {
		// 입고할 제품과 수량 입력
		Info info = inputAmount();

		// 등록된 제품인지 확인
		Product product = pDao.selectOneName(info.getProductName());
		// -1 등록된 제품이면 입고
		if (product != null) {
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);
			history.setProductAmount(info.getProductAmount());
			hDao.insert(history);
		}
		// -2 등록안된 제품이면 별도 안내
		else if (product == null) {
			System.out.println("등록되지 않은 제품입니다.");
		}

	}

	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품이름>> ");
		info.setProductName(inputString());
		System.out.println("입고량>> ");
		info.setProductAmount(inputNumber());
		return info;
	}

	private void insertProduct() {
		Product product = inputAll();
		History history = new History();
		history.setProductId(product.getProductId());
		history.setProductAmount(0);
		history.setProductCategory(1);
		pDao.insert(product);
		hDao.insert(history);
	}

	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름>> ");
		product.setProductName(inputString());
		System.out.println("제품가격>> ");
		product.setProductPrice(inputNumber());
		return product;
	}

	private void selectAllProductStock() {
		Map<Integer, Integer> list = hDao.selectAllAmount();
		Set<Integer> set = list.keySet();
		for (int key : set) {
			String Name = pDao.selectOneId(key).getProductName();
			System.out.println("제품번호 : " + key + ", 제품이름 : " + Name + ", 재고량 : " + list.get(key));
		}
	}

	private void exit() {
		System.out.println("프로그램 종료");
	}

	private void printMenuErrMsg() {
		System.out.println("지원하지 않는 기능입니다.");
	}

	private int selectMenu() {
		return inputNumber();
	}

	private int inputNumber() {
		int n = -1;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력하세요.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void menuPrint() {
		System.out.println("========================================================");
		System.out.println("1.제품등록  2.입고  3.출고  4.제품재고확인  5.전체재고확인  9.종료");
		System.out.println("========================================================");
	}

}
