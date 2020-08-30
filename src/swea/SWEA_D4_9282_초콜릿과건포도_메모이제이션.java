package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   2020-03-04
 * @author rkddlsgur983
 * @memory 127004KB / 262144KB
 * @time   3063ms / 14초
 */
public class SWEA_D4_9282_초콜릿과건포도_메모이제이션 {
	private static int n, m;
	private static final int[][] map = new int[50][50];
	private static int[][][][] dp;
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
			dp = new int[n+1][m+1][n+1][m+1];
			for (int[][][] d1: dp) {
				for (int[][] d2: d1) {
					for (int[] d3: d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			int result = dfs(0, 0, n, m);
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	// 피보나치 형태의 재귀호출
	private static int dfs(int row, int col, int h, int w) {
		
		// 더이상 나눠지지 않으면
		if (h == 1 && w == 1) {
			return 0;
		}
		
		// 초기 큰 초콜릿에 있던 건포도 개수
		int sum = 0;
		for (int i = row; i < row+h; ++i) {
			for (int j = col; j < col+w; ++j) {
				sum += map[i][j];
			}
		}
		
		// 가로로 나누었을 때 최소비용
		for (int i = 1; i < h; ++i) {
			// 위쪽 비용
			if (dp[row][col][i][w] == Integer.MAX_VALUE) {
				dp[row][col][i][w] = dfs(row, col, i, w); // 각 조각에 대해 메모이제이션
			}
			// 아래쪽 비용
			if (dp[row+i][col][h-i][w] == Integer.MAX_VALUE) {
				dp[row+i][col][h-i][w] = dfs(row+i, col, h-i, w);
			}
			dp[row][col][h][w] = Math.min(dp[row][col][h][w], sum+dp[row][col][i][w]+dp[row+i][col][h-i][w]);
		}
		// 세로로 나누었을 때 최소비용
		for (int i = 1; i < w; ++i) {
			// 왼쪽 비용
			if (dp[row][col][h][i] == Integer.MAX_VALUE) {
				dp[row][col][h][i] = dfs(row, col, h, i);
			}
			// 오른쪽 비용
			if (dp[row][col+i][h][w-i] == Integer.MAX_VALUE) {
				dp[row][col+i][h][w-i] = dfs(row, col+i, h, w-i);
			}
			dp[row][col][h][w] = Math.min(dp[row][col][h][w], sum+dp[row][col][h][i]+dp[row][col+i][h][w-i]);
		}
		return dp[row][col][h][w];
	}
}
