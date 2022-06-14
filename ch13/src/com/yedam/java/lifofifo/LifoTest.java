package com.yedam.java.lifofifo;

import java.util.*;

public class LifoTest {

	public static void main(String[] args) {
		Stack<Integer> box = new Stack<>();
		
		box.push(100);
		box.push(50);
		box.push(500);
		box.push(10);
		
		while(!box.isEmpty()) {
			System.out.println(box.size());
			System.out.println(box.pop());
		}
				
		
		
		
		
	}

}
