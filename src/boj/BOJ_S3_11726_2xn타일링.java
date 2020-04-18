package boj;

import java.util.Scanner;

/**
 * @{link}	https://www.acmicpc.net/problem/11726
 * @date   	2020-04-16
 * @author 	rkddlsgur983
 * @memory 	14300KB / 256MB
 * @time   	108ms / 1초
 * @idea	동적 계획법
 */
public class BOJ_S3_11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n == 1) {
			System.out.print(1);
			return;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; ++i) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		System.out.print(dp[n]);
	}
}
