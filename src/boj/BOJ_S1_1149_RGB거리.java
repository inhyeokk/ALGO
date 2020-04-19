package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1149
 * @date   	2020-04-19
 * @author 	rkddlsgur983
 * @memory 	13516KB / 128MB
 * @time   	92ms / 0.5초
 * @idea	동적 계획법
 * 			i층에서 빨간색을 선택했을 경우 i-1에서 파란색과 노란색 중 비용이 적은 것을 선택한다.
 */
public class BOJ_S1_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		int[][] dp = new int[n+1][3];
		for (int i = 1; i <= n; ++i) {
			dp[i][0] = arr[i-1][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = arr[i-1][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = arr[i-1][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.print(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
