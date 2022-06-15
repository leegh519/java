package com.yedam.java.app;

import java.sql.*;

public class DeptSQLexample {

	public static void main(String[] args) {
		try {
			// 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// db접속
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String pwd = "hr";
			Connection con = DriverManager.getConnection(url, id, pwd);

			// crud

			/******** insert **********/
			String insert = "insert into departments values(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setInt(1, 1000);
			pstm.setString(2, "YEDAM");
			pstm.setInt(3, 200);
			pstm.setInt(4, 1400);

			int result = pstm.executeUpdate();
			System.out.println("insert 결과 " + result);

			/******** update **********/
			String update = "UPDATE departments SET department_name = ? WHERE department_id =?";
			pstm = con.prepareStatement(update);
			pstm.setString(1, "YEDAM!");
			pstm.setInt(2, 1400);

			result = pstm.executeUpdate();
			System.out.println("update 결과 " + result);

			/******** select **********/
			String select = "SELECT * from departments order by department_id";
			pstm = con.prepareStatement(select);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("department_id") + " : " + rs.getString("department_name"));
			}

			/******** delete **********/
			String delete = "DELETE from departments where department_id = ?";
			pstm = con.prepareStatement(delete);

			pstm.setInt(1, 1000);
			result = pstm.executeUpdate();
			System.out.println("delete 결과 " + result);

			// 자원해제
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (con != null)
				con.close();

		} catch (ClassNotFoundException e) {
			System.out.println("접속 실패");
		} catch (SQLException e) {
			System.out.println("Query 실행 실패");
		} finally {

		}
	}

}
