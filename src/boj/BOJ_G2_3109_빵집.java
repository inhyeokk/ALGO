package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G2_3109_빵집 {
	private static int[] di = {-1,0,1};
	private static char[][] map;
	private static int cnt;
	private static boolean possible;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; ++i) {
			map[i] = bf.readLine().toCharArray();
		}
		cnt = 0;
		for (int j = 0; j < r; ++j) {
			possible = false;
			dfs(j, 1, r, c);
			if (possible) ++cnt;
		}
		System.out.print(cnt);
		bf.close();
	}
	private static void dfs(int row, int col, int r, int c) {
		if (col == c-1) {
			possible = true;
			return;
		}
		
		for (int d = 0; d < 3; ++d) {
			int nr = row + di[d];
			if (possible) {
				return;
			}
			if (isInRange(nr,r) && map[nr][col] == '.') {
				map[nr][col] = 'X';
				dfs(nr, col+1, r, c);
			}
		}
	}
	private static boolean isInRange(int row, int r) {
		return row >= 0 && row < r;
	}
}
