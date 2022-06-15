package com.yedam.java.ch1403;

import java.io.*;

public class BufferStreamExam {

	static int data = -1;

	public static void main(String[] args) throws Exception {
		// buffer 스트림 미사용
		String originalFilePath1 = BufferStreamExam.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "D:/dev/temp/targetFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePath1);
		
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("nonbuffer : \t" + nonBufferTime);
		
		
		// buffer 스트림 사용
		String originalFilePath2 = BufferStreamExam.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "D:/dev/temp/targetFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		OutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		long BufferTime = copy(bis, bos);
		System.out.println("buffer : \t" + BufferTime);
		

	}

	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();

		while (true) {
			data = is.read();
			if (data == -1)
				break;
			os.write(data);
		}

		long end = System.nanoTime();
		return end - start;
	}

}
