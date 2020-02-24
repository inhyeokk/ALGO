import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17135_캐슬디펜스 {
	private static int[][] map;
	private static int[][] tmp;
	private static int[][] target;
	private static int max = 0;
	private static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		tmp = new int[n][m];
		target = new int[3][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt += map[i][j];
			}
		}
		combination(0, 0, n, m, d);
		System.out.print(max);
		bf.close();
	}
	
	private static void combination(int depth, int idx, int n, int m, int d) {
		if (depth == 3) {
			// game
			for (int i = 0; i < n; ++i) {
				tmp[i] = Arrays.copyOf(map[i], m);
			}
			for (int i = 0; i < 3; ++i) {
				target[i][0] = -1; // 초기화
				target[i][1] = -1;
			}
			
			int tcnt = cnt, kill = 0;
			while (tcnt > 0) {
				int bi = 0; // 궁수 타겟 배열 인덱스
				for (int i = 0; i < m; ++i) {
					if (map[n][i] == 2) {
						int level = 1;
						int sr = n;
						int sc = i;
						boolean find = false;
						// 범위 늘여가면서 찾음
						while (level <= d) {
							for (int j = 1; j <= level; ++j) {
								int nr = sr - j;
								int nc = sc - (level-j);
								if (isInRange(nr,nc,n,m) && tmp[nr][nc] == 1) {
									target[bi][0] = nr;
									target[bi][1] = nc;
									find = true;
									++bi;
									break;
								}
							}
							if (find) break;
							for (int j = level-1; j >= 1; --j) {
								int nr = sr - j;
								int nc = sc + (level-j);
								if (isInRange(nr,nc,n,m) && tmp[nr][nc] == 1) {
									target[bi][0] = nr;
									target[bi][1] = nc;
									find = true;
									++bi;
									break;
								}
							}
							if (find) break;
							++level;
						}
					}
				}
				
				// 궁수가 활을 쏨
				for (int i = 0; i < 3; ++i) {
					int row = target[i][0];
					int col = target[i][1];
					if (row == -1 || col == -1) continue;
					if (tmp[row][col] == 1) {
						tmp[row][col] = 0;
						++kill;
						--tcnt;
					}
					target[i][0] = -1; // 초기화
					target[i][1] = -1;
				}
				if (tcnt <= 0) break;
				// 남은 적들 이동
				for (int i = 0; i < m; ++i) {
					if (tmp[n-1][i] == 1) {
						--tcnt; // 마지막 줄 적 제외
					}
				}
				for (int i = n-2; i >= 0; --i) {
					tmp[i+1] = Arrays.copyOf(tmp[i], m);
				}
				for (int i = 0; i < m; ++i) {
					tmp[0][i] = 0;
				}
			}
			max = max < kill ? kill : max;
			return;
		}
		
		for (int i = idx; i < m; ++i) {
			map[n][i] = 2; // 궁수
			combination(depth+1, i+1, n, m, d);
			map[n][i] = 0;
		}
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
