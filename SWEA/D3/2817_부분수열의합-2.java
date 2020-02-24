package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2817_부분수열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		int[] arr = new int[20];
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for (int j = 1; j < (1<<n); ++j) {
				int sum = 0;
				for (int o = 0; o < n; ++o) {
					if ((j&(1<<o))>0) {
						sum += arr[o];
						if (sum > k) {
							break;
						}
					}
				}
				if (sum == k) {
					++cnt;
				}
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
