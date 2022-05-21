package baekjoon.p10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = 1000000;
		int max = -1000000;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a > max) {
				max = a;
			}
			if (a < min) {
				min = a;
			}
		}
		System.out.println(min + " " + max);
	}

}
