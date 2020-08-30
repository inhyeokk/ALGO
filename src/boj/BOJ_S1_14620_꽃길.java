package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/14620
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 15776KB / 256MB
 * @time   92ms / 2초
 */
public class BOJ_S1_14620_꽃길 {
	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	private static int min = Integer.MAX_VALUE;
	private static final int[][] di = {{0,0},{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(min);
		bf.close();
	}
	
	private static void dfs(int depth, int price) {
		
		if (depth == 3){
			min = price;
			return;
		}
		
		for (int i = 1; i < n-1; ++i) {
			for (int j = 1; j < n-1; ++j) {
				boolean possible = true;
				int sum = 0;
				// 제자리 포함 4방향이 가능한지 체크
				for (int d = 0; d < di.length; ++d) {
					int nr = i + di[d][0];
					int nc = j + di[d][1];
					if (visit[nr][nc]) {
						possible = false;
						break;
					}
					sum += map[nr][nc];
				}
				if (!possible || min <= price+sum) {
					continue;
				}
				// 방문 체크 후 DFS
				for (int d = 0; d < di.length; ++d) {
					int nr = i + di[d][0];
					int nc = j + di[d][1];
					visit[nr][nc] = true;
				}
				dfs(depth+1, price+sum);
				for (int d = 0; d < di.length; ++d) {
					int nr = i + di[d][0];
					int nc = j + di[d][1];
					visit[nr][nc] = false;
				}
			}
		}
	}
}
