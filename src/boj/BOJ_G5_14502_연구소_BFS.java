package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/14502
 * @author rkddlsgur983
 * @memory 282984KB
 * @time   1000ms
 */
public class BOJ_G5_14502_연구소_BFS {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n, m;
	private static int[][] map;
	private static Queue<Integer> start;
	private static int safe = 0;
	private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		start = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					start.add(i);
					start.add(j);
				} else if (map[i][j] == 0) {
					++safe;
				}
			}
		}
		buildWall(0);
		System.out.print(max);
		bf.close();
	}
	
	private static void buildWall(int wall) {
		
		if (wall == 3) {
			int[][] tmap = new int[n][m];
			for (int i = 0; i < n; ++i) {
				tmap[i] = map[i].clone();
			}
			Queue<Integer> queue = new LinkedList<>(start);
			int tmp = safe-3; // 벽 3개 세움
			while (!queue.isEmpty()) {
				int row = queue.poll();
				int col = queue.poll();
				for (int d = 0; d < di.length; ++d) {
					int nr = row + di[d][0];
					int nc = col + di[d][1];
					if (isInRange(nr,nc,n,m) && tmap[nr][nc] == 0) {
						tmap[nr][nc] = 2;
						queue.add(nr);
						queue.add(nc);
						--tmp;
					}
				}
			}
			max = max < tmp ? tmp : max;
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					buildWall(wall+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
