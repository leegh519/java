package com.yedam.java.emp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

public class EmpSystem {
	private EmpDAO dao = EmpDAO.getInstance();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public EmpSystem() {
		while (true) {
			menuPrint();

			int menu = selectMenu();

			if (menu == 1) {
				// 등록
				insertEmployee();
			} else if (menu == 2) {
				// 수정
				updateEmployee();
			} else if (menu == 3) {
				// 삭제
				deleteEmployee();
			} else if (menu == 4) {
				// 사원조회
				selectEmployee();
			} else if (menu == 5) {
				// 전체조회
				selectAllEmployee();
			} else if (menu == 9) {
				// 종료
				exit();
				break;
			} else {
				inputError();
			}
		}
	}

	private void inputError() {
		System.out.println("메뉴에 맞게 입력하세요");
	}

	private void exit() {
		System.out.println("프로그램 종료");
	}

	private void selectAllEmployee() {
		List<Employee> list = dao.selectAll();

		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

	private void selectEmployee() {
		int employeeId = inputEmployeeId();

		Employee emp = dao.selectOne(employeeId);
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("검색결과 없음");
		}
	}

	private int inputEmployeeId() {
		return inputInt();
	}

	private int inputInt() {
		int i = 0;
		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return i;
	}

	private String inputString() {
		String s = null;
		try {
			s = br.readLine();
		} catch (NumberFormatException e) {
			System.out.println("문자열 입력");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return s;
	}

	private void deleteEmployee() {
		int employeeId = inputEmployeeId();

		dao.delete(employeeId);
	}

	private void updateEmployee() {
		Employee emp = inputUpdateInfo();

		dao.update(emp);
	}

	private Employee inputUpdateInfo() {

		Employee emp = new Employee();
		System.out.print("사원번호> ");
		emp.setEmployeeId(inputInt());
		System.out.println("연봉> ");
		emp.setSalary(Double.parseDouble(inputString()));

		return emp;
	}

	private void insertEmployee() {
		Employee emp = inputAll();

		dao.insert(emp);
	}

	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사원번호> ");
		emp.setEmployeeId(inputInt());
		System.out.print("성> ");
		emp.setFirstName(inputString());
		System.out.print("이름> ");
		emp.setLastName(inputString());
		System.out.print("이메일> ");
		emp.setEmail(inputString());
		System.out.print("전화번호> ");
		emp.setPhoneNumber(inputString());
		System.out.println("입사일> ");
		emp.setHireDate(Date.valueOf(inputString()));
		System.out.println("직급>");
		emp.setJobId(inputString());
		System.out.println("연봉> ");
		emp.setSalary(Double.parseDouble(inputString()));
		System.out.println("상여금> ");
		emp.setCommissionPct(Double.parseDouble(inputString()));
		System.out.println("상사> ");
		emp.setManagerId(inputInt());
		System.out.println("부서> ");
		emp.setDepartmentId(inputInt());

		return emp;
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자로 입력");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return menu;
	}

	private void menuPrint() {
		System.out.println("====================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.사원조회 | 5.전체조회 | 9.종료");
		System.out.println("====================================================");
	}

}
