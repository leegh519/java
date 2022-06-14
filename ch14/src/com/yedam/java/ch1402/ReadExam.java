package com.yedam.java.ch1402;

import java.io.FileReader;
import java.io.Reader;

public class ReadExam {

	public static void main(String[] args) throws Exception {
		Reader r = new FileReader("D:/dev/temp/test7.db");

		while (true) {
			int data = r.read();
			if (data == -1)
				break;
			System.out.println((char) data);
		}
		r.close();
		System.out.println();

		r = new FileReader("D:/dev/temp/test8.db");
		char[] buffer = new char[100];

		while (true) {
			int data = r.read(buffer);
			if (data == -1)
				break;
			for (int i = 0; i < data; i++)
				System.out.println(buffer[i]);
		}
		r.close();
		System.out.println();
		
		r = new FileReader("D:/dev/temp/test10.db");

		while (true) {
			int data = r.read(buffer,5,10);
			if (data == -1)
				break;
			for (int i = 0; i <5+data; i++)
				System.out.print(buffer[i]);
		}
		r.close();
		System.out.println();

	}

}
