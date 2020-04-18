package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/4195
 * @date   	2020-03-31
 * @author 	rkddlsgur983
 * @memory 	51164KB / 256MB
 * @time   	440ms / 3초
 * @idea	Union-find 그룹이 합쳐질때마다 인원수를 더함
 */
public class BOJ_G2_4195_친구네트워크 {
	private static int f;
	private static Map<String, Integer> map;
	private static int[][] input;
	private static int[] parent, child;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			f = Integer.parseInt(br.readLine());
			input = new int[f][2];
			map = new HashMap<>();
			int size = 0;
			for (int i = 0; i < f; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				if (!map.containsKey(a)) {
					map.put(a, size++);
				}
				input[i][0] = map.get(a);
				if (!map.containsKey(b)) {
					map.put(b, size++);
				}
				input[i][1] = map.get(b);
			}
			parent = new int[size];
			child = new int[size];
			for (int i = 0; i < size; ++i) {
				parent[i] = i;
				child[i] = 1;
			}
			for (int i = 0; i < f; ++i) {
				int a = find(input[i][0]);
				int b = find(input[i][1]);
				if (a != b) {
					parent[b] = a;
					child[a] += child[b];
				}
				sb.append(child[a]).append("\n");
			}
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
}
