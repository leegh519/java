package com.yedam.app;

import java.util.List;

import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class Main {

	public static void main(String[] args) {
		List<Product> list = ProductDAO.getInstance().selectAll();
		for (Product p : list) {
			System.out.println(p);
		}

		System.out.println(ProductDAO.getInstance().selectOneName("사과"));
		System.out.println(ProductDAO.getInstance().selectOneId(3));
	}

}
