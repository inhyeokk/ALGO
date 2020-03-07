import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/2606
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 13144KB / 128MB
 * @time   84ms / 1초
 */
public class BOJ_2606_S2_바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		List<Integer>[] graph = new LinkedList[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 단순 BFS 탐색
		int ans = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n];
		visit[0] = true;
		queue.add(0);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for (Integer i: graph[v]) {
				if (!visit[i]) {
					visit[i] = true;
					queue.add(i);
					++ans;
				}
			}
		}
		System.out.print(ans);
		bf.close();
	}
}
