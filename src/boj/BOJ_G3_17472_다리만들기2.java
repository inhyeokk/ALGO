package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/17472
 * @date   	2020-05-06
 * @author 	rkddlsgur983
 * @memory 	13284KB / 512MB
 * @time   	80ms / 1초
 * @idea	1. 지도에 몇번째 섬인지 표시 BFS
 * 			2. 떨어진 거리가 2이상인 경우 간선추가
 * 			3. 최소 신장 트리를 구하기 위해 크루스칼
 */
public class BOJ_G3_17472_다리만들기2 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int[] parent, key;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int s = 2;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 1) {
					map[i][j] = s;
					q.add(new int[] {i,j});
					while (!q.isEmpty()) {
						int[] k = q.poll();
						for (int[] d: di) {
							int nr = k[0] + d[0];
							int nc = k[1] + d[1];
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
								map[nr][nc] = s;
								q.add(new int[] {nr,nc});
							}
						}
					}
					++s;
				}
			}
		}
		parent = new int[s];
		key = new int[s];
		for (int i = 0; i < s; ++i) {
			parent[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 0) continue;
				for (int[] d: di) {
					int l = 0;
					int nr = i + d[0];
					int nc = j + d[1];
					while (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != map[i][j]) {
						if (map[nr][nc] == 0) {
							++l;
							nr += d[0];
							nc += d[1];
						} else {
							if (l > 1) pq.add(new Edge(map[i][j], map[nr][nc], l));
							break;
						}
					}
				}
			}
		}
		
		int cnt = 0, min = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int pa = find(e.f);
			int pb = find(e.t);
			if (pa == pb) continue;
			++cnt;
			min += e.v;
			if (cnt == s-3) break;
			union(pa,pb);
		}
		System.out.print(cnt == s-3 ? min : -1);
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
	
	static class Edge implements Comparable<Edge> {
		int f;
		int t;
		int v;
		public Edge(int f, int t, int v) {
			this.f = f;
			this.t = t;
			this.v = v;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(v, o.v);
		}
	}
	
	static class Island {
		int sr;
		int sc;
		int er;
		int ec;
		public Island(int sr, int sc, int er, int ec) {
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}
	}
}
