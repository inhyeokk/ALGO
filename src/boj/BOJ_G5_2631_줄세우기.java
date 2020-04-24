package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link} 	https://www.acmicpc.net/problem/2631
 * @date   	2020-04-23
 * @author 	rkddlsgur983
 * @memory 	12825KB / 128MB
 * @time   	76ms / 1초
 * @idea	LIS
 */
public class BOJ_G5_2631_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			int m = 0;
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					m = Math.max(dp[j], m);
				}
			}
			dp[i] = m+1;
			max = Math.max(dp[i], max);
		}
		System.out.println(n-max);
		br.close();
	}
}
