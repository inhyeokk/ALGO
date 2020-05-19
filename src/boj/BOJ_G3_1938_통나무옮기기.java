package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link} 	https://www.acmicpc.net/problem/1938
 * @date   	2020-05-17
 * @author 	rkddlsgur983
 * @memory 	13376KB / 128MB
 * @time   	76ms / 2초
 * @idea	통나무 3개 중 중심좌표를 두고 가로 세로 방향여부에 따른 BFS 방문탐색
 */
public class BOJ_G3_1938_통나무옮기기 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] di2 = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		int cnt = 0, fc = 0, sr = 0, sc = 0, dir = 0; // 0: 가로, 1: 세로
		for (int i = 0; i < n; ++i) {
			String s = br.readLine();
			for (int j = 0; j < n; ++j) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'B') {
					map[i][j] = '0';
					++cnt;
					if (cnt == 1) {
						fc = j;
					} else if (cnt == 2) {
						sr = i;
						sc = j;
						if (fc == sc) {
							dir = 1; // 열이 같으면 세로 방향
						}
					}
				}
			}
		}
		br.close();
		
		Queue<Tree> q = new LinkedList<>();
		q.add(new Tree(sr,sc,dir));
		boolean[][][] visit = new boolean[n][n][2];
		visit[sr][sc][dir] = true;
		int step = 0;
		while (!q.isEmpty()) {
			++step;
			for (int i = 0, size = q.size(); i < size; ++i) {
				Tree t = q.poll();
				for (int[] d: di) {
					int nr = t.r + d[0];
					int nc = t.c + d[1];
					if (t.d == 0) {
						if (nr >= 0 && nr < n && nc-1 >= 0 && nc+1 < n && !visit[nr][nc][t.d]) {
							if (map[nr][nc-1] == 'E' && map[nr][nc] == 'E' && map[nr][nc+1] == 'E') {
								System.out.print(step);
								return;
							} else if (map[nr][nc-1] != '1' && map[nr][nc] != '1' && map[nr][nc+1] != '1') {
								visit[nr][nc][t.d] = true;
								q.add(new Tree(nr,nc,t.d));
							}
						}
					} else {
						if (nr-1 >= 0 && nr+1 < n && nc >= 0 && nc < n && !visit[nr][nc][t.d]) {
							if (map[nr-1][nc] == 'E' && map[nr][nc] == 'E' && map[nr+1][nc] == 'E') {
								System.out.print(step);
								return;
							} else if (map[nr-1][nc] != '1' && map[nr][nc] != '1' && map[nr+1][nc] != '1') {
								visit[nr][nc][t.d] = true;
								q.add(new Tree(nr,nc,t.d));
							}
						}
					}
				}
				boolean go = true;
				for (int[] d: di2) {
					int nr = t.r + d[0];
					int nc = t.c + d[1];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] == '1') {
						go = false;
						break;
					}
				}
				if (go) {
					if (!visit[t.r][t.c][0]) {
						visit[t.r][t.c][0] = true;
						q.add(new Tree(t.r,t.c,0));
					}
					if (!visit[t.r][t.c][1]) {
						visit[t.r][t.c][1] = true;
						q.add(new Tree(t.r,t.c,1));
					}
				}
			}
		}
		System.out.print(0);
		return;
	}
	
	static class Tree {
		int r;
		int c;
		int d;
		public Tree(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
