package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/9372
 * @date   	2020-05-21
 * @author 	lolol0705
 * @memory 	46004KB / 256MB
 * @time   	312ms / 1초
 * @idea	최소 신장 트리
 * 			가장 적은 종류의 비행기 = 집합의 개수
 */
public class BOJ_S3_9372_상근이의여행 {
	private static int[] parent, key;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n];
			key = new int[n];
			for (int i = 1; i < n; ++i) {
				parent[i] = i;
			}
			int air = 0;
			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int pa = find(a);
				int pb = find(b);
				if (pa != pb) {
					++air;
					union(pa,pb);
				}
			}
			sb.append(air).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (key[pa] < key[pb]) {
			parent[pa] = pb;
		} else {
			parent[pb] = pa;
			if (key[pa] == key[pb]) {
				++key[pa];
			}
		}
	}
}
