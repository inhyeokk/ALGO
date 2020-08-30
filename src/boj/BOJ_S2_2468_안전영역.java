package boj;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_2468_안전영역 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = min > map[i][j] ? map[i][j] : min;
				max = max < map[i][j] ? map[i][j] : max;
			}
		}
		
		int ans = 1;
		for (int depth = min; depth <= max; ++depth) {
			int area = 0;
			for (int i = 0; i < n; ++i) {
				Arrays.fill(visit[i], false);
			}
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (!visit[i][j] && map[i][j] > depth) {
						++area;
						visit[i][j] = true;
						dfs(i, j, depth);
					}
				}
			}
			ans = ans < area ? area : ans;
		}
		System.out.println(ans);
//		System.out.print(bfs());
		bf.close();
	}
	
	private static void dfs(int row, int col, int depth) {
		for (int d = 0; d < di.length; ++d) {
			int nr = row + di[d][0];
			int nc = col + di[d][1];
			if (isInRange(nr,nc,n) && !visit[nr][nc] && map[nr][nc] > depth) {
				visit[nr][nc] = true;
				dfs(nr, nc, depth);
			}
		}
	}
	
	private static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int ans = 1;
		for (int depth = min; depth <= max; ++depth) {
			int area = 0;
			for (int i = 0; i < n; ++i) {
				Arrays.fill(visit[i], false);
			}
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (!visit[i][j] && map[i][j] > depth) {
						visit[i][j] = true;
						queue.add(i);
						queue.add(j);
						++area;
						while (!queue.isEmpty()) {
							int row = queue.poll();
							int col = queue.poll();
							for (int d = 0; d < di.length; ++d) {
								int nr = row + di[d][0];
								int nc = col + di[d][1];
								if (isInRange(nr,nc,n) && !visit[nr][nc] && map[nr][nc] > depth) {
									visit[nr][nc] = true;
									queue.add(nr);
									queue.add(nc);
								}
							}
						}
					}
				}
			}
			ans = ans < area ? area : ans;
		}
		return ans;
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}
}
