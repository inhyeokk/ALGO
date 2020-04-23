package algo.dp;

import java.util.Arrays;

public class 동전거스름돈 {
	public static void main(String[] args) {
		// 1차원 배열에 업데이트해서 동전 거스름돈 개수를 저장해보자
		int n = 8;
		int[] c = new int[n+1];
		for (int i = 0; i < c.length; ++i) {
			c[i] = i; // 1원짜리 필요한 개수
		}
		
		// 1, 4원 동전을 모두 고려
		for (int i = 4; i < c.length; ++i) {
			// c[i]: 1원짜리 동전만 고려한 최소개수
			// c[i-4]+1: 1원, 4원짜리 동전 고려한 최소개수
			if (c[i] > c[i-4]+1) {
				c[i] = c[i-4]+1;
			}
		}
		
		// 1, 4, 6원 동전을 모두 고려
		for (int i = 6; i < c.length; ++i) {
			// c[i]: 1원, 4원짜리 동전만 고려한 최소개수
			// c[i-6]+1: 1원, 4원, 6원짜리 동전 고려한 최소개수
			if (c[i] > c[i-6]+1) {
				c[i] = c[i-6]+1;
			}
		}
		System.out.print(c[n]);
	}
}
