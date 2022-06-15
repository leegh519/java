package com.yedam.java.app;

import java.sql.*;

public class SQLexample {

	public static void main(String[] args) throws Exception {
		// 1.JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. DB 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";

		Connection con = DriverManager.getConnection(url, id, pwd);

		// 3. CRUD 실행
		// INSERT -> SELECT -> UPDATE -> DELETE

		// -1. Statement or PrepareStatement 생성
		String insert = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(insert);

		// -2. SQL 구성 후 실행
		pst.setInt(1, 1000);
		pst.setString(2, "Kil-dong");
		pst.setString(3, "Hong");
		pst.setString(4, "kdHong123");
		pst.setString(5, "82.10.1234.1234");
		pst.setString(6, "21/11/05");
		pst.setString(7, "SA_REP");
		pst.setInt(8, 6000);
		pst.setDouble(9, 0.15);
		pst.setInt(10, 149);
		pst.setInt(11, 80);

		// -3. 결과출력
		int result = pst.executeUpdate();
		System.out.println("insert 결과 " + result);

		// -1 UPDATE
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
		pst = con.prepareStatement(update);
		// -2
		pst.setString(1, "Kang");
		pst.setInt(2, 1000);
		// -3
		result = pst.executeUpdate();
		System.out.println("update 결과 " + result);

		// -1 SELECT
		String select = "SELECT * FROM employees ORDER BY employee_id";
		pst = con.prepareStatement(select);
		// -2
		ResultSet rs = pst.executeQuery();
		// -3
		while (rs.next()) {
			String name = rs.getInt("employee_id") + " : " + rs.getString("first_name");
			System.out.println(name);
		}

		// -1 DELETE
		String delete = "DELETE from employees where employee_id = ?";
		pst = con.prepareStatement(delete);

		// -2
		pst.setInt(1, 1000);

		// -3
		result = pst.executeUpdate();
		System.out.println("delete 결과 " + result);

		// 4. 자원해제하기
		pst.close();
		con.close();
	}

}
