package com.yedam.java.ch1401;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("D:/dev/temp/test1.db");

		byte a = 10;
		byte b = 20;
		byte c = 30;

		os.write(a);
		os.write(b);
		os.write(c);

		os.flush();
		os.close();

		os = new FileOutputStream("D:/dev/temp/test2.db");

		byte[] array1 = { 10, 20, 30 };
		os.write(array1);

		os.flush();
		os.close();

		os = new FileOutputStream("D:/dev/temp/test3.db");

		byte[] array2 = { 10, 20, 30, 40, 50 };
		os.write(array2, 2, 3);

		os.flush();
		os.close();
		
		os = new FileOutputStream("D:/dev/temp/test4.db");
		os.write(65);

		os.flush();
		os.close();
	}

}
