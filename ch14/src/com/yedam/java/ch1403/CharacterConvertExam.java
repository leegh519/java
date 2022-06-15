package com.yedam.java.ch1403;

import java.io.*;
import java.util.Scanner;

public class CharacterConvertExam {

	public static void main(String[] args) throws Exception {
		System.out.print("입력 > ");
		String data = new Scanner(System.in).nextLine();
		write(data);
		read();
	}
	
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("D:/dev/temp/text1.txt");
		Writer writer = new OutputStreamWriter(os);
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static void read() throws Exception {
		InputStream is = new FileInputStream("D:/dev/temp/text1.txt");
		Reader reader = new InputStreamReader(is);
		
		char[] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		reader.close();
		
		String data = new String(buffer, 0, readCharNum);
		System.out.println(data);
				
	}

}
