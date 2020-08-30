package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {
	private static int n, m, size, min = Integer.MAX_VALUE, s;
	private static int[][][] map;
	private static List<int[]> virus;
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n][3];
		virus = new ArrayList<>();
		s = n*n - m;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = new int[] {i,j,v};
				if (v == 2) {
					map[i][j][2] = 0;
					virus.add(map[i][j]);
				} else if(v == 1) {
					--s;
				}
			}
		}
		br.close();
		size = virus.size();
		dfs(0, 0, 0, new int[m][]);
		System.out.print(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	private static void dfs(int depth, int start, int select, int[][] choice) {
		
		if (depth == m) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visit = new boolean[n][n];
			for (int[] c: choice) {
				q.add(c);
				visit[c[0]][c[1]] = true;
			}
			int cnt = 0;
			int time = 0;
			while (!q.isEmpty()) {
				++time;
				for (int i = 0, len = q.size(); i < len; ++i) {
					int[] v = q.poll();
					for (int[] d: di) {
						int nr = v[0] + d[0];
						int nc = v[1] + d[1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc][2] == 0) {
							visit[nr][nc] = true;
							++cnt;
							q.add(map[nr][nc]);
							if (cnt == s) {
								if (min > time) {
									min = time;
								}
								return;
							}
						}
					}
				}
			}
			return;
		}
		
		for (int i = start; i < size; ++i) {
			if ((select & 1 << i) == 0) {
				choice[depth] = virus.get(i);
				dfs(depth+1, i+1, select | 1 << i, choice);
			}
		}
	}
}
