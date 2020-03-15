import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-15
 * @author rkddlsgur983
 * @memory 28504KB / 256MB
 * @time   201ms / 5초
 * @idea   조합과 DFS
 * 		   (0 1 2 / 3 4 5)와 (3 4 5 / 0 1 2)는 같으므로 
 * 		   0을 포함하는 조합과 0을 포함하지 않는 조합까지만 구함
 */
public class SWEA_4012_Test_요리사 {
	private static int n;
	private static int[][] map;
	private static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; ++tc) {
			n = Integer.parseInt(bf.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			dfs(1, 1, 1 << 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int depth, int start, int select) {
		
		if (depth == n/2) {
			int a = 0, b = 0;
			for (int i = 0; i < n-1; ++i) {
				for (int j = i+1; j < n; ++j) {
					if ((select & 1 << i) > 0 && (select & 1 << j) > 0) {
						a += map[i][j] + map[j][i];
					} else if ((select & 1 << i) == 0 && (select & 1 << j) == 0) {
						b += map[i][j] + map[j][i];
					}
				}
			}
			min = Math.min(Math.abs(a-b), min);
			return;
		}
		
		for (int i = start; i < n; ++i) {
			dfs(depth+1, i+1, select | 1 << i);
		}
	}
}
