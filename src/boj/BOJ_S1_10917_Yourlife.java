package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/10917
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 75468KB /256MB
 * @time   504ms / 1초
 */
public class BOJ_S1_10917_Yourlife {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			graph[x].add(y);
		}
		bf.close();
		
		/* BFS 탐색
		 * 0부터 n-1까지의 최소 step
		 */
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		boolean[] visit = new boolean[n];
		visit[0] = true;
		int change = 0;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int v = queue.poll();
				if (v == n-1) {
					System.out.print(change);
					return;
				}
				for (Integer j: graph[v]) {
					if (!visit[j]) {
						visit[j] = true;
						queue.add(j);
					}
				}
			}
			++change;
		}
		System.out.print(-1);
	}
}
