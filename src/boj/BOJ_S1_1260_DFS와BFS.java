package boj;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S1_1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		List<Integer>[] dfs = new List[n+1];
		List<Integer>[] bfs = new List[n+1];
		boolean[] visit = new boolean[n+1];
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (dfs[a] == null) {
				dfs[a] = new ArrayList<>(n);
			}
			dfs[a].add(b);
			if (dfs[b] == null) {
				dfs[b] = new ArrayList<>(n);
			}
			dfs[b].add(a);
		}
		for (int i = 1; i <= n; ++i) {
			if (dfs[i] != null) {
				Collections.sort(dfs[i]);
				bfs[i] = new ArrayList(dfs[i]);
			}
		}
		
		// DFS
		Stack<Integer> stack = new Stack<>();
		stack.add(v);
		visit[v] = true;
		sb.append(v).append(" ");
		while (!stack.isEmpty()) {
			int node = stack.peek();
			if (dfs[node] != null) {
				if (dfs[node].isEmpty()) {
					stack.pop();
				} else {
					int i = dfs[node].remove(0);
					if (!visit[i]) {
						visit[i] = true;
						stack.add(i);
						sb.append(i).append(" ");
					}
				}
			}
		}
		sb.append("\n");
		// init
		Arrays.fill(visit, false);
		
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visit[v] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");
			if (bfs[node] != null) {
				for (Integer i: bfs[node]) {
					if (!visit[i]) {
						visit[i] = true;
						queue.add(i);
					}
				}
			}
		}
		System.out.print(sb);
		bf.close();
	}
}