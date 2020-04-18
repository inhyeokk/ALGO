package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/1238
 * @date   	2020-03-22
 * @author 	rkddlsgur983
 * @memory 	48060KB / 128MB
 * @time   	1416ms / 1초
 * @idea	다익스트라 알고리즘을 이용하여
 * 			i에서 x까지, x부터 i까지의 최단 이동시간 합을 구하고
 * 			이들 중 가장 최대값이 가장 많은 시간을 소비하는 학생
 * 			+ 추가 최적화 아이디어
 * 			1~n까지 최단 시간 탐색 중 중복으로 우선순위 큐에 간선 정보가 삽입 되는데
 * 			이를 x에서 모든 정점으로의 최소비용과 모든 정점에서 x로의 최소비용을 
 * 			각각 한번에 구한다면 간선의 중복 삽입을 막아 탐색 시간을 줄일 수 있을 것 같다.
 */
public class BOJ_G3_1238_파티 {
	private static int n, m, x, max = 0;
	private static List<int[]>[] graph;
	private static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken())-1;
		graph = new LinkedList[n];
		dist = new int[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
		}
		bf.close();

		for (int i = 0; i < n; ++i) {
			max = Math.max(dijkstra(i,x)+dijkstra(x,i), max);
		}
		System.out.print(max);
	}
	
	private static int dijkstra(int start, int end) {

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int[] j: graph[start]) {
			dist[j[0]] = j[1];
			pq.add(j);
		}
		
		while (!pq.isEmpty()) {
			int[] i = pq.poll();
			for (int[] j: graph[i[0]]) {
				if (dist[j[0]] > dist[i[0]] + j[1]) {
					dist[j[0]] = dist[i[0]] + j[1];
					pq.add(j);
				}
			}
		}
		return dist[end];
	}
}
