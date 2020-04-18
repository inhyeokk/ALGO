package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1976
 * @date   	2020-03-31
 * @author 	rkddlsgur983
 * @memory 	16876KB / 128MB
 * @time   	124ms / 2초
 * @idea	Union-find
 */
public class BOJ_G4_1976_여행가자 {
	private static int n, m;
	private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n];
		for (int i = 1; i < n; ++i) {
			parent[i] = i;
		}
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				int k = Integer.parseInt(st.nextToken());
				if (i < j && k == 1) {
					int x = find(i);
					int y = find(j);
					if (x != y) {
						parent[y] = x;
					}
				}
			}
		}
		/* 위에서 union시 모든 경우에 대해 
		 * 최신화가 되지 않았을 가능성이 있으므로
		 * 아래 경로 확인 전 parent 최신화
		 */
		st = new StringTokenizer(br.readLine(), " ");
		int i = Integer.parseInt(st.nextToken())-1;
		int p = find(i);
		boolean possible = true;
		for (int j = 1; j < m; ++j) {
			i = Integer.parseInt(st.nextToken())-1;
			if (find(i) != p) {
				possible = false;
			}
		}
		System.out.print(possible ? "YES" : "NO");
		br.close();
	}
	
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
