package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/14940
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	53316KB / 128MB
 * @time   	500ms / 1초
 * @idea	BFS
 */
public class BOJ_G5_14940_쉬운최단거리 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] move = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					queue.add(new int[] {i,j});
					move[i][j] = 1;
				}
			}
		}
		br.close();
		
		while (!queue.isEmpty()) {
			int[] i = queue.poll();
			for (int[] d: di) {
				int nr = i[0] + d[0];
				int nc = i[1] + d[1];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1 && move[nr][nc] == 0) {
					move[nr][nc] = move[i[0]][i[1]]+1;
					queue.add(new int[] {nr,nc});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				sb.append(move[i][j] == 0 ? map[i][j] == 0 ? 0 : -1 : move[i][j]-1).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
