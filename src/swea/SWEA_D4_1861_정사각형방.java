package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1861_정사각형방 {
	private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static final int[][] map = new int[1000][1000];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < n; ++k) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int idx = n*n;
			int max = 0;
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					int cnt = 1;
					int row = j, col = k;
					while (true) {
						boolean possible = false;
						int origin = map[row][col];
						for (int d = 0; d < 4; ++d) {
							int nr = row + di[d][0];
							int nc = col + di[d][1];
							if (isInRange(nr, nc, n) && origin+1 == map[nr][nc]) {
								row = nr;
								col = nc;
								cnt++;
								possible = true;
								break;
							}
						}
						if (!possible) break;
					}
					if (max < cnt) {
						max = cnt;
						idx = map[j][k];
					} else if (max == cnt && idx > map[j][k]) {
						idx = map[j][k];
					}
				}
			}
			sb.append("#").append(i).append(" ")
			.append(idx).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}
}
