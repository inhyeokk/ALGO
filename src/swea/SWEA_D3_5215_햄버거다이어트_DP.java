package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-23
 * @author 	rkddlsgur983
 * @memory 	32116KB / 256MB
 * @time   	164ms / 8초
 * @idea	Knapsack
 * 			i번째 햄버거를 선택하는 경우
 * 			i-1번째까지를 선택했을 때 최대값과 비교
 */
public class SWEA_D3_5215_햄버거다이어트_DP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int [n+1][l+1];
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= l; ++j) {
					if (j-arr[i-1][1] >= 0) { // 넣는다.
						dp[i][j] = arr[i-1][0]+dp[i-1][j-arr[i-1][1]];
					}
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j]); // 넣기 전과 비교
				}
			}
			sb.append("#").append(t).append(" ").append(dp[n][l]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
