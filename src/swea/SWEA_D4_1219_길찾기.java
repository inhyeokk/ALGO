package swea;

import java.util.Scanner;

public class SWEA_D4_1219_길찾기 {
	
	private static int possible;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			sb.append("#").append(t).append(" ");
			int n = sc.nextInt();
			int[][] arr = new int[100][2];
			for (int j = 0; j < n; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (arr[a][0] == 0) {
					arr[a][0] = b;
				} else {
					arr[a][1] = b;
				}
			}
			possible = 0;
			dfs(0, arr);
			sb.append(possible).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static void dfs(int start, int[][] arr) {
		
		if (arr[start][0] == 99 || arr[start][1] == 99) {
			possible = 1;
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			if (arr[start][i] != 0) {
				dfs(arr[start][i], arr);
			}	
		}
	}
}
