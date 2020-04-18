package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_G4_4485_녹색옷입은애가젤다지 {
	private static int N = 125;
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		int[][] map = new int[N][N];
		int[][] weight = new int[N][N];
		int n, cnt = 1;
		do {
			n = sc.nextInt();
			if (n == 0) break;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					map[i][j] = sc.nextInt();
					weight[i][j] = -1;
				}
			}
			queue.add(0); // row
			queue.add(0); // col
			weight[0][0] = map[0][0];
			int min = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				int row = queue.poll();
				int col = queue.poll();
				int wei = weight[row][col];
				if (row == n-1 && col == n-1) {
					min = min > wei ? wei : min;
					continue;
				}
				for (int d = 0; d < 4; ++d) {
					int nr = row + di[d][0];
					int nc = col + di[d][1];
					if (isInRange(nr,nc,n) 
							&& (weight[nr][nc] == -1 
							|| weight[nr][nc] > wei + map[nr][nc])) {
						weight[nr][nc] = wei+map[nr][nc];
						queue.add(nr);
						queue.add(nc);
					}
				}
			}
			sb.append("Problem ").append(cnt++).append(": ").append(min).append("\n");
		} while (n > 0);
		System.out.print(sb);
		sc.close();
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}
}
