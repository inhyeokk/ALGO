package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-03
 * @author rkddlsgur983
 * @memory 13248KB / 512MB
 * @time   80ms / 2초
 */
public class BOJ_G5_14503_로봇청소기 {
	private static final int[][] di = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int clear = 0;
		while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				++clear;
			}
			boolean possible = false;
			for (int i = 0; i < 4; ++i) {
				--d;
				if (d == -1) {
					d = 3;
				}
				int nr = r + di[d][0];
				int nc = c + di[d][1];
				if (map[nr][nc] == 0) {
					r = nr;
					c = nc;
					possible = true;
					break;
				}
			}
			if (possible) continue;
			
			if (d == 0 || d == 1) {
				r += di[d+2][0];
				c += di[d+2][1];
			} else if (d == 2) {
				r += di[0][0];
				c += di[0][1];
			} else {
				r += di[1][0];
				c += di[1][1];
			}
			if (map[r][c] == 1) {
				break;
			}
		}
		System.out.print(clear);
		bf.close();
	}
}
