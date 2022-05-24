package baekjoon.p1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int result = 1;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				result *= m;
				m--;
			}
			System.out.println(result/n);
		}

	}

}
