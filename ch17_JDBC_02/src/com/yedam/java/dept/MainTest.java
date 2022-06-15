package com.yedam.java.dept;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		List<Department> list = DeptDAO.getInstance().selectAll();
		for(Department dept : list) {
			System.out.println(dept);
		}
	}

}
