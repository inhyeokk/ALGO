import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1197
 * @date   	2020-04-09
 * @author 	rkddlsgur983
 * @memory 	61284KB / 128MB
 * @time   	684ms / 2초
 * @idea	최소신장트리 - 프림
 */
public class BOJ_G4_1197_최소스패닝트리_프림 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		List<int[]>[] graph = new List[v];
		for (int i = 0; i < v; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < e; ++i) {
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
		int cnt = 0;
		int sum = 0;
		boolean[] visit = new boolean[v];
		visit[0] = true;
		while (!pq.isEmpty()) {
			int[] i = pq.poll();
			if (!visit[i[0]]) {
				visit[i[0]] = true;
				++cnt;
				sum += i[1];
				if (cnt == v-1) {
					System.out.print(sum);
					return;
				}
			}
			for (int[] j: graph[i[0]]) {
				if (!visit[j[0]])
					pq.add(j);
			}
		}
	}
}
