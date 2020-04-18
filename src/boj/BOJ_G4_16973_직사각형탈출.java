package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/16973
 * @date   	2020-03-24
 * @author 	rkddlsgur983
 * @memory 	116464KB / 128MB
 * @time   	824ms / 1초
 * @idea	직사각형 범위 주의 [r, c, r+h-1, c+w-1]
 */
public class BOJ_G4_16973_직사각형탈출 {
	private static int n, m, h, w;
	private static boolean[][] map, visit;
	private static int[][] di = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n+1][m+1];
		visit = new boolean[n+1][m+1];
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j <= m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		st = new StringTokenizer(bf.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());
		bf.close();
		
		if (sr == fr && sc == fc) {
			System.out.print(0);
			return;
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sr,sc});
		visit[sr][sc] = true;
		int step = 0;
		while (!queue.isEmpty()) {
			++step;
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int[] t = queue.poll();
				for (int d = 0; d < 4; ++d) {
					int nr = t[0] + di[d][0];
					int nc = t[1] + di[d][1];
					if (movable(t[0],t[1],d)) {
						if (nr == fr && nc == fc) {
							System.out.print(step);
							return;
						}
						visit[nr][nc] = true;
						queue.add(new int[] {nr,nc});
					}
				}
			}
		}
		System.out.print(-1);
	}
	
	private static boolean movable(int r, int c, int d) {
		
		switch (d) {
			case 0:
				if (c+w <= m && !visit[r][c+1]) {
					for (int i = 0; i < h; ++i) {
						if (map[r+i][c+w]) {
							return false;
						}
					}
				} else {
					return false;
				}
				break;
			case 1:
				if (c > 1 && !visit[r][c-1]) {
					for (int i = 0; i < h; ++i) {
						if (map[r+i][c-1]) {
							return false;
						}
					}
				} else {
					return false;
				}
				break;
			case 2:
				if (r+h <= n && !visit[r+1][c]) {
					for (int i = 0; i < w; ++i) {
						if (map[r+h][c+i]) {
							return false;
						}
					}
				} else {
					return false;
				}
				break;
			case 3:
				if (r > 1 && !visit[r-1][c]) {
					for (int i = 0; i < w; ++i) {
						if (map[r-1][c+i]) {
							return false;
						}
					}
				} else {
					return false;
				}
				break;
		}
		return true;
	}
}
