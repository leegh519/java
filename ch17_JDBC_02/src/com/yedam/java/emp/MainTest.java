package com.yedam.java.emp;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
//		List<Employee> list = EmpDAO.getInstance().selectAll();
//		for(Employee emp : list) {
//			System.out.println(emp);
//		}

		EmpDAO edao = EmpDAO.getInstance();
		System.out.println(edao.selectOne(100));

	}

}
