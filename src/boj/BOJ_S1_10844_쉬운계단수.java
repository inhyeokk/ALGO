package boj;

import java.util.Scanner;

/**
 * @{link} 	https://www.acmicpc.net/problem/10844
 * @date   	2020-04-19
 * @author 	rkddlsgur983
 * @memory 	14284KB / 256MB
 * @time   	108ms / 1초
 * @idea	i층에서 0 ~ 9의 수를 선택 했을 때 
 * 			0와 9의 경우 i-1층에서 차이가 1이 아닌 수를 더하지 않고
 * 			나머지 수의 경우 모든 경우의 차이가 1이므로 둘다 더한다.
 */
public class BOJ_S1_10844_쉬운계단수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int mod = 1000000000;
		int s = 10;
		long[][] dp = new long[n][s];
		for (int i = 0; i < s; ++i) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < s; ++j) {
				dp[i][j] = ((j == 0 ? 0 : dp[i-1][j-1]) + (j == s-1 ? 0 : dp[i-1][j+1])) % mod;
			}
		}
		long sum = 0;
		for (int i = 1; i < s; ++i) {
			sum = (sum + dp[n-1][i]) % mod;
		}
		System.out.print(sum);
	}
}
