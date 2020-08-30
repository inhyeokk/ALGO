package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-29
 * @author 	rkddlsgur983
 * @memory 	36064KB / 256MB
 * @time   	155ms / 2초
 * @idea	시뮬레이션
 */
public class SWEA_D4_6109_추억의2048게임 {
	private static int n;
	private static final int[][] map = new int[20][20];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move(s);
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void move(String s) {
		if ("left".equals(s)) {
			for (int i = 0; i < n; ++i) {
				// 왼쪽으로 밀착
				int cnt = 0; // 0이 아닌 블록의 수
				for (int j = 0; j < n; ++j) {
					if (map[i][j] > 0) {
						int tmp = map[i][j];
						map[i][j] = 0;
						map[i][cnt++] = tmp;
					}
				}
				// 같으면 더함
				int acnt = 0; // 더해진 블록 수
				for (int j = 0; j < cnt; ++j) {
					int tmp = 0;
					if (j+1 < n && map[i][j] == map[i][j+1]) {
						tmp = map[i][j]*2;
						map[i][j] = 0;
						map[i][++j] = 0; // j 한칸 건너 뜀
						map[i][acnt++] = tmp;
					} else {
						tmp = map[i][j];
						map[i][j] = 0;
						map[i][acnt++] = tmp;
					}
				}
			}
		} else if ("right".equals(s)) {
			for (int i = 0; i < n; ++i) {
				// 오른쪽으로 밀착
				int cnt = 0; // 0이 아닌 블록의 수
				for (int j = n-1; j >= 0; --j) {
					if (map[i][j] > 0) {
						int tmp = map[i][j];
						map[i][j] = 0;
						map[i][n-1-(cnt++)] = tmp;
					}
				}
				// 같으면 더함
				int acnt = 0; // 더해진 블록 수
				for (int j = n-1; j >= n-cnt; --j) {
					int tmp = 0;
					if (j-1 >= 0 && map[i][j] == map[i][j-1]) {
						tmp = map[i][j]*2;
						map[i][j] = 0;
						map[i][--j] = 0; // j 한칸 건너 뜀
						map[i][n-1-(acnt++)] = tmp;
					} else {
						tmp = map[i][j];
						map[i][j] = 0;
						map[i][n-1-(acnt++)] = tmp;
					}
				}
			}
		} else if ("up".equals(s)) {
			for (int i = 0; i < n; ++i) {
				// 위쪽으로 밀착
				int cnt = 0; // 0이 아닌 블록의 수
				for (int j = 0; j < n; ++j) {
					if (map[j][i] > 0) {
						int tmp = map[j][i];
						map[j][i] = 0;
						map[cnt++][i] = tmp;
					}
				}
				// 같으면 더함
				int acnt = 0; // 더해진 블록 수
				for (int j = 0; j < cnt; ++j) {
					int tmp = 0;
					if (j+1 < n && map[j][i] == map[j+1][i]) {
						tmp = map[j][i]*2;
						map[j][i] = 0;
						map[++j][i] = 0; // j 한칸 건너 뜀
						map[acnt++][i] = tmp;
					} else {
						tmp = map[j][i];
						map[j][i] = 0;
						map[acnt++][i] = tmp;
					}
				}
			}
		} else {
			for (int i = 0; i < n; ++i) {
				// 아래쪽으로 밀착
				int cnt = 0; // 0이 아닌 블록의 수
				for (int j = n-1; j >= 0; --j) {
					if (map[j][i] > 0) {
						int tmp = map[j][i];
						map[j][i] = 0;
						map[n-1-(cnt++)][i] = tmp;
					}
				}
				// 같으면 더함
				int acnt = 0; // 더해진 블록 수
				for (int j = n-1; j >= n-cnt; --j) {
					int tmp = 0;
					if (j-1 >= 0 && map[j][i] == map[j-1][i]) {
						tmp = map[j][i]*2;
						map[j][i] = 0;
						map[--j][i] = 0; // j 한칸 건너 뜀
						map[n-1-(acnt++)][i] = tmp;
					} else {
						tmp = map[j][i];
						map[j][i] = 0;
						map[n-1-(acnt++)][i] = tmp;
					}
				}
			}
		}
	}
}
