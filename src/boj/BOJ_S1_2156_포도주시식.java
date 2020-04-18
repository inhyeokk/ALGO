package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/2156
 * @date   	2020-04-18
 * @author 	rkddlsgur983
 * @memory 	14104KB / 128MB
 * @time   	100ms / 2초
 * @idea	동적 계획법
 */
public class BOJ_S1_2156_포도주시식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		if (n == 1) {
			System.out.print(arr[1]);
			return;
		}
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		dp[2] = arr[2] + arr[1];
		/* 1. i번째 선택
		 * 	1-1. i-1 선택
		 * 	1-2. i-1 선택X
		 * 2. i번째 선택X
		 */
		for (int i = 3; i <= n; ++i) {
			dp[i] = arr[i] + Math.max(arr[i-1] + dp[i-3], dp[i-2]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		System.out.print(dp[n]);
	}
}
