package com.yedam.java.lifofifo;

import java.util.*;

public class FifoTest {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(100);
		que.offer(50);
		que.offer(500);
		que.offer(10);
		
		while(!que.isEmpty()) {
			System.out.println(que.size());
			System.out.println(que.poll());
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
