import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/12100
 * @author rkddlsgur983
 * @memory 21108KB
 * @time   192ms
 */
public class BOJ_12100_G2_2048Easy {
	private static int n;
	private static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(0, map);
		System.out.print(max);
		bf.close();
	}
	
	private static void move(int count, int[][] map) {
		if (count == 5) {
			return;
		}
		int[][] tmap = new int[n][n];
		for (int i = 0; i < n; ++i) {
			tmap[i] = map[i].clone();
		}
		// 왼쪽
		for (int i = 0; i < n; ++i) {
			// 왼쪽으로 밀착
			int cnt = 0; // 0이 아닌 블록의 수
			for (int j = 0; j < n; ++j) {
				if (tmap[i][j] > 0) {
					int tmp = tmap[i][j];
					tmap[i][j] = 0;
					tmap[i][cnt++] = tmp;
				}
			}
			// 같으면 더함
			int acnt = 0; // 더해진 블록 수
			for (int j = 0; j < cnt; ++j) {
				int tmp = 0;
				if (j+1 < n && tmap[i][j] == tmap[i][j+1]) {
					tmp = tmap[i][j]*2;
					tmap[i][j] = 0;
					tmap[i][++j] = 0; // j 한칸 건너 뜀
					tmap[i][acnt++] = tmp;
				} else {
					tmp = tmap[i][j];
					tmap[i][j] = 0;
					tmap[i][acnt++] = tmp;
				}
				max = Math.max(tmp, max);
			}
		}
		move(count+1, tmap);

		for (int i = 0; i < n; ++i) {
			tmap[i] = map[i].clone();
		}
		// 오른쪽
		for (int i = 0; i < n; ++i) {
			// 오른쪽으로 밀착
			int cnt = 0; // 0이 아닌 블록의 수
			for (int j = n-1; j >= 0; --j) {
				if (tmap[i][j] > 0) {
					int tmp = tmap[i][j];
					tmap[i][j] = 0;
					tmap[i][n-1-(cnt++)] = tmp;
				}
			}
			// 같으면 더함
			int acnt = 0; // 더해진 블록 수
			for (int j = n-1; j >= n-cnt; --j) {
				int tmp = 0;
				if (j-1 >= 0 && tmap[i][j] == tmap[i][j-1]) {
					tmp = tmap[i][j]*2;
					tmap[i][j] = 0;
					tmap[i][--j] = 0; // j 한칸 건너 뜀
					tmap[i][n-1-(acnt++)] = tmp;
				} else {
					tmp = tmap[i][j];
					tmap[i][j] = 0;
					tmap[i][n-1-(acnt++)] = tmp;
				}
				max = Math.max(tmp, max);
			}
		}
		move(count+1, tmap);

		for (int i = 0; i < n; ++i) {
			tmap[i] = map[i].clone();
		}
		// 위쪽
		for (int i = 0; i < n; ++i) {
			// 위쪽으로 밀착
			int cnt = 0; // 0이 아닌 블록의 수
			for (int j = 0; j < n; ++j) {
				if (tmap[j][i] > 0) {
					int tmp = tmap[j][i];
					tmap[j][i] = 0;
					tmap[cnt++][i] = tmp;
				}
			}
			// 같으면 더함
			int acnt = 0; // 더해진 블록 수
			for (int j = 0; j < cnt; ++j) {
				int tmp = 0;
				if (j+1 < n && tmap[j][i] == tmap[j+1][i]) {
					tmp = tmap[j][i]*2;
					tmap[j][i] = 0;
					tmap[++j][i] = 0; // j 한칸 건너 뜀
					tmap[acnt++][i] = tmp;
				} else {
					tmp = tmap[j][i];
					tmap[j][i] = 0;
					tmap[acnt++][i] = tmp;
				}
				max = Math.max(tmp, max);
			}
		}
		move(count+1, tmap);
		
		for (int i = 0; i < n; ++i) {
			tmap[i] = map[i].clone();
		}
		// 아래쪽
		for (int i = 0; i < n; ++i) {
			// 아래쪽으로 밀착
			int cnt = 0; // 0이 아닌 블록의 수
			for (int j = n-1; j >= 0; --j) {
				if (tmap[j][i] > 0) {
					int tmp = tmap[j][i];
					tmap[j][i] = 0;
					tmap[n-1-(cnt++)][i] = tmp;
				}
			}
			// 같으면 더함
			int acnt = 0; // 더해진 블록 수
			for (int j = n-1; j >= n-cnt; --j) {
				int tmp = 0;
				if (j-1 >= 0 && tmap[j][i] == tmap[j-1][i]) {
					tmp = tmap[j][i]*2;
					tmap[j][i] = 0;
					tmap[--j][i] = 0; // j 한칸 건너 뜀
					tmap[n-1-(acnt++)][i] = tmp;
				} else {
					tmp = tmap[j][i];
					tmap[j][i] = 0;
					tmap[n-1-(acnt++)][i] = tmp;
				}
				max = Math.max(tmp, max);
			}
		}
		move(count+1, tmap);
	}
}
