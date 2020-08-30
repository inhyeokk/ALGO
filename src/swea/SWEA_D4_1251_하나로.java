package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-09
 * @author 	rkddlsgur983
 * @memory 	100168KB / 256MB
 * @time   	327ms / 20초
 * @idea	Kruskal, Union-find
 * 			리스트를 정렬 하는 것보다 우선순위 큐가 더 빠르다.
 */
public class SWEA_D4_1251_하나로 {
	private static final int N = 1000;
	private static final int[] parents = new int[N];
	private static final int[] ranks = new int[N];
	private static final long[][] arr = new long[N][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; ++i) {
				arr[i][0] = Integer.parseInt(st1.nextToken());
				arr[i][1] = Integer.parseInt(st2.nextToken());
				parents[i] = i;
				ranks[i] = 0;
			}
			double e = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (i == j) continue;
					long l1 = arr[i][0]-arr[j][0];
					long l2 = arr[i][1]-arr[j][1];
					double v = e*(l1*l1+l2*l2);
					pq.add(new Edge(i,j,v));
				}
			}
			int cnt = 0;
			double result = 0;
			while (!pq.isEmpty()) {
				Edge g = pq.poll();
				int a = find(g.i);
				int b = find(g.j);
				if (a == b) continue;
				result += g.v;
				++cnt;
				if (cnt == n-1) break;
				union(a,b);
			}
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (ranks[pa] > ranks[pb]) {
			parents[pb] = pa;
		} else {
			parents[pa] = pb;
			if (ranks[pa] == ranks[pb]) {
				++ranks[pb];
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int i;
		int j;
		double v;
		
		public Edge(int i, int j, double v) {
			this.i = i;
			this.j = j;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(v, o.v);
		}
	}
}
