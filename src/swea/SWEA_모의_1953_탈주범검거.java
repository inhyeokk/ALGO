package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   	2020-05-28
 * @author 	rkddlsgur983
 * @memory 	26248KB / 256MB
 * @time   	129ms / 3초
 * @idea	시뮬레이션 - 이동 방향 정보를 배열에 넣어두고 BFS 탐색
 */
public class SWEA_모의_1953_탈주범검거 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[][] dir = {{},{0,1,2,3},{1,3},{0,2},{0,3},{0,1},{1,2},{2,3}};
	private static int[][] go = {{1,3,6,7},{1,2,4,7},{1,3,4,5},{1,2,5,6}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {r,c});
			boolean[][] visit = new boolean[n][m];
			visit[r][c] = true;
			int sum = 1;
			int time = 1;
			while (!q.isEmpty() && time < l) {
				for (int i = 0, size = q.size(); i < size; ++i) {
					int[] v = q.poll();
					for (int d: dir[map[v[0]][v[1]]]) {
						int nr = v[0] + di[d][0];
						int nc = v[1] + di[d][1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc]) {
							boolean pos = false;
							for (int k: go[d]) {
								if (map[nr][nc] == k) {
									pos = true;
									break;
								}
							}
							if (!pos) continue;
							visit[nr][nc] = true;
							q.add(new int[] {nr,nc});
							++sum;
						}
					}
				}
				++time;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
