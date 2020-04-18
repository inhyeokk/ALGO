package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/5567
 * @author rkddlsgur983
 * @memory 17052KB
 * @time   128ms
 */
public class BOJ_S1_5567_결혼식 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		List<Integer>[] graph = new LinkedList[n]; // 친구 관계를 저장하기 위한 리스트 배열
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b); // 양방향 연결
			graph[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		boolean[] visit = new boolean[n];
		visit[0] = true;
		int ans = 0;
		// 본인의 친구와 친구의 친구까지 탐색
		for (int depth = 0; depth < 2 && !queue.isEmpty(); ++depth) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int f = queue.poll();
				for (Integer j: graph[f]) {
					if (!visit[j]) {
						visit[j] = true;
						queue.add(j);
						++ans;
					}
				}
			}
		}
		System.out.print(ans);
		bf.close();
	}
}
