package swea;

import java.util.Scanner;

public class SWEA_D2_2001_파리퇴치 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			n += 2*m-2;
			int[][] map = new int[n][n];
			for (int j = m-1; j < n-m+1; j++) {
				for (int k = m-1; k < n-m+1; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int j = 0; j < n-m+1; j++) {
				for (int k = 0; k < n-m+1; k++) {
					int sum = 0;
					for (int l = 0; l < m; l++) {
						for (int o = 0; o < m; o++) {
							sum += map[j+l][k+o];
						}
					}
					max = max < sum ? sum : max;
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
