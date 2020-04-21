package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/2056
 * @date   	2020-04-22
 * @author 	rkddlsgur983
 * @memory 	88316KB / 256MB
 * @time   	668ms / 2초
 * @idea	위상정렬
 * 			선행 관계가 없는 작업들을 우선순위 큐에 추가
 * 			큐에 담긴 작업들 중 가장 짧은 시간이 소요되는 작업 시간만큼
 * 			해당 작업들도 시간 소모
 */
public class BOJ_G4_2056_작업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new List[n];
		int[][] arr = new int[n][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); // 소요 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 선행 관계 수
			for (int j = 0, s = arr[i][1]; j < s; ++j) {
				int k = Integer.parseInt(st.nextToken())-1;
				graph[k].add(i);
			}
			if (arr[i][1] == 0) { // 선행 관계가 없으면 추가
				pq.add(new int[] {i, arr[i][0]});
			}
		}
		br.close();
		
		int time = 0;
		while (!pq.isEmpty()) {
			int[] i = pq.poll();
			time += i[1]; // 작업 대상 중 가장 먼저 완료되는 작업의 시간
			Queue<int[]> queue = new LinkedList<>();
			while (!pq.isEmpty()) {
				int[] t = pq.poll();
				t[1] -= i[1]; // 그 시간만큼 작업 대상들도 시간 소모
				queue.add(t);
			}
			pq.addAll(queue);
			for (int j: graph[i[0]]) {
				if (--arr[j][1] == 0) {
					pq.add(new int[] {j, arr[j][0]});
				}
			}
		}
		System.out.print(time);
	}
}
