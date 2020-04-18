package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/2636
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 14064KB /128MB
 * @time   96ms / 1초
 */
public class BOJ_G5_2636_치즈 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int h, w;
	private static boolean[][] map;
	private static boolean[][] visit;
	private static Queue<Integer> air = new LinkedList<>();
	private static Queue<Integer> melt = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new boolean[h][w];
		visit = new boolean[h][w];
		int cheese = 0;
		for (int i = 0; i < h; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < w; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
				cheese += map[i][j] ? 1 : 0;
			}
		}
		
		// 판의 가장자리로부터 공기가 퍼지고 녹기전 치즈 추가
		for (int i = 0; i < h; ++i) {
			if (!map[i][0] && !visit[i][0]) {
				visit[i][0] = true;
				air.add(i);
				air.add(0);
				spread();
			}
			if (!map[i][w-1] && !visit[i][w-1]) {
				visit[i][w-1] = true;
				air.add(i);
				air.add(w-1);
				spread();
			}
		}
		for (int i = 0; i < w; ++i) {
			if (!map[0][i] && !visit[0][i]) {
				visit[0][i] = true;
				air.add(0);
				air.add(i);
				spread();
			}
			if (!map[h-1][i] && !visit[h-1][i]) {
				visit[h-1][i] = true;
				air.add(h-1);
				air.add(i);
				spread();
			}
		}
		
		int time = 0;
		int before = 0;
		while (!melt.isEmpty()) {
			before = cheese;
			int size = melt.size();
			for (int i = 0; i < size; i+=2) {
				int r = melt.poll();
				int c = melt.poll();
				map[r][c] = false;
				air.add(r);
				air.add(c);
				spread();
			}
			cheese -= size/2;
			++time;
		}
		System.out.printf("%d\n%d", time, before);
		bf.close();
	}
	
	/* 빈공간을 만나면 공기가 퍼지고
	 * 치즈를 만나면 녹기전 치즈 melt에 추가
	 */
	private static void spread() {
		while (!air.isEmpty()) {
			int r = air.poll();
			int c = air.poll();
			for (int d = 0; d < 4; ++d) {
				int nr = r + di[d][0];
				int nc = c + di[d][1];
				if (isInRange(nr,nc,h,w) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					if (!map[nr][nc]) {
						air.add(nr);
						air.add(nc);
					} else {
						melt.add(nr);
						melt.add(nc);
					}
				}
			}
		}
	}
	
	private static boolean isInRange(int row, int col, int h, int w) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
