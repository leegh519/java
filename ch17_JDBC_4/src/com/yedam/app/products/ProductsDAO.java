package com.yedam.app.products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductsDAO extends DAO {

	private static ProductsDAO pDAO;

	private ProductsDAO() {
	}

	public static ProductsDAO getInstance() {
		if (pDAO == null) {
			pDAO = new ProductsDAO();
		}
		return pDAO;
	}

	// 등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO products (product_id, product_name, product_price) VALUES(products_seq.nextval, ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("등록실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 재고
	public void updateStock(Product product) {
		try {
			connect();
			String sql = "UPDATE products SET product_stock = ? WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductStock());
			pstmt.setString(2, product.getProductName());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 이름, 가격
	public void updateInfo(Product product) {
		try {
			connect();
			String sql = "UPDATE products SET product_name = ?, product_price = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductId());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(int productId) {
		try {
			connect();
			String sql = "DELETE FROM products WHERE product_id = " + productId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 이름
	public Product selectOneName(String productName) {

		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM products WHERE product_name = " + productName;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				product.setProductStock(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return product;
	}

	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		Product product = new Product();
		try {
			connect();
			String sql = "SELECT * FROM products ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getInt(3));
				product.setProductStock(rs.getInt(4));
				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
