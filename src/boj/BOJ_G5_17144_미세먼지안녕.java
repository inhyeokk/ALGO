package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_17144_미세먼지안녕 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		int cleanr = -1;
		int status = 0;
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					status += map[i][j];
				} else if (cleanr == -1 && map[i][j] == -1) {
					cleanr = i;
				} 
			}
		}
		
		int[][] tmp = new int[r][c];
		for (int time = 0; time < t; ++time) {
			for (int i = 0; i < r; ++i) {
				tmp[i] = map[i].clone();
			}
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					for (int d = 0; d < 4; ++d) {
						int nr = i + di[d][0];
						int nc = j + di[d][1];
						if (isInRange(nr,nc,r,c) && tmp[nr][nc] >= 0) {
							map[nr][nc] += (tmp[i][j] / 5);
							map[i][j] -= (tmp[i][j] / 5);
						}
					}
				}
			}
			// 공기청정기 위쪽 순환
			status -= map[cleanr-1][0];
			for (int i = cleanr-1; i > 0; --i) {
				map[i][0] = map[i-1][0];
			}
			for (int i = 0; i < c-1; ++i) {
				map[0][i] = map[0][i+1];
			}
			for (int i = 0; i < cleanr; ++i) {
				map[i][c-1] = map[i+1][c-1];
			}
			for (int i = c-1; i > 1; --i) {
				map[cleanr][i] = map[cleanr][i-1];
			}
			map[cleanr][1] = 0;
			
			// 아래쪽 공기 순환
			status -= map[cleanr+2][0];
			for (int i = cleanr+2; i < r-1; ++i) {
				map[i][0] = map[i+1][0];
			}
			for (int i = 0; i < c-1; ++i) {
				map[r-1][i] = map[r-1][i+1];
			}
			for (int i = r-1; i > cleanr; --i) {
				map[i][c-1] = map[i-1][c-1];
			}
			for (int i = c-1; i > 1; --i) {
				map[cleanr+1][i] = map[cleanr+1][i-1];
			}
			map[cleanr+1][1] = 0;
		}
		System.out.println(status);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int r, int c) {
		return row >= 0 && row < r && col >= 0 && col < c;
	}
}
