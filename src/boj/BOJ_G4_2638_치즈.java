package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/2638
 * @date   	2020-04-21
 * @author 	rkddlsgur983
 * @memory 	15828KB / 128MB
 * @time   	132ms / 1초
 * @idea	외부 공기는 queue에 담고 다음 시간에 녹을 치즈는 melt에 담는다.
 * 			queue에 담긴 외부 공기는 4방향 탐색하면서 치즈를 만나면 cnt를 1씩 내린다.
 * 			이때 2가 된 치즈는 2개 변이 공기와 접촉했으므로 melt에 담긴다.
 */
public class BOJ_G4_2638_치즈 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? 4 : 0;
			}
		}
		br.close();
		boolean[][] visit = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> melt = new LinkedList<>();
		visit[0][0] = true;
		queue.add(new int[] {0,0});
		int time = 0;
		while (true) {
			while (!queue.isEmpty()) {
				int[] j = queue.poll();
				for (int[] d: di) {
					int nr = j[0] + d[0];
					int nc = j[1] + d[1];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc]) {
						if (map[nr][nc] == 0) {
							visit[nr][nc] = true;
							queue.add(new int[] {nr,nc});
						} else if (map[nr][nc] > 2) {
							--map[nr][nc];
							if (map[nr][nc] == 2) {
								visit[nr][nc] = true;
								melt.add(new int[] {nr, nc});
							}
						}
					}
				}
			}
			if (melt.isEmpty()) break;
			while (!melt.isEmpty()) {
				int[] j = melt.poll();
				map[j[0]][j[1]] = 0;
				queue.add(j);
			}
			++time;
		}
		System.out.print(time);
	}
}
