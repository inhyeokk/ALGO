package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@link} https://www.acmicpc.net/problem/1058
 * @date   2020-03-09
 * @author rkddlsgur983
 * @memory 13072KB / 128MB
 * @time   80ms / 2초
 */
public class BOJ_S1_1058_친구 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		char[][] graph = new char[n][n];
		for (int i = 0; i < n; ++i) {
			graph[i] = bf.readLine().toCharArray();
		}
		int max = 0;
		for (int i = 0; i < n; ++i) {
			int friend = 0;
			for (int j = 0; j < n; ++j) {
				if (i == j) continue;
				if (graph[i][j] == 'Y' || graph[j][i] == 'Y') {
					++friend;
					continue;
				}
				for (int k = 0; k < n; ++k) {
					if (i == k || j == k) continue;
					if ((graph[i][k] == 'Y' || graph[k][i] == 'Y')
							&& (graph[j][k] == 'Y' || graph[k][j] == 'Y')) {
						++friend;
						break;
					}
				}
			}
			max = max < friend ? friend : max;
		}
		System.out.print(max);
		bf.close();
	}
}
