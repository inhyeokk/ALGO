package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1873_상호의배틀필드 {
	private static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(bf.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			int row=0, col=0, di=0;
			for (int j = 0; j < h; j++) {
				map[j] = bf.readLine().toCharArray();
				for (int k = 0; k < w; k++) {
					switch (map[j][k]) {
						case '>':
							row = j;
							col = k;
							di = 0;
							break;
						case 'v':
							row = j;
							col = k;
							di = 1;
							break;
						case '<':
							row = j;
							col = k;
							di = 2;
							break;
						case '^':
							row = j;
							col = k;
							di = 3;
							break;
					}
				}
			}
			int n = Integer.parseInt(bf.readLine());
			char[] command = bf.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				switch(command[j]) {
					case 'U':
						di = 3;
						if (row-1 >= 0 && map[row-1][col] == '.') {
							map[row--][col] = '.';
						}
						map[row][col] = '^';
						break;
					case 'D':
						di = 1;
						if (row+1 < h && map[row+1][col] == '.') {
							map[row++][col] = '.';
						}
						map[row][col] = 'v';
						break;
					case 'L':
						di = 2;
						if (col-1 >= 0 && map[row][col-1] == '.') {
							map[row][col--] = '.';
						}
						map[row][col] = '<';
						break;
					case 'R':
						di = 0;
						if (col+1 < w && map[row][col+1] == '.') {
							map[row][col++] = '.';
						}
						map[row][col] = '>';
						break;
					case 'S':
						int nr = row+dir[di][0];
						int nc = col+dir[di][1];
						while (isInRange(nr, nc, h, w)) {
							if (map[nr][nc] == '#') {
								break;
							} else if (map[nr][nc] == '*') {
								map[nr][nc] = '.';
								break;
							}
							nr += dir[di][0];
							nc += dir[di][1];
						}
						break;
				}
			}
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < h; j++) {
				sb.append(map[j]).append("\n");
			}
		}
		System.out.println(sb);
		bf.close();
	}
	private static boolean isInRange(int row, int col, int h, int w) {
		return row >= 0 && row < h && col >= 0 && col < w;
	}
}
