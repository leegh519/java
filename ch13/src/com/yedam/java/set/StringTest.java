package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();

		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		set.add(new String("Java"));

		System.out.println("총 객체수 : " + set.size());

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println("\t" + iterator.next());
		}

		set.remove("JDBC");
		set.remove("iBATIS");
		set.add("ABCDE");
		System.out.println();

		iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println("\t" + iterator.next());
		}

		System.out.println();

		set.clear();
		if (set.isEmpty()) {
			System.out.println("empty");
		}

	}

}
