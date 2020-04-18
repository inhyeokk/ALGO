package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D3_2805_농작물수확하기_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		char[][] map = new char[49][49];
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			int sum = 0;
			for (int j = 0; j < n; ++j) {
				map[j] = bf.readLine().toCharArray();
				if (j <= n/2) {
					for (int k = n/2-j; k <= n/2+j; ++k) {
						sum += map[j][k] - '0';
					}
				} else {
					for (int k = n/2-(n-1-j); k <= n/2+(n-1-j); ++k) {
						sum += map[j][k] - '0';
					}
				}
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
