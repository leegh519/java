package com.yedam.java.ch1401;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("D:/dev/temp/test1.db");

		while (true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			System.out.println(data);
		}
		is.close();

		System.out.println();
		is = new FileInputStream("D:/dev/temp/test2.db");
		byte[] buffer = new byte[100];

		while (true) {
			int data = is.read(buffer);
			if (data == -1) {
				break;
			}
			System.out.println(data);
			for (int i = 0; i < data; i++)
				System.out.println(buffer[i]);
		}

		System.out.println();
		is = new FileInputStream("D:/dev/temp/test3.db");

		int data = is.read(buffer, 3, 2);
		System.out.println(data);
		for (int i = 0; i < 3 + data; i++)
			System.out.println(buffer[i]);

				
		
		System.out.println();
		is = new FileInputStream("D:/dev/temp/test11.db");

		data = is.read(buffer);
		System.out.println(data);
		for (int i = 0; i < data; i++)
			System.out.print(buffer[i]+" ");
		
		
	}

}
