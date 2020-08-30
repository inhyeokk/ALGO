package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-11
 * @author rkddlsgur983
 * @memory 145020KB / 256MB
 * @time   526ms / 20초
 */
public class SWEA_D4_1251_하나로_프림 {
	/* 그래프 탐색과 관련된 탐욕 알고리즘
	 * - Dijkstra - 어떤 정점에서 다른 정정까지의 최단 거리(비용)
	 * - Prim, Kruskal - MST
	 * 
	 * MST 최소신장트리
	 * 1. 모든 정점을 연결하고 간선의 부분들로 이루어진 집합
	 * 2. Tree이므로 모든 정점이 연결되고 싸이클은 없다.
	 * 3. root, 조상, 자식 개념이 없다.
	 * - Prim: 	  dijkstra와 동일한 개념
	 * - kruskal: union-find
	 */
	private static int n;
	private static final int[][] arr = new int[1000][2];
	private static double e;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1,st2;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			n = Integer.parseInt(bf.readLine());
			st1 = new StringTokenizer(bf.readLine(), " ");
			st2 = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				arr[j][0] = Integer.parseInt(st1.nextToken());
				arr[j][1] = Integer.parseInt(st2.nextToken());
			}
			
			e = Double.parseDouble(bf.readLine());
			/* 노드를 재방문하지 않으면 싸이클이 만들어지지 않기 때문에
			 * 어느 정점에서 출발해도 무방하다.
			 */
			boolean[] visit = new boolean[n];
			visit[0] = true;
			long sum = 0;
			int cnt = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int k = 1; k < n; ++k) {
				long a = arr[0][0]-arr[k][0];
				long b = arr[0][1]-arr[k][1];
				pq.add(new Node(k, a*a+b*b));
			}
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				if (!visit[node.i]) {
					visit[node.i] = true;
					sum += node.w;
					++cnt;
					if (cnt == n-1) {
						break;
					}
				}
				for (int k = 0; k < n; ++k) {
					if (visit[k]) continue;
					long a = arr[node.i][0]-arr[k][0];
					long b = arr[node.i][1]-arr[k][1];
					pq.add(new Node(k, a*a+b*b));
				}
			}
			sb.append("#").append(i).append(" ").append(Math.round(e*sum)).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Node implements Comparable<Node> {
		int i;
		long w;
		
		public Node(int i, long w) {
			this.i = i;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(w, o.w);
		}		
	}
}
