package algo.dp;

import java.util.Arrays;

public class 플로이드와샬 {
	public static void main(String[] args) {
		final int M = 10000; // 범위를 넘지 않는 최대값
		int[][] D = {{0,M,2,3},
					{4,0,1,8},
					{2,5,0,M},
					{M,9,6,0}};
		
		for (int k = 0; k < D.length; ++k) {
			for (int i = 0; i < D.length; ++i) {
				if (k == i) continue;
				for (int j = 0; j < D.length; ++j) {
					if (k == j || i == j) continue;
					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < D.length; ++i) {
			System.out.println(Arrays.toString(D[i]));
		}
	}
}
