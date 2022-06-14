package com.yedam.java.ch1402;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExam {

	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("D:/dev/temp/test7.db");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(65601);
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("D:/dev/temp/test8.db");
		
		char[] arr1 = {'A', 'B', 'C'};
		writer.write(arr1);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("D:/dev/temp/test9.db");
		
		char[] arr2 = {'A', 'B', 'C', 'D', 'E'};
		writer.write(arr2, 2, 3);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("D:/dev/temp/test10.db");
		String s1 = "ABCDE\n";
		String s2 = "abced";
		
		writer.write(s1);
		writer.write(s2, 3, 2);
		
		writer.flush();
		writer.close();
		
		writer = new FileWriter("D:/dev/temp/test11.db");
		String s3 = "가나다\n";
		
		writer.write(s3);
		
		writer.flush();
		writer.close();
		
		
	}

}
