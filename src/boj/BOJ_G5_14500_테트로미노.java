package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-03
 * @author rkddlsgur983
 * @memory 36772KB / 512MB
 * @time   704ms / 2초
 */
public class BOJ_G5_14500_테트로미노 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] tet = new boolean[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int[][] tmp = new int[3][2];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				tet[i][j] = true;
				int sum = map[i][j];
				/* 1. ㄴ 모양을 90도로 4번 회전시킴
				 * 2. 각 3개의 점에서 4방향으로 1칸씩 점 추가
				 * 3. 일직선 제외 4개의 테트로미노가 형성됨
				 */
				for (int d = 0; d < 4; ++d) {
					int nr = i + di[d][0];
					int nc = j + di[d][1];
					int nr2 = i + di[d+1==4?0:d+1][0];
					int nc2 = j + di[d+1==4?0:d+1][1];
					if (isInRange(nr,nc,n,m) && isInRange(nr2,nc2,n,m)) {
						tet[nr][nc] = true;
						tet[nr2][nc2] = true;
						sum += map[nr][nc] + map[nr2][nc2];
						tmp[0][0] = i;
						tmp[0][1] = j;
						tmp[1][0] = nr;
						tmp[1][1] = nc;
						tmp[2][0] = nr2;
						tmp[2][1] = nc2;
						for (int t = 0; t < 3; ++t) {
							for (int dd = 0; dd < 4; ++dd) {
								int nr3 = tmp[t][0] + di[dd][0];
								int nc3 = tmp[t][1] + di[dd][1];
								if (isInRange(nr3,nc3,n,m) && !tet[nr3][nc3]) {
									max = Math.max(sum+map[nr3][nc3], max);
								}
							}
						}
						sum =  map[i][j];
						tet[nr][nc] = false;
						tet[nr2][nc2] = false;
					}
				}
				tet[i][j] = false;
				
				// 가로/세로 일직선
				if (j+3 < m) {
					max = Math.max(map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3], max);
				}
				if (i+3 < n) {
					max = Math.max(map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j], max);
				}
			}
		}
		System.out.print(max);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
