package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-05-24
 * @author 	rkddlsgur983
 * @memory 	16880KB / 256MB
 * @time   	98ms / 5초
 * @idea   	입력받은 자석 위치를 기준으로 왼쪽 오른쪽 자석들의 회전 방향 결정
 */
public class SWEA_모의_4013_특이한자석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		boolean[][] mag = new boolean[4][8];
		int[] dir = new int[4];
		for (int t = 1; t <= tc; ++t) {
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; ++j) {
					mag[i][j] = Integer.parseInt(st.nextToken()) == 1;
				}
			}
			for (int i = 0; i < k; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int n = Integer.parseInt(st.nextToken())-1;
				int d = Integer.parseInt(st.nextToken());
				Arrays.fill(dir, 0);
				dir[n] = d;
				for (int j = n+1; j < 4; ++j) {
					if (mag[j-1][2] != mag[j][6]) {
						dir[j] = dir[j-1] == 1 ? -1 : 1;
					} else break;
				}
				for (int j = n-1; j >= 0; --j) {
					if (mag[j+1][6] != mag[j][2]) {
						dir[j] = dir[j+1] == 1 ? -1 : 1;
					} else break;
				}
				for (int j = 0; j < 4; ++j) {
					if (dir[j] == 0) continue;
					if (dir[j] == 1) {
						boolean tmp = mag[j][7];
						for (int o = 6; o >= 0; --o) {
							mag[j][o+1] = mag[j][o];
						}
						mag[j][0] = tmp;
					} else {
						boolean tmp = mag[j][0];
						for (int o = 1; o < 8; ++o) {
							mag[j][o-1] = mag[j][o];
						}
						mag[j][7] = tmp;
					}
				}
			}
			int sum = 0;
			for (int i = 0; i < 4; ++i) {
				sum += mag[i][0] ? Math.pow(2, i) : 0;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
