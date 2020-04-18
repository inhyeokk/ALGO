package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link} https://www.acmicpc.net/problem/2668
 * @date   2020-03-15
 * @author rkddlsgur983
 * @memory 12924KB / 128MB
 * @time   72ms / 1초
 * @idea   1. 비트 마스킹으로 방문체크 => 2^100이 Integer 범위를 넘어감
 *         2. boolean 배열로 방문체크 => 성공
 */
public class BOJ_G5_2668_숫자고르기 {
	private static int n;
	private static int[] arr;
	private static boolean[] answer, visit;
	private static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n+1];
		answer = new boolean[n+1];
		visit = new boolean[n+1];
		for (int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		bf.close();
		for (int i = 1; i <= n; ++i) {
			if (!answer[i]) {
				visit[arr[i]] = true;
				dfs(i, arr[i]);
				visit[arr[i]] = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		for (int i = 1; i <= n; ++i) {
			if (answer[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	private static void dfs(int start, int current) {
		
		if (start == current) {
			for (int i = 1; i <= n; ++i) {
				if (visit[i]) {
					answer[i] = true;
					++ans;
				}
			}
			return;
		}
		if (visit[arr[current]]) return;
		visit[arr[current]] = true;
		dfs(start, arr[current]);
		visit[arr[current]] = false;
	}
}
