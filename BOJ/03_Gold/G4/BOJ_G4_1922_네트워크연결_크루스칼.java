import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1922
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	47396KB / 256MB
 * @time   	368ms / 2초
 * @idea	간선이 적으므로 크루스칼이 더 유리
 */
public class BOJ_G4_1922_네트워크연결_크루스칼 {
	private static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n];
		rank = new int[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}
		for (int i = 0; i < m; ++i) {
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
			int a = find(i[0]);
			int b = find(i[1]);
			if (a == b) {
				continue;
			}
			++cnt;
			sum += i[2];
			if (cnt == n-1) break;
			union(a, b);
		}
		System.out.print(sum);
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
		
		if (rank[pa] > rank[pb]) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
			if (rank[pa] == rank[pb]) {
				++rank[pb];
			}
		}
	}
}
