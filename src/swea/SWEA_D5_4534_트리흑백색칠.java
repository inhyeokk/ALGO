package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory KB / 262144KB
 * @time   ms / 10초
 */
public class SWEA_D5_4534_트리흑백색칠 {
	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] adj;
	static long[][] memo; // 색상, 정점 번호
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			N = Integer.parseInt(bf.readLine());
			adj = new LinkedList[N+1];
			for (int j = 1; j < N+1; ++j) {
				adj[j] = new LinkedList<>();
			}
			memo = new long[2][N+1];
			for (int j = 1; j < N; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			long ans = (dfs(1,0,-1) + dfs(1,1,-1)) % MOD;
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static long dfs(int v, int color, int parent) {
		// memo[color][v] 값이 존재한다면, 다시 계산하지 않고, 알고 있던 값 리턴
		if (memo[color][v] != 0)
			return memo[color][v];
		
		long ret = 1;
		/* color가 흑(0)인 경우
		 * 자식 노드들을 백(1)으로 칠한 경우의 경우의 수들의 곱
		 */
		if (color == 0) {
			for (Integer i: adj[v]) {
				if (i != parent) {
					ret *= dfs(i, 1, v);
					ret %= MOD;
				}
			}
		}
		
		/* color가 백(1)인 경우
		 * 자식 노드들을 흑(1)으로 칠한 경우의 경우의 수들의 곱
		 * +
		 * 자식 노드들을 백(0)으로 칠한 경우의 경우의 수들의 곱
		 */ 
		else {
			for (Integer i: adj[v]) {
				if (i != parent) {
					ret *= dfs(i, 1, v) + dfs(i, 0, v);
					ret %= MOD;
				}
			}
		}
		
		// memo[color][v]에 기록
		memo[color][v] = ret;
		return ret;
	}
}
