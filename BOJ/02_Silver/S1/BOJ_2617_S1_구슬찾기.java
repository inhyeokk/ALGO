import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2617_S1_구슬찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n][n];
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b] = 1; // a가 b보다 무겁다.
			graph[b][a] = -1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(visit, false);
			visit[i] = true;
			queue.add(i);
			while (!queue.isEmpty()) {
				int h = queue.poll();
				for (int j = 0; j < n; ++j) {
					if (!visit[j] && graph[h][j] == 1) {
						visit[j] = true;
						graph[i][j] = 1;
						graph[j][i] = -1;
						queue.add(j);
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			int heavy = 0;
			int light = 0;
			for (int j = 0; j < n; ++j) {
				if (graph[i][j] == 1) {
					++heavy;
				} else if (graph[i][j] == -1) {
					++light;
				}
			}
			if (heavy >= (n+1)/2 || light >= (n+1)/2) {
				++cnt;
			}
		}
		System.out.print(cnt);
		bf.close();
	}
}
