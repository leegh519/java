package baekjoon.p1463;

import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		int count = 0;

		while (x != 1) {
			count++;
			// 3의 배수
			if (x % 3 == 0) {
				x /= 3;
			}
			// 3의 배수 +1
			else if (x % 3 == 1) {
				x--;
			}
			// 3의 배수 +2
			else {
				if (x % 2 == 0) {
					x /= 2;
				} else {
					x--;
				}
			}
		}
		bw.write(count + "\n");
		br.close();
		bw.close();

	}

}
