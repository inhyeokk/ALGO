package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_2567_색종이2 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[102][102];
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a+1; j < a+11; ++j) {
				for (int k = b+1; k < b+11; ++k) {
					map[j][k] = true;
				}
			}
		}
		int answer = 0;
		for (int j = 1; j < 101; ++j) {
			for (int k = 1; k < 101; ++k) {
				if (map[j][k]) {
					for (int d = 0; d < di.length; ++d) {
						int nr = j + di[d][0];
						int nc = k + di[d][1];
						if (isInRange(nr, nc) && !map[nr][nc]) {
							++answer;
						}
					}
				}
			}
		}
		System.out.print(answer);
		br.close();
	}
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < 102 && col >= 0 && col < 102;
	}
}