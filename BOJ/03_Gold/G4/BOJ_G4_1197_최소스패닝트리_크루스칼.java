import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1197
 * @date   	2020-04-09
 * @author 	rkddlsgur983
 * @memory 	52784KB / 128MB
 * @time   	528ms / 2초
 * @idea		최소신장트리 - 크루스칼
 *		싸이클이 생기지 않으면서 최소신장을 갖는 트리
 *		Union-find, 우선순위 큐, 정수 범위
 */
public class BOJ_G4_1197_최소스패닝트리_크루스칼 {
	private static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v];
		rank = new int[v];
		for (int i = 0; i < v; ++i) {
			parent[i] = i;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a,b,c});
		}
		br.close();
		
		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			int[] i = pq.poll();
			int pa = find(i[0]);
			int pb = find(i[1]);
			if (pa == pb) continue; // 부모가 같은 경우 통과
			++cnt;
			sum += i[2];
			if (cnt == v-1) {
				System.out.print(sum);
				return;
			}
			union(pa,pb);
		}
	}
	
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		/* rank가 더 작은 신장트리의 루트를 변경하는 것이
		 * 큰 신장트리를 변경하는 것보다 효율이 좋음
		 */
		if (rank[pa] > rank[pb]) { // 높을수록 부모
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
			if (rank[pa] == rank[pb]) {
				++rank[pb];
			}
		}
	}
}
