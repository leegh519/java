package com.yedam.java.dept;

import java.util.*;

public class DeptSystem {
	private dDAO dao = dDAO.getInstance();
	private Scanner sc = new Scanner(System.in);

	public DeptSystem() {
		while (true) {
			printMenu();
			int menu = selectMenu();

			if (menu == 1) {
				insertDepartment();
			} else if (menu == 2) {
				updateDepartment();
			} else if (menu == 3) {
				deleteDepartment();
			} else if (menu == 4) {
				selectDepartment();
			} else if (menu == 5) {
				selectAllDepartment();
			} else if (menu == 9) {
				exit();
				break;
			} else {
				printInputErrMSG();
			}
		}
	}

	
	private void printInputErrMSG() {
		System.out.println("없는메뉴");
	}


	private void exit() {
		System.out.println("종료");
	}


	private void selectAllDepartment() {
		List<Department> list = dao.selectAll();
		System.out.println("departmentId\t    departmentName\tmanagerId\tlocationId");
		for(Department dept : list) {
			System.out.println(dept);
		}
	}


	private void selectDepartment() {
		System.out.println("부서번호>>");
		int departmentId = inputNumber();
		Department dept = dao.selectOne(departmentId);
		if(dept != null) {
			System.out.println("departmentId\tdepartmentName\tmanagerId\tlocationId");
			System.out.println(dept);
		}else {
			System.out.println("없는부서");
		}
	}


	private void deleteDepartment() {
		int departmentId = inputNumber();
		dao.delete(departmentId);
	}


	private void updateDepartment() {
		Department dept = inputUpdateInfo();
		dao.update(dept);
	}


	private Department inputUpdateInfo() {
		Department dept = new Department();
		System.out.println("부서번호>>");
		dept.setDepartmentId(inputNumber());
		System.out.println("변경할 이름>>");
		dept.setDepartmentName(sc.nextLine());
		return dept;
	}


	private void insertDepartment() {
		Department dept = inputAll();
		dao.insert(dept);
	}


	private Department inputAll() {
		Department dept = new Department();
		System.out.println("부서번호>>");
		dept.setDepartmentId(inputNumber());
		System.out.println("부서이름>>");
		dept.setDepartmentName(sc.nextLine());
		System.out.println("매니저번호>>");
		dept.setManagerId(inputNumber());
		System.out.println("위치번호>>");
		dept.setLocationId(inputNumber());
		
		return dept;
	}


	private int selectMenu() {		
		return inputNumber();
	}

	private int inputNumber() {
		int number = 0;
		try {
			number = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자입력해라");
		}
		return number;
	}
	


	private void printMenu() {
		System.out.println("=====================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.부서조회 | 5.전체조회 | 9.종료");
		System.out.println("=====================================================");

	}

}
