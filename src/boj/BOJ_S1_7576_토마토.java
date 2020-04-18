package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_7576_토마토 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int tomato = 0; // 익은 토마토
		int total = n*m; // 익을 수 있는 토마토
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					++tomato;
					queue.add(i);
					queue.add(j);
				} else if (map[i][j] == -1) {
					--total;
				}
			}
		}
		
		int day = 1;
		while (!queue.isEmpty()) {
			int row = queue.poll();
			int col = queue.poll();
			for (int d = 0; d < 4; ++d) {
				int nr = row + di[d][0];
				int nc = col + di[d][1];
				if (isInRange(nr, nc, n, m) && map[nr][nc] == 0) {
					++tomato;
					map[nr][nc] = map[row][col]+1;
					day = day < map[nr][nc] ? map[nr][nc] : day;
					queue.add(nr);
					queue.add(nc);
				}
			}
		}
		day -= 1; // 시작이 1이있기 때문에 빼줌
		if (tomato < total) {
			day = -1;
		}
		System.out.print(day);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int h, int w) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
