package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1194
 * @date   	2020-05-13
 * @author 	rkddlsgur983
 * @memory 	19188KB / 128MB
 * @time   	132ms / 2초
 * @idea	비트마스킹, BFS
 */
public class BOJ_G1_1194_달이차오른다가자 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		int sr = 0, sc = 0;
		List<int[]> exit = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			String s = br.readLine();
			for (int j = 0; j < m; ++j) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					sr = i;
					sc = j;
					map[i][j] = '.';
				}
				if (map[i][j] == '1') {
					exit.add(new int[] {i,j});
				}
			}
		}
		br.close();
		int[][][] weight = new int[n][m][64];
		Queue<Move> q = new LinkedList<>();
		q.add(new Move(sr,sc,0));
		weight[sr][sc][0] = 1;
		while (!q.isEmpty()) {
			Move o = q.poll();
			for (int[] d: di) {
				int nr = o.r + d[0];
				int nc = o.c + d[1];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != '#') {
					if (map[nr][nc] == '1') {
						if (weight[nr][nc][o.k] == 0 || weight[nr][nc][o.k] > weight[o.r][o.c][o.k]+1) {
							weight[nr][nc][o.k] = weight[o.r][o.c][o.k]+1;
						}
					} else if (map[nr][nc] == '.') {
						if (weight[nr][nc][o.k] == 0 || weight[nr][nc][o.k] > weight[o.r][o.c][o.k]+1) {
							weight[nr][nc][o.k] = weight[o.r][o.c][o.k]+1;
							q.add(new Move(nr,nc,o.k));
						}
					} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						int tk = o.k | 1 << (map[nr][nc]-'a');
						if (weight[nr][nc][tk] == 0 || weight[nr][nc][tk] > weight[o.r][o.c][o.k]+1) {
							weight[nr][nc][tk] = weight[o.r][o.c][o.k]+1;
							q.add(new Move(nr,nc,tk));
						}
					} else {
						if ((o.k & 1 << (map[nr][nc]-'A')) <= 0) continue;
						if (weight[nr][nc][o.k] == 0 || weight[nr][nc][o.k] > weight[o.r][o.c][o.k]+1) {
							weight[nr][nc][o.k] = weight[o.r][o.c][o.k]+1;
							q.add(new Move(nr,nc,o.k));
						}
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0, size = exit.size(); i < size; ++i) {
			int r = exit.get(i)[0];
			int c = exit.get(i)[1];
			for (int j = 0; j < 64; ++j) {
				if (weight[r][c][j] == 0) continue;
				min = Math.min(weight[r][c][j], min);
			}
		}
		System.out.print(min == Integer.MAX_VALUE ? -1 : min-1);
	}
	
	static class Move {
		int r;
		int c;
		int k;
		public Move(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
}
