package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class ReceivingDAO extends DAO {

	private static ReceivingDAO rDAO;

	private ReceivingDAO() {
	}

	public static ReceivingDAO getInstance() {
		if (rDAO == null) {
			rDAO = new ReceivingDAO();
		}
		return rDAO;
	}

	// 등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO receiving_goods (product_id, product_amount) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result+"건이 정상적으로 등록되었습니다.");
			} else {
				System.out.println("등록실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 존재유무
	public boolean selectInfo(int productId) {
		boolean isSelected = false;
		try {
			connect();
			String sql = "SELECT * FROM receiving_goods WHERE product_id = " + productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				isSelected = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return isSelected;
	}

	// 단건조회 - 입고수량
	public int selectAmount(int productId) {
		int amount = 0;

		try {
			connect();
			String sql = "SELECT NVL(SUM(product_amount),0) as amount FROM receiving_goods WHERE product_id = "
					+ productId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			/*
			 * rs.wasNull() : rs이 null인지 확인 
			 * NVL함수 사용할 수도 있음
			 */
			if (rs.next()) {
				amount = rs.getInt("amount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return amount;
	}

	// 전체조회 - 현재까지 입고 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM receiving_goods r "
					+ "JOIN products p ON (r.product_id = p.product_id) ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체조회 - 해당 날짜에 입고 내역
	public List<DealInfo> selectAllDate(Date dealDate) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM receiving_goods r "
					+ "JOIN products p ON (r.product_id = p.product_id) AND r.deal_date = ? ORDER BY 1,2";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, dealDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체조회 - 해당 제품의 입고 내역
	public List<DealInfo> selectAllProduct(int productId) {
		List<DealInfo> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT r.deal_date, r.product_id, p.product_name, r.product_amount FROM receiving_goods r "
					+ "JOIN products p ON (r.product_id = p.product_id) AND r.product_id = ? ORDER BY 1,2";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DealInfo info = new DealInfo();
				info.setDealDate(rs.getDate("deal_date"));
				info.setProductId(rs.getInt("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setProductAmount(rs.getInt("product_amount"));
				list.add(info);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
