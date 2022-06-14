package com.yedam.java.map;

import java.util.*;

public class StringTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		map.put("신윤권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		System.out.println("entry 수 : " + map.size());

		Integer returnval = map.put("홍길동", 100);
		if (returnval != null) {
			System.out.println("기존값 : " + returnval);
		}
		System.out.println("홍길동 : " + map.get("홍길동"));
		
		Set<String> set = map.keySet();
		Iterator<String> keyIterator = set.iterator();
		
		while(keyIterator.hasNext()) {
			String s = keyIterator.next();
			System.out.println(map.get(s));
		}
		
		System.out.println();
		for(String key : set) {
			System.out.println(map.get(key));
		}
		
		map.remove("홍길동");
		
		System.out.println();
		
		Set<Map.Entry<String, Integer>> eset = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = eset.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Integer> m = it.next();
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println();
		
		for(Map.Entry<String, Integer> entry : eset) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
