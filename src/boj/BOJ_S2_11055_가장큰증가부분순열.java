package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link} https://www.acmicpc.net/problem/11055
 * @date   2020-03-11
 * @author rkddlsgur983
 * @memory 13820KB / 256MB
 * @time   92ms / 1초
 */
public class BOJ_S2_11055_가장큰증가부분순열 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		int[] sum = new int[n];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					max = Math.max(sum[j], max);
				}
			}
			sum[i] = arr[i] + max;
			ans = Math.max(sum[i], ans);
		}
		System.out.print(ans);
		bf.close();
	}
}
