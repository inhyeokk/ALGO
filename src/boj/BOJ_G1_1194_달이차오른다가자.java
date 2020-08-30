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
 * @memory 	15644KB / 128MB
 * @time   	108ms / 2초
 * @idea	비트마스킹, BFS
 * 			도착지점을 최초로 방문 했을 때가 최소 거리이다.
 * 			가중치 체크가 아닌 방문 체크만으로 가능
 */
public class BOJ_G1_1194_달이차오른다가자 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		int sr = 0, sc = 0;
		for (int i = 0; i < n; ++i) {
			String s = br.readLine();
			for (int j = 0; j < m; ++j) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					sr = i;
					sc = j;
					map[i][j] = '.';
				}
			}
		}
		br.close();
		
		boolean[][][] visit = new boolean[n][m][64];
		Queue<Move> q = new LinkedList<>();
		q.add(new Move(sr,sc,0,0));
		visit[sr][sc][0] = true;
		while (!q.isEmpty()) {
			Move o = q.poll();
			for (int[] d: di) {
				int nr = o.r + d[0];
				int nc = o.c + d[1];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != '#') {
					if (map[nr][nc] == '1') {
						System.out.print(o.v+1);
						return;
					} else if (map[nr][nc] == '.') {
						if (!visit[nr][nc][o.k]) {
							visit[nr][nc][o.k] = true;
							q.add(new Move(nr,nc,o.k,o.v+1));
						}
					} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						int tk = o.k | 1 << (map[nr][nc]-'a');
						if (!visit[nr][nc][tk]) {
							visit[nr][nc][tk] = true;
							q.add(new Move(nr,nc,tk,o.v+1));
						}
					} else {
						if ((o.k & 1 << (map[nr][nc]-'A')) <= 0) continue;
						if (!visit[nr][nc][o.k]) {
							visit[nr][nc][o.k] = true;
							q.add(new Move(nr,nc,o.k,o.v+1));
						}
					}
				}
			}
		}
		System.out.print(-1);
	}
	
	static class Move {
		int r;
		int c;
		int k;
		int v;
		public Move(int r, int c, int k, int v) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.v = v;
		}
	}
}
