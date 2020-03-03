import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-03
 * @author rkddlsgur983
 * @memory 28852KB / 262144KB
 * @time   14006ms / 14초
 */
public class SWEA_9282_D4_초콜릿과건포도 {
	private static int n, m;
	private static int[][] map = new int[50][50];
	private static boolean[][] rowVisit = new boolean[50][49];
	private static boolean[][] colVisit = new boolean[49][50];
	private static int min;
	private static int end;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int k = 0; k < m; ++k) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			end = (n-1)*m + n*(m-1);
			dfs(0, 0);
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int grape, int depth) {
		
		if (min <= grape) {
			return;
		} else if (depth == end)  {
			min = grape;
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (i+1<n && !colVisit[i][j]) {
					int left = 0;
					for (int k = i; k >= 0; --k) {
						if (colVisit[k][j]) break;
						left += map[k][j];
					}
					int right = 0;
					for (int k = i+1; k < n; ++k) {
						right += map[k][j];
						if (colVisit[k][j]) break;
					}
					colVisit[i][j] = true;
					dfs(grape + left+right, depth+1);
					colVisit[i][j] = false;
				}
				if (j+1<m && !rowVisit[i][j]) {
					int left = 0;
					for (int k = j; k >= 0; --k) {
						if (rowVisit[i][k]) break;
						left += map[i][k];
					}
					int right = 0;
					for (int k = j+1; k < m; ++k) {
						right += map[i][k];
						if (rowVisit[i][k]) break;
					}
					rowVisit[i][j] = true;
					dfs(grape + left+right, depth+1);
					rowVisit[i][j] = false;
				}
			}
		}
	}
}
