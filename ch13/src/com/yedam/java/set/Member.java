package com.yedam.java.set;

public class Member {

	public String name;
	public int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			//boolean name = ((Member) obj).name.equals(this.name);
			//boolean age = ((Member) obj).age == this.age;
			return member.name.equals(name) && age==member.age;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}
}
