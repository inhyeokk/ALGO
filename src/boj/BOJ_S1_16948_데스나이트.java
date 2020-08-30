package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_16948_데스나이트 {
	private static final int[][] di = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		bf.close();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r1);
		queue.add(c1);
		boolean[][] visit = new boolean[n][n];
		visit[r1][c1] = true;
		int move = 0;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; i+=2) {
				int row = queue.poll();
				int col = queue.poll();
				if (row == r2 && col == c2) {
					System.out.print(move);
					return;
				}
				for (int d = 0; d < di.length; ++d) {
					int nr = row + di[d][0];
					int nc = col + di[d][1];
					if (isInRange(nr,nc,n) && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.add(nr);
						queue.add(nc);
					}
				}
			}
			++move;
		}
		System.out.print(-1);
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}
}
