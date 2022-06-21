package com.yedam.app.deal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class TakeOutDAO extends DAO {
	private static TakeOutDAO tDAO;

	private TakeOutDAO() {
	}

	public static TakeOutDAO getInstance() {
		if (tDAO == null) {
			tDAO = new TakeOutDAO();
		}
		return tDAO;
	}

	// 등록
	public void insert(DealInfo info) {
		try {
			connect();
			String sql = "INSERT INTO take_out_goods (product_id, product_amount) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getProductId());
			pstmt.setInt(2, info.getProductAmount());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "건이 정상적으로 등록되었습니다.");
			} else {
				System.out.println("등록실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 단건조회 - 출고수량
	public int selectAmount(int productId) {
		int amount = 0;
		try {
			connect();
			String sql = "SELECT SUM(product_amount) AS sum FROM take_out_goods WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			if (!rs.wasNull()) {
				amount = rs.getInt("sum");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return amount;
	}

	// 전체조회 - 현재까지 출고 내역
	public List<DealInfo> selectAll() {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount "
					+ "FROM take_out_goods t JOIN products p " + "ON (t.product_id = p.product_id) ORDER BY 1,2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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

	// 전체조회 - 해당 날짜에 출고 내역
	public List<DealInfo> selectAllDate(Date date) {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount "
					+ "FROM take_out_goods t JOIN products p " + "ON (t.product_id = p.product_id) "
					+ "AND t.deal_date = " + date + " ORDER BY 1,2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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

	// 전체조회 - 해당 제품의 출고 내역
	public List<DealInfo> selectAllProduct(int productId) {
		List<DealInfo> list = new ArrayList<DealInfo>();
		try {
			connect();
			String sql = "SELECT t.deal_date, t.product_id, p.product_name, t.product_amount "
					+ "FROM take_out_goods t JOIN products p " + "ON (t.product_id = p.product_id) "
					+ "AND t.product_id = " + productId + " ORDER BY 1,2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
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
