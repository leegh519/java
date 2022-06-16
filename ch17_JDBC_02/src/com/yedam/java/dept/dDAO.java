package com.yedam.java.dept;

import java.io.*;
import java.sql.*;
import java.util.*;

public class dDAO {

	private static dDAO instance = null;

	private dDAO() {
	}

	public static dDAO getInstance() {
		if (instance == null) {
			instance = new dDAO();
		}
		return instance;
	}

	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {

		try {
			dbconfig();

			Class.forName(jdbc_driver);

			conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 로딩 실패");
		} catch (SQLException e) {
			System.out.println("db 접속 실패");
		}

	}

	private void dbconfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");

	}

	private void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CRUD

	public List<Department> selectAll() {
		List<Department> list = null;
		try {
			list = new ArrayList<>();
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments");

			while (rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getInt("location_id"));
				dept.setManagerId(rs.getInt("location_id"));
				list.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public Department selectOne(int departmentId) {
		Department dept = null;

		try {
			connect();
			pstmt = conn.prepareStatement("SELECT * FROM departments WHERE department_id = ?");
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getInt("location_id"));
				dept.setManagerId(rs.getInt("location_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return dept;
	}

	public void insert(Department dept) {
		try {
			connect();
			pstmt = conn.prepareStatement("INSERT INTO departments VALUES (?, ?, ?, ?)");
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			int result = pstmt.executeUpdate();
			if (result != 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void delete(int departmentId) {
		try {
			connect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("DELETE FROM departments WHERE department_id = " + departmentId);
			if (result != 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void update(Department dept) {
		try {
			connect();
			pstmt = conn.prepareStatement("UPDATE departments SET department_name = ? WHERE department_id = ?");
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());
			int result = pstmt.executeUpdate();

			if (result != 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {

		} finally {
			disconnect();
		}
	}

}
