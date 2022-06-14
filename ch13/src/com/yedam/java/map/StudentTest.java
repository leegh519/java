package com.yedam.java.map;

import java.util.*;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();

		map.put(new Student(1, "홍길동"), 90);
		map.put(new Student(1, "홍길동"), 100);

		System.out.println("entry 수 : " + map.size());
		System.out.println("홍길동 성적 : " + map.get(new Student(1, "홍길동")));

	}

}
