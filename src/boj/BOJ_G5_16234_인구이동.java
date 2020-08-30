package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/16234
 * @date   	2020-03-16
 * @author 	rkddlsgur983
 * @memory 	205592KB / 512MB
 * @time   	540ms / 2초
 * @idea	BFS 방문탐색 하면서 연합을 이룰 수 있는 나라들을 리스트에 넣어둠
 * 			탐색이 종료되면 연합을 찾은 것이므로 각 칸의 인구를 이동
 */
public class BOJ_G5_16234_인구이동 {
	private static int n, l, r;
	private static int[][] map;
	private static Country[][] cmap;
	private static boolean[][] visit;
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		cmap = new Country[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cmap[i][j] = new Country(i,j);
			}
		}
		bf.close();
		
		int step = 0;
		Queue<Country> queue = new LinkedList<>();
		Queue<Country> list = new LinkedList<>();
		while (true) {
			boolean share = false;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (!visit[i][j]) {
						visit[i][j] = true;
						queue.add(cmap[i][j]);
						list.add(cmap[i][j]);
						int sum = map[i][j];
						while (!queue.isEmpty()) {
							Country c = queue.poll();
							int pop = map[c.r][c.c];
							for (int[] d: di) {
								int nr = c.r + d[0];
								int nc = c.c + d[1];
								if (nr >= 0 && nr < n && nc >= 0 && nc < n 
										&& !visit[nr][nc]
										&& Math.abs(pop-map[nr][nc]) >= l 
										&& Math.abs(pop-map[nr][nc]) <= r) {
									visit[nr][nc] = true;
									sum += map[nr][nc];
									queue.add(cmap[nr][nc]);
									list.add(cmap[nr][nc]);
								}
							}
						}
						
						if (list.size() > 1) {
							share = true;
							sum /= list.size();
							while (!list.isEmpty()) {
								Country c = list.poll();
								map[c.r][c.c] = sum;
							}
						}
						list.clear();
					}
				}
			}
			if (!share) break;
			for (int i = 0; i < n; ++i) {
				Arrays.fill(visit[i], false);
			}
			++step;
		}
		System.out.print(step);
	}
	
	static class Country {
		int r;
		int c;
		public Country(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
