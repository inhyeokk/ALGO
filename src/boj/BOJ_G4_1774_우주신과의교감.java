package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/1774
 * @date   	2020-05-01
 * @author 	rkddlsgur983
 * @memory 	37316KB / 128MB
 * @time   	236ms / 2초
 * @idea	최소 신장 트리 / 크루스칼
 * 			좌표 범위가 최대일 경우 곱했을 때 
 * 			integer범위를 넘어가므로 long
 */
public class BOJ_G4_1774_우주신과의교감 {
	private static int[] parent, key;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		key = new int[n];
		int[][] arr = new int[n][2]; // 우주신 좌표
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		int cnt = 0;
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int pa = find(a);
			int pb = find(b);
			if (pa == pb) continue;
			union(pa,pb);
			++cnt;
		}
		bf.close();
		PriorityQueue<Pass> pq = new PriorityQueue<>();
		for (int i = 0; i < n-1; ++i) {
			for (int j = i+1; j < n; ++j) {
				long x = arr[i][0] - arr[j][0];
				long y = arr[i][1] - arr[j][1];
				pq.add(new Pass(i,j,Math.sqrt(x*x+y*y)));
			}
		}
		double result = 0;
		while (!pq.isEmpty()) {
			Pass p = pq.poll();
			int pa = find(p.f);
			int pb = find(p.t);
			if (pa == pb) continue;
			union(pa,pb);
			++cnt;
			result += p.v;
			if (cnt == n-1) break;
		}
		System.out.print(String.format("%.2f", result));
	}
	
	static class Pass implements Comparable<Pass> {
		int f;
		int t;
		double v;
		public Pass(int f, int t, double v) {
			this.f = f;
			this.t = t;
			this.v = v;
		}
		@Override
		public int compareTo(Pass o) {
			return Double.compare(v, o.v);
		}
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
