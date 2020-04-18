package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[100][100];
		StringTokenizer st;
		int answer = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			for (int j = a; j < a+10; ++j) {
				for (int k = b; k < b+10; ++k) {
					map[j][k] = true;
				}
			}
		}
		for (int j = 0; j < 100; ++j) {
			for (int k = 0; k < 100; ++k) {
				if (map[j][k]) ++answer;
			}
		}
		System.out.print(answer);
		br.close();
	}
}
