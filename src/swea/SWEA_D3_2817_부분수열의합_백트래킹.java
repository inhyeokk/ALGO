package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_2817_부분수열의합_백트래킹 {
	private static final int[] arr = new int[20];
	private static int N, K;
	private static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int depth, int sum) {
		if (depth == N) {
			if (sum == K) {
				++cnt;
			}
			return;
		} else if (sum > K) {
			return;
		}
		dfs(depth+1, sum+arr[depth]);
		dfs(depth+1, sum);
	}
}
