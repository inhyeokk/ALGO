package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-05
 * @author rkddlsgur983
 * @memory 60468KB / 262144KB
 * @time   2024ms / 5초
 */
public class SWEA_모의_2382_미생물격리 {
	private static int[][] di = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
	private static int[] op = {0, 2, 1, 4, 3};
	private static int n, m, k;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			// 연결리스트로 구현하면 빨라짐
			Micro[] micro = new Micro[k];
			int sum = 0;
			for (int j = 0; j < k; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				micro[j] = new Micro(row, col, cnt, dir);
				sum += cnt;
			}
			
			for (int ti = 0; ti < m; ++ti) {
				// 각 군집들은 1시간마다 이동 
				for (int j = 0; j < k; ++j) {
					if (micro[j] == null) continue;
					micro[j].r += di[micro[j].d][0];
					micro[j].c += di[micro[j].d][1];
					// 약품이 칠해진 셀에 도착하면 절반이 죽고 이동방향이 반대로 바뀜
					if (micro[j].r == 0 || micro[j].r == n-1 
							|| micro[j].c == 0 || micro[j].c == n-1) {
						int die = micro[j].m - micro[j].m / 2;
						micro[j].m -= die;
						sum -= die;
						micro[j].d = op[micro[j].d];
						if (micro[j].m == 0) {
							micro[j] = null;
						}
					}
				}
				for (int j = 0; j < k-1; ++j) {
					if (micro[j] == null) continue;
					boolean same = false;
					int max = micro[j].m;
					int midx = j;
					for (int l = j+1; l < k; ++l) {
						if (micro[l] == null) continue;
						if (micro[j].r == micro[l].r && micro[j].c == micro[l].c) {
							same = true;
							if (max < micro[l].m) {
								max = micro[l].m;
								midx = l; // 가장 큰 군집의 인덱스
							}
						}
					}
					// 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐짐
					if (same) {
						for (int l = j; l < k; ++l) {
							if (micro[l] == null) continue;
							if (micro[midx].r == micro[l].r && micro[midx].c == micro[l].c) {
								if (midx != l) {
									micro[midx].m += micro[l].m;
									micro[l] = null;
								}
							}
						}
					}
				}
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Micro {
		int r;
		int c;
		int m;
		int d;
		public Micro(int r, int c, int m, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
		}
	}
}
