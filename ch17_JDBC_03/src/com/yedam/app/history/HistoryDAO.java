package com.yedam.app.history;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.yedam.app.common.DAO;

public class HistoryDAO extends DAO {

	// 싱글톤
	private static HistoryDAO dao = null;

	private HistoryDAO() {
	}

	public static HistoryDAO getInstance() {
		if (dao == null) {
			dao = new HistoryDAO();
		}
		return dao;
	}

	// CRUD

	// 등록
	public void insert(History history) {

		try {
			connect();
			String sql = "INSERT INTO product_history VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductId());
			pstmt.setInt(2, history.getProductCategory());
			pstmt.setInt(3, history.getProductAmount());
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 처리되었습니다.");
			} else {
				System.out.println("등록이 실패하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정 - 수량
	public void update(History history) {

		try {
			connect();
			String sql = "UPDATE product_history SET product_amount = ? WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getProductAmount());
			pstmt.setInt(2, history.getProductId());
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 수정되었습니다.");
			} else {
				System.out.println("수정이 실패하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();

		}

	}

	// 삭제 - 입고내역 중에 삭제
	public void deleteInput(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 수정되었습니다.");
			} else {
				System.out.println("수정이 실패하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제 - 출고내역 중에 삭제
	public void deleteOutput(int productId) {
		try {
			connect();
			String sql = "DELETE FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건이 수정되었습니다.");
			} else {
				System.out.println("수정이 실패하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 상품 재고(입고-출고)
	public int selectOne(int productId) {
		int stock = 0;
		int in, out;

		try {
			connect();
			String sql = "SELECT SUM(product_amount) FROM product_history WHERE product_id = " + productId
					+ "GROUP BY product_category ORDER BY product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				in = rs.getInt(1);
				if (rs.next()) {
					out = rs.getInt(1);
					stock = in - out;
				} else {
					stock = in;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return stock;
	}

	// 단건조회 - 상품 입고량
	public int selectInAmount(int productId) {
		int result = 0;

		try {
			connect();
			String sql = "SELECT SUM(history_amount) FROM product_history WHERE product_id = ? AND product_category = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return result;
	}

	// 단건조회 - 상품 출고량
	public int selectOutAmount(int productId) {
		int result = 0;

		try {
			connect();
			String sql = "SELECT SUM(history_amount) FROM product_history WHERE product_id = ? AND product_category = 2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return result;
	}

	// 전체조회 - 전체상품의 각각의 재고
	public Map<Integer, Integer> selectAllAmount() {
		Map<Integer, Integer> list = new HashMap<>();

		try {

			connect();
			String sql = "SELECT product_id, product_category, SUM(product_amount) as amount"
					+ " FROM product_history GROUP BY product_id, product_category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Map<Integer, Integer> inList = new HashMap<Integer, Integer>();
			Map<Integer, Integer> outList = new HashMap<Integer, Integer>();
			while (rs.next()) {
				int category = rs.getInt("product_category");

				if (category == 1) {
					inList.put(rs.getInt("product_id"), rs.getInt("amount"));
				} else {
					outList.put(rs.getInt("product_id"), rs.getInt("amount"));
				}
			}

			Set<Integer> keySet = inList.keySet();
			for (int key : keySet) {
				int inAmount = inList.get(key);
				Integer outAmount = outList.get(key);
				if (outAmount != null) {
					list.put(key, inAmount - outAmount);
				} else {
					list.put(key, inAmount);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

}
