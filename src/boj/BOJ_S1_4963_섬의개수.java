package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_4963_섬의개수 {
	private static final boolean[][] map = new boolean[50][50];
	private static final int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int w, h;
		while (true) {
			st = new StringTokenizer(bf.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < w; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken()) == 1;
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j) {
					if (map[i][j]) {
						map[i][j] = false;
						dfs(i, j, w, h);
						++cnt;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int row, int col, int w, int h) {
		for (int i = 0; i < 8; ++i) {
			int nr = row + di[i][0];
			int nc = col + di[i][1];
			if (isInRange(nr,nc,w,h) && map[nr][nc]) {
				map[nr][nc] = false;
				dfs(nr, nc, w, h);
			}
		}
	}
	
	private static boolean isInRange(int row, int col, int w, int h) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
