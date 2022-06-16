package com.yedam.java.emp;

import java.io.*;
import java.sql.*;
import java.util.*;

public class EmpDAO {

	private static EmpDAO empDAO = null;

	private EmpDAO() {
	}

	public static EmpDAO getInstance() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}

	// 오라클 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;

	// 각 메소드에서 공통적으로 사용하는 필드
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
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees ORDER BY employee_id");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// 단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null;
		try {
			connect();
			pstmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return emp;
	}

	// 등록
	public void insert(Employee emp) {

		try {
			connect();
			pstmt = conn.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());

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
	public void update(Employee emp) {

		try {
			connect();
			pstmt = conn.prepareStatement("UPDATE employees SET salary = ? WHERE employee_id = ?");
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());

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
	public void delete(int employeeId) {
		try {
			connect();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("DELETE FROM employees WHERE employee_id = " + employeeId);

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