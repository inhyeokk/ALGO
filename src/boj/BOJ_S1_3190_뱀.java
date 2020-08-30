package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_S1_3190_뱀 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		int[][] map = new int[n+1][n+1];
		StringTokenizer st;
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 2;
		}
		int l = Integer.parseInt(bf.readLine());
		int[] xrr = new int[l];
		char[] crr = new char[l];
		for (int i = 0; i < l; ++i) {
			st = new StringTokenizer(bf.readLine());
			xrr[i] = Integer.parseInt(st.nextToken());
			crr[i] = st.nextToken().charAt(0);
		}
		
		int time = 0, d = 0;
		int idx = 0;
		int sr = 1, sc = 1;
		LinkedList<Snake> list = new LinkedList<>();
		map[1][1] = 1; // 뱀 시작
		list.add(new Snake(1,1));
		while (true) {
			sr += di[d][0];
			sc += di[d][1];
			if (!isInRange(sr,sc,n) || map[sr][sc] == 1) {
				break;
			} else if (map[sr][sc] == 2) {
				map[sr][sc] = 1;
				list.addFirst(new Snake(sr,sc));
			} else {
				map[sr][sc] = 1;
				list.addFirst(new Snake(sr,sc));
				Snake sn = list.removeLast();
				map[sn.row][sn.col] = 0;
			}
			++time;
			if (idx < l && time == xrr[idx]) {
				if (crr[idx] == 'L') {
					d -= 1;
					if (d == -1) d = 3;
				} else if (crr[idx] == 'D') {
					d += 1;
					if (d == 4) d = 0;
				}
				++idx;
			}
		}
		System.out.print(time+1);
		bf.close();
	}
	
	static class Snake {
		int row;
		int col;
		public Snake(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 1 && row <= n && col >= 1 && col <= n;
	}
}
