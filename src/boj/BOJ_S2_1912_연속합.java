package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1912
 * @date   	2020-04-19
 * @author 	rkddlsgur983
 * @memory 	23736KB / 128MB
 * @time   	196ms / 1초
 * @idea	어렵게 생각하지 말자
 * 			현재 값과 이전 연속된 값 더한 경우와 현재 값 중 큰 값을 유지하고
 * 			그 값으로 최대값 연산을 한다.
 */
public class BOJ_S2_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int max = -1001;
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; ++i) {
			dp[i] = Math.max(dp[i-1] + arr[i-1], arr[i-1]);
			max = Math.max(dp[i], max);
		}
		System.out.print(max);
	}
}
