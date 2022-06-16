package com.yedam.app.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ProductDAO extends DAO {
	// 싱글톤
	private static ProductDAO productDAO = null;

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	// crud

	// 등록
	public void insert(Product product) {
		try {
			connect();
			String sql = "INSERT INTO product VALUES (product_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getProductPrice());
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("제품을 등록하였습니다.");
			} else {
				System.out.println("등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 가격
	public void update(Product product) {

		try {

			connect();
			String sql = "UPDATE product SET product_price = ? WHERE product_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getProductPrice());
			pstmt.setInt(2, product.getProductId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("제품가격을 수정하였습니다.");
			} else {
				System.out.println("수정 실패");
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
			String sql = "DELETE FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("제품이 삭제되었습니다.");
			} else {
				System.out.println("삭제 실패");
			}

		} catch (SQLException e) {

		} finally {
			disconnect();

		}

	}

	// 단건조회 - 제품번호
	public Product selectOneId(int productId) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}

		} catch (SQLException e) {

		} finally {
			disconnect();
		}

		return product;
	}

	// 단건조회 - 제품이름

	public Product selectOneName(String productName) {
		Product product = null;
		try {
			connect();
			String sql = "SELECT * FROM product WHERE product_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
			}

		} catch (SQLException e) {

		} finally {
			disconnect();
		}

		return product;
	}

	// 전체조회
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM product";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				list.add(product);
			}

		} catch (SQLException e) {

		} finally {
			disconnect();

		}

		return list;
	}

}
