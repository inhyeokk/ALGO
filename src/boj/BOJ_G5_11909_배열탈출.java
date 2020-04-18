package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/11909
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	506832KB / 256MB
 * @time   	2324ms / 2초
 * @idea	BFS, 점화식
 */
public class BOJ_G5_11909_배열탈출 {
	private static int[][] di = {{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		int[][][] tmp = new int[n][n][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Integer.MAX_VALUE;
				tmp[i][j][0] = i;
				tmp[i][j][1] = j;
			}
		}
		br.close();
		
		Queue<int[]> queue = new LinkedList<>();
		dp[n-1][n-1] = 0;
		queue.add(tmp[n-1][n-1]);
		while (!queue.isEmpty()) {
			int[] i = queue.poll();
			for (int[] d: di) {
				int nr = i[0] + d[0];
				int nc = i[1] + d[1];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (arr[i[0]][i[1]] < arr[nr][nc]) {
						if (dp[nr][nc] > dp[i[0]][i[1]]) {
							dp[nr][nc] = dp[i[0]][i[1]];
							queue.add(tmp[nr][nc]);
						}
					} else {
						int up = arr[i[0]][i[1]]-arr[nr][nc]+1;
						if (dp[nr][nc] > dp[i[0]][i[1]]+up) {
							dp[nr][nc] = dp[i[0]][i[1]]+up;
							queue.add(tmp[nr][nc]);
						}
					}
				}
			}
		}
		System.out.print(dp[0][0]);
	}
}
