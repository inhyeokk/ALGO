package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G5_14502_연구소_참고 {
	static int n;
	static int m;
	static int size;
	static int max;
	static int[][] newmap;
	static boolean[][] visit;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [][]map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					list.add(new int[] { i, j });
				map[i][j] = num;
			}
		}
		size = list.size();
		max = Integer.MIN_VALUE;
		newmap = new int[n][m];
		
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				for (int k = j + 1; k < size; k++) {
					for(int a=0;a<n;a++)
						newmap[a] = map[a].clone();
					visit = new boolean[n][m];
					newmap[list.get(j)[0]][list.get(j)[1]] = 1;
					newmap[list.get(i)[0]][list.get(i)[1]] = 1;
					newmap[list.get(k)[0]][list.get(k)[1]] = 1;
					for (int r = 0; r < n; r++)
						for (int c = 0; c < m; c++) {
							if (newmap[r][c] == 2 && !visit[r][c])
								dfs(r, c);
						}
					check();
				}
			}
		}
		System.out.println(max);
	}
	
	private static void check() {
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] == 0)
					count++;
			}

		max = Math.max(count, max);
	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (nr >= 0 && nc >= 0 && nr < n && nc < m && newmap[nr][nc] == 0) {
				newmap[nr][nc] = 2;
				dfs(nr, nc);
			}
		}
	}
}
