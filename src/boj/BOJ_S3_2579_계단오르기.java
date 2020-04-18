package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/2579
 * @date   	2020-04-16
 * @author 	rkddlsgur983
 * @memory 	12880KB / 128MB
 * @time   	76ms / 1초
 * @idea	동적 계획법
 */
public class BOJ_S3_2579_계단오르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		if (n == 1) {
			System.out.println(arr[1]);
			return;
		}
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		for (int i = 3; i <= n; ++i) {
			dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]);
		}
		System.out.print(dp[n]);
	}
}
