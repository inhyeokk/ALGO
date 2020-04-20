package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/9465
 * @date   	2020-04-21
 * @author 	rkddlsgur983
 * @memory 	133732KB / 256MB
 * @time   	752ms / 1초
 * @idea	동적 계획법
 */
public class BOJ_S2_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			st1 = new StringTokenizer(br.readLine(), " ");
			st2 = new StringTokenizer(br.readLine(), " ");
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; ++i) {
				arr[i][0] = Integer.parseInt(st1.nextToken());
				arr[i][1] = Integer.parseInt(st2.nextToken());
			}
			if (n > 1) {
				arr[1][0] += arr[0][1];
				arr[1][1] += arr[0][0];
				for (int i = 2; i < n; ++i) {
					arr[i][0] += Math.max(arr[i-1][1], arr[i-2][1]);
					arr[i][1] += Math.max(arr[i-1][0], arr[i-2][0]);
				}
				sb.append(Math.max(arr[n-1][0], arr[n-1][1]));
			} else {
				sb.append(Math.max(arr[0][0], arr[0][1]));
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
