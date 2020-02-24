package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1780_종이의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int a = 0, b = 0, c = 0;
		for (int size = n; size >= 1; size/=3) {
			for (int i = 0; i < n-size+1; i+=size) {
				for (int j = 0; j < n-size+1; j+=size) {
					int num = map[i][j];
					if (num == 2) continue;
					boolean same = true;
					for (int k = i; k < i+size; ++k) {
						for (int o = j; o < j+size; ++o) {
							if (num != map[k][o]) {
								same = false;
								break;
							}
						}
						if (!same) break;
					}
					if (same) {
						if (num == -1) ++a;
						else if (num == 0) ++b;
						else if (num == 1) ++c;
						for (int k = i; k < i+size; ++k) {
							for (int o = j; o < j+size; ++o) {
								map[k][o] = 2;
							}
						}
					}
				}
			}
		}
		System.out.printf("%d\n%d\n%d", a, b, c);
		bf.close();
	}
}
