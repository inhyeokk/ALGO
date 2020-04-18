package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1043
 * @date   	2020-04-18
 * @author 	rkddlsgur983
 * @memory 	13196KB / 128MB
 * @time   	80ms / 2초
 * @idea	BFS
 */
public class BOJ_G4_1043_거짓말 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < k; ++i) {
			int w = Integer.parseInt(st.nextToken())-1;
			visit[w] = true;
			queue.add(w);
		}
		int[][] party = new int[m][];
		boolean[] pvisit = new boolean[m];
		List<Integer>[] graph = new List[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			party[i] = new int[s];
			for (int j = 0; j < s; ++j) {
				party[i][j] = Integer.parseInt(st.nextToken())-1;
				graph[party[i][j]].add(i);
			}
		}
		br.close();
		
		while (!queue.isEmpty()) {
			int i = queue.poll();
			while (!graph[i].isEmpty()) {
				int j = graph[i].remove(0);
				if (!pvisit[j]) {
					pvisit[j] = true;
					--m;
					for (int l = 0, len = party[j].length; l < len; ++l) {
						if (!visit[party[j][l]]) {
							visit[party[j][l]] = true;
							queue.add(party[j][l]);
						}
					}
				}
			}
		}
		System.out.print(m);
	}
}
