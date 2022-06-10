package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class MemberTest {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("abc", 20));
		set.add(new Member("abc", 20));
		
		
		System.out.println(set.size());
	}	

}
