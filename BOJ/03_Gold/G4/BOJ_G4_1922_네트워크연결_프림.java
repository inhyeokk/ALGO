import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1922
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	52916KB / 256MB
 * @time   	908ms / 2초
 * @idea	간선이 적으므로 크루스칼이 더 유리
 */
public class BOJ_G4_1922_네트워크연결_프림 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<int[]>[] graph = new List[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		br.close();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		for (int[] i: graph[0]) {
			pq.add(i);
		}
		
		boolean[] visit = new boolean[n];
		visit[0] = true;
		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			int[] i = pq.poll();
			if (!visit[i[0]]) {
				visit[i[0]] = true;
				++cnt;
				sum += i[1];
				if (cnt == n-1) {
					System.out.print(sum);
					return;
				}
				for (int[] j: graph[i[0]]) {
					if (!visit[j[0]]) {
						pq.add(j);
					}
				}
			}
		}
	}
}
