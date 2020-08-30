package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/1525
 * @date   	2020-05-05
 * @author 	rkddlsgur983
 * @memory 	42416KB / 256MB
 * @time   	400ms / 1초
 * @idea	BFS
 */
public class BOJ_G2_1525_퍼즐 {
	private static final int[][][] di = {
			{{0,1},{1,0}},{{0,1},{1,0},{0,-1}},{{1,0},{0,-1}},
			{{-1,0},{0,1},{1,0}},{{-1,0},{0,1},{1,0},{0,-1}},{{-1,0},{1,0},{0,-1}},
			{{-1,0},{0,1}},{{-1,0},{0,1},{0,-1}},{{-1,0},{0,-1}}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 3;
		int[][] map = new int[n][n];
		int v = 0, end = 123456780;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				v = v*10 + map[i][j];
			}
		}
		br.close();
		if (v == end) {
			System.out.print(0);
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		set.add(v);
		q.add(v);
		int s = 0;
		while (!q.isEmpty()) {
			++s;
			for (int i = 0, size = q.size(); i < size; ++i) {
				v = q.poll();
				int r = 0, c = 0;
				for (int j = n-1; j >= 0; --j) {
					for (int k = n-1; k >= 0; --k) {
						map[j][k] = v %10;
						if (map[j][k] == 0) {
							r = j;
							c = k;
						}
						v /= 10;
					}
				}
				int x = r*3+c;
				for (int[] d: di[x]) {
					int nr = r + d[0];
					int nc = c + d[1];
					int tmp = map[r][c];
					map[r][c] = map[nr][nc];
					map[nr][nc] = tmp;
					int t = 0;
					for (int j = 0; j < n; ++j) {
						for (int k = 0; k < n; ++k) {
							t = t*10 + map[j][k];
						}
					}
					map[nr][nc] = map[r][c];
					map[r][c] = tmp;
					if (end == t) {
						System.out.print(s);
						return;
					}
					if (!set.contains(t)) {
						set.add(t);
						q.add(t);
					}
				}
			}
		}
		System.out.print(-1);
	}
}
