package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2630_색종이만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int b = 0, w = 0;
		for (int size = n; size >= 1; size/=2) {
			for (int i = 0; i < n-size+1; i+=size) {
				for (int j = 0; j < n-size+1; j+=size) {
					int color = map[i][j];
					if (color == 2) continue;
					boolean check = true;
					for (int k = i; k < i+size; ++k) {
						for (int o = j; o < j+size; ++o) {
							if (color != map[k][o]) {
								check = false;
								break;
							}
						}
						if (!check) break;
					}
					if (check) {
						if (color == 0) ++w;
						if (color == 1) ++b;
						for (int k = i; k < i+size; ++k) {
							for (int o = j; o < j+size; ++o) {
								map[k][o] = 2;
							}
						}
					}
				}
			}
		}		
		System.out.printf("%d\n%d", w, b);
		bf.close();
	}
}
