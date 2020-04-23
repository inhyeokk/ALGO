package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/12865
 * @date   	2020-04-23
 * @author 	rkddlsgur983
 * @memory 	52708KB / 512MB
 * @time   	160ms / 2초
 * @idea	Knapsack
 */
public class BOJ_G5_12865_평범한배낭_DP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		int[][] dp = new int[n+1][k+1];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= k; ++j) {
				dp[i][j] = dp[i-1][j]; // i번째 물건을 선택하지 않는 경우
				if (j - arr[i-1][0] >= 0) { // i번째 물건을 선택하는 경우
					dp[i][j] = Math.max(arr[i-1][1] + dp[i-1][j - arr[i-1][0]], dp[i][j]);
				}
			}
		}
		System.out.print(dp[n][k]);
	}
}
