package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_2589_보물섬 {
	private static int di[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] map = new char[h][w];
		for (int i = 0; i < h; ++i) {
			map[i] = bf.readLine().toCharArray();
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[][] visit = new boolean[h][w];
		int max = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < w; ++j) {
				if (map[i][j] == 'W') continue;
//				int check = 0;
//				for (int d = 0; d < di.length; ++d) {
//					int nr = i+di[d][0];
//					int nc = j+di[d][1];
//					if (isInRange(nr, nc, h, w) && map[nr][nc] == 'L') {
//						++check;
//						if (check > 1) break;
//					}
//				}
//				if (check > 1) continue;
				
				// 탐색 시작
				visit[i][j] = true;
				queue.add(i);
				queue.add(j);
				int distance = 0;
				while (!queue.isEmpty()) {
					for (int k = 0, size = queue.size(); k < size; k+=2) {
						int row = queue.poll();
						int col = queue.poll();
						for (int d = 0; d < di.length; ++d) {
							int nr = row+di[d][0];
							int nc = col+di[d][1];
							if (isInRange(nr, nc, h, w) && map[nr][nc] == 'L' && !visit[nr][nc]) {
								visit[nr][nc] = true;
								queue.add(nr);
								queue.add(nc);
							}
						}
					}
					if (!queue.isEmpty())
						++distance;
				}
				max = max < distance ? distance : max;
				for (int k = 0; k < h; ++k) {
					Arrays.fill(visit[k], false);
				}
			}
		}
		System.out.print(max);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int h, int w) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
