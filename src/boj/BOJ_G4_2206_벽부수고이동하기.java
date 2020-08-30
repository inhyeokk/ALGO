package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory 196072KB / 192MB
 * @time   644ms / 2초
 */
public class BOJ_G4_2206_벽부수고이동하기 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n, m;
	private static boolean[][] map;
	private static int[][] visit; // 벽을 부수고 지나왔는지 체크
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; ++i) {
			String s = bf.readLine();
			for (int j = 0, len = s.length(); j < len; ++j) {
				map[i][j] = s.charAt(j) == '1';
				visit[i][j] = Integer.MAX_VALUE; // 방문하지 않음
			}
		}
		bf.close();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0); // row
		queue.add(0); // col
		queue.add(1); // move;
		visit[0][0] = 0;
		while (!queue.isEmpty()) {
			int row = queue.poll();
			int col = queue.poll();
			int move = queue.poll();
			if (row == n-1 && col == m-1) {
				System.out.println(move);
				return;
			}
			for (int d = 0; d < di.length; ++d) {
				int nr = row + di[d][0];
				int nc = col + di[d][1];
				if(isInRange(nr,nc)) {
					/* 벽을 부수고 지나왔을 경우 또 다른 벽을 만난다면 지나가지 못할 수 있음 
					 * 벽을 안부수고 지나왔을 경우 끝까지 갈 수 있는 확률이 더 높음
					 * 1. 현재 벽을 부수고 지나왔을 경우(1) 이전에 방문하지 않았을 때만 탐색
					 * 2. 벽을 안부수고 지나왔다면(0) 이전 방문 값이 벽을 부쉈거나(1), 방문하지 않았을 때 탐색
					 */
					if (visit[nr][nc] <= visit[row][col]) continue;
					if (!map[nr][nc]) {
						visit[nr][nc] = visit[row][col];
						queue.add(nr);
						queue.add(nc);
						queue.add(move+1);
					} else if (map[nr][nc] && visit[row][col] == 0) {
						visit[nr][nc] = 1;
						queue.add(nr);
						queue.add(nc);
						queue.add(move+1);
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
