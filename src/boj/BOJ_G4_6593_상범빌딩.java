package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/6593
 * @date   	2020-04-15
 * @author 	rkddlsgur983
 * @memory 	18056KB / 128MB
 * @time   	132ms / 1초
 * @idea	BFS
 */
public class BOJ_G4_6593_상범빌딩 {
	private static int[][] di = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int l = 0, r = 0, c = 0;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (l == 0 && r == 0 && c == 0) {
				break;
			}
			Queue<int[]> queue = new LinkedList<>();
			char[][][] map = new char[l][r][c];
			for (int i = 0; i < l; ++i) {
				for (int j = 0; j < r; ++j) {
					String t = br.readLine();
					for (int k = 0; k < c; ++k) {
						map[i][j][k] = t.charAt(k);
						if (map[i][j][k] == 'S') {
							queue.add(new int[] {i,j,k});
						}
					}
				}
				br.readLine();
			}
			boolean out = false;
			int step = 0;
			here:
			while (!queue.isEmpty()) {
				++step;
				for (int i = 0, size = queue.size(); i < size; ++i) {
					int[] j = queue.poll();
					for (int[] d: di) {
						int nl = j[0] + d[0];
						int nr = j[1] + d[1];
						int nc = j[2] + d[2];
						if (nl >= 0 && nl < l && nr >= 0 && nr < r && nc >= 0 && nc < c
								&& (map[nl][nr][nc] == '.' || map[nl][nr][nc] == 'E')) {
							if (map[nl][nr][nc] == 'E') {
								out = true;
								break here;
							}
							map[nl][nr][nc] = 'V';
							queue.add(new int[] {nl,nr,nc});
						}
					}
				}
			}
			if (out) {
				sb.append(String.format("Escaped in %d minute(s).", step));
			} else {
				sb.append("Trapped!");
			}
			sb.append("\n");
		};
		System.out.print(sb);
		br.close();
	}
}
