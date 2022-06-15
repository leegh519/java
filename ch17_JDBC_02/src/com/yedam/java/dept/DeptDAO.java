package com.yedam.java.dept;

import java.sql.*;
import java.io.*;
import java.util.*;

import com.yedam.java.emp.Employee;

public class DeptDAO {
	private static DeptDAO instance =null;
	
	private DeptDAO() {
	}
	
	public static DeptDAO getInstance() {
		if(instance == null) {
			instance = new DeptDAO(); 
		}
		return instance;
	}
	
	// 오라클 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;
	
	// 공통 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void connect() {
		try {
			dbconfig();
			// 1. JDBC 드라이버 로딩
			Class.forName(jdbc_driver);
			// 2. DB 접속
			conn = DriverManager.getConnection(oracle_url, connectedPwd, connectedId);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
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
	
	// 4. 자원해제하기
	public void disconnect() {
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
	
	// 3. CRUD 실행
	// 전체조회
	public List<Department> selectAll(){
		List<Department> list = null;
		try {
			list = new ArrayList<>();
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments");
			
			while(rs.next()) {
				Department d = new Department();
				d.setDepartmentId(rs.getInt("department_id"));
				d.setDepartmentName(rs.getString("department_name"));
				d.setManagerId(rs.getInt("manager_id"));
				d.setLocationId(rs.getInt("location_id"));
				
				list.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	

	// 단건조회
	public Department selectOne(int departmentId) {
		Department dept = null;
		try {
			connect();
			pstmt = conn.prepareStatement("SELECT * FROM departments WHERE department_id = ?");
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}

	
	// 등록
	public void insert(Department d) {

		try {
			connect();
			pstmt = conn.prepareStatement("INSERT INTO departments VALUES(?,?,?,?)");
			pstmt.setInt(1, d.getDepartmentId());
			pstmt.setString(2, d.getDepartmentName());
			pstmt.setInt(3, d.getManagerId());
			pstmt.setInt(4, d.getLocationId());

			int result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	// 수정
	public void update(Department d) {

		try {
			connect();
			pstmt = conn.prepareStatement("UPDATE departments SET managerId = ? WHERE department_id = ?");
			pstmt.setInt(1, d.getManagerId());
			pstmt.setInt(2, d.getDepartmentId());

			int result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	
	
	// 삭제
	public void delete(int departmentId) {
		try {
			connect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("DELETE FROM departments WHERE department_id = " + departmentId);

			if (result < 1) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
