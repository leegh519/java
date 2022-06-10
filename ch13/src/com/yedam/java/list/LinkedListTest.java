package com.yedam.java.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> arrList = new ArrayList<>();
		List<String> linkedList = new LinkedList<>();

		long start;
		long end;

		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrList.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayList 걸린시간  : " + (end - start)+"ns");
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (end - start)+"ns");
		
		System.out.println();
		arrList.clear();
		linkedList.clear();
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrList.add(String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("ArrayList 걸린시간  : " + (end - start)+"ns");
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.add(String.valueOf(i));
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (end - start)+"ns");
		
		System.out.println();
		
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			arrList.remove(9999-i);
		}
		end = System.nanoTime();
		System.out.println("ArrayList 걸린시간  : " + (end - start)+"ns");
		
		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.remove(9999-i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList 걸린시간 : " + (end - start)+"ns");

	}

}
