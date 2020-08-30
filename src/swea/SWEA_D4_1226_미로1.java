package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_D4_1226_미로1 {
	
	private static final int N = 16;
	private static final char[][] map = new char[N][N];
	private static final Pair start = new Pair(0, 0);
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int t = scan.nextInt();
			sb.append("#").append(t).append(" ");
			for (int j = 0; j < N; j++) {
				map[j] = scan.next().toCharArray();
			}
			here: for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] == '2') {
						start.row = j;
						start.col = k;
						break here;
					}
				}
			}
			
			Queue<Pair> queue = new LinkedList<Pair>();
			queue.offer(start);
			int possible = 0;
			while (!queue.isEmpty()) {
				Pair p = queue.poll();
				for (int d = 0; d < di.length; d++) {
					int nr = p.row + di[d][0];
					int nc = p.col + di[d][1];
					if (map[nr][nc] == '3') {
						possible = 1;
						queue.clear();
						break;
					} else if (map[nr][nc] == '0') {
						queue.offer(new Pair(nr, nc));
						map[nr][nc] = '4';
					}
				}
			}
			sb.append(possible).append("\n");
		}
		System.out.println(sb);
		scan.close();
	}
	
	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
