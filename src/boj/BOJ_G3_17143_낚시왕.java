package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G3_17143_낚시왕 {
	private static final int[][] di = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		Shark[] sharks = new Shark[m+1]; // 1~m
		for (int i = 1; i <= m; ++i) {
			st = new StringTokenizer(bf.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (d == 1 || d == 2) {
				s %= (r-1)*2;
			} else {
				s %= (c-1)*2;
			}
			sharks[i] = new Shark(row-1, col-1, s, d, z);
			map[row-1][col-1] = i; // 상어 번호 맵에 표시;
		}
		
		int sum = 0;
		for (int i = 0; i < c; ++i) {
			for (int j = 0; j < r; ++j) {
				if (map[j][i] > 0) {
					// 상어 잡음
					sum += sharks[map[j][i]].z;
					sharks[map[j][i]] = null;
					map[j][i] = 0;
					break;
				}
			}
			// 지도에 위치 초기화
			for (int j = 1; j <= m; ++j) {
				if (sharks[j] != null) {
					Shark sh = sharks[j];
					map[sh.r][sh.c] = 0;
				}
			}
			
			for (int j = 1; j <= m; ++j) {
				if (sharks[j] != null) {
					// 상어 이동
					Shark sh = sharks[j];
					for (int ti = 0; ti < sh.s; ++ti) {
						if (sh.d == 1 && sh.r == 0) {
							sh.d = 2;
						} else if (sh.d == 2 && sh.r == r-1) {
							sh.d = 1;
						} else if (sh.d == 3 && sh.c == c-1) {
							sh.d = 4;
						} else if (sh.d == 4 && sh.c == 0) {
							sh.d = 3;
						}
						sh.r += di[sh.d][0];
						sh.c += di[sh.d][1];
					}
					if (map[sh.r][sh.c] == 0) {
						map[sh.r][sh.c] = j;
					} else {
						int jz = sh.z;
						int cz = sharks[map[sh.r][sh.c]].z;
						if (jz < cz) {
							sharks[j] = null;
						} else {
							sharks[map[sh.r][sh.c]] = null;
							map[sh.r][sh.c] = j;
						}
					}
				}
			}
		}
		System.out.print(sum);
		bf.close();
	}
	
	private static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
