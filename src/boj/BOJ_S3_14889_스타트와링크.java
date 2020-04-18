package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_14889_스타트와링크 {
	private static int[][] map;
	private static boolean[] check;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, n);
		System.out.print(min);
		bf.close();
	}
	
	private static void dfs(int idx, int depth, int n) {
		if (depth == n/2) {
			int t1 = 0, t2 = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (check[i] && check[j]) {
						t1 += map[i][j];
					} else if (!check[i] && !check[j]) {
						t2 += map[i][j];
					}
				}
			}
			int diff = Math.abs(t1-t2);
			min = min > diff ? diff : min;
			return;
		}
		
		for (int i = idx; i < n; ++i) {
			check[i] = true;
			dfs(i+1, depth+1, n);
			check[i] = false;
		}
	}
}
