package com.yedam.java.map;

public class Student {
	public String name;
	public int sno;

	public Student(int sno, String name) {
		this.name = name;
		this.sno = sno;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + sno;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student st = (Student) obj;
			return st.name.equals(name) && st.sno == sno;
		}

		return false;
	}
}
