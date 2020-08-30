package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/6987
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 * @memory 	13004KB / 128MB
 * @time   	80ms / 1초
 * @idea	백트래킹 / 각 팀이 대전하는 경우를 찾아놓고 DFS
 */
public class BOJ_S3_6987_월드컵 {
	private static final int h = 4;
    private static final int r = 6;
    private static final int c = 3;
	private static final int[][] map = new int[r][c];
	private static int possible;
	private static final int[][] di = {
			{0,1},{0,2},{0,3},{0,4},{0,5},
			{1,2},{1,3},{1,4},{1,5},
			{2,3},{2,4},{2,5},
			{3,4},{3,5},
			{4,5}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < h; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int impossible = 0;
			int win = 0, lose = 0;
			for (int j = 0; j < r; ++j) {
				int tmp = 0;
				for (int k = 0; k < c; ++k) {
					map[j][k] = Integer.parseInt(st.nextToken());
					tmp += map[j][k];
					if (k == 0) win += map[j][k];
					else if (k == 2) lose += map[j][k];
				}
				if (tmp != 5) {
					impossible = 1;
					break;
				}
			}
			possible = 0;
			if (impossible == 0 && win == lose) {
				dfs(0);
			}
			sb.append(possible).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int depth) {
		if (possible == 1) {
			return;
		} else if (depth == 15) {
			possible = 1;
			return;
		}
		
		int x = di[depth][0];
		int y = di[depth][1];
		for (int i = 0; i < c; ++i) {
			int j = c-i-1;
			if (map[x][i] > 0 && map[y][j] > 0) {
				--map[x][i];
				--map[y][j];
				dfs(depth+1);
				++map[y][j];
				++map[x][i];
			}
		}
	}
}
