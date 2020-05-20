package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/1647
 * @date   	2020-05-21
 * @author 	lolol0705
 * @memory 	307396KB / 256MB
 * @time   	1364ms / 2초
 * @idea	최소 신장 트리
 * 			두개의 집합이 형성될 때 종료되어야 하므로 cnt >= n-2일때 종료
 */
public class BOJ_G4_1647_도시분할계획 {
	private static int n;
	private static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		rank = new int[n];
		for (int i = 1; i < n; ++i) {
			parent[i] = i;
		}
		PriorityQueue<Route> pq = new PriorityQueue<>();
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Route(a,b,c));
		}
		br.close();
		
		int answer = 0, cnt = 0;
		while (!pq.isEmpty()) {
			Route r = pq.poll();
			int pa = find(r.a);
			int pb = find(r.b);
			if (pa != pb) {
				answer += r.c;
				++cnt;
				if (cnt >= n-2) {
					break;
				}
				union(pa,pb);
			}
		}
		System.out.print(answer);
	}
	
	static class Route implements Comparable<Route> {
		int a;
		int b;
		int c;
		public Route(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Route o) {
			return Integer.compare(c, o.c);
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
		if (rank[pa] < rank[pb]) {
			parent[pa] = pb;
		} else {
			parent[pb] = pa;
			if (rank[pa] == rank[pb]) {
				++rank[pa];
			}
		}
	}
}
