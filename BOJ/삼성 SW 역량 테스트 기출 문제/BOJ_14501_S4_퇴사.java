package day7;

import java.util.Scanner;

public class S4_14501_퇴사 {
	private static int max = 0;
	private static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		dfs(0, n, 0);
		System.out.print(max);
		sc.close();
	}
	
	private static void dfs(int day, int n, int benefit) {
		if (day == n) {
			max = max < benefit ? benefit : max;
			return;
		}
		
		for (int i = day; i < n; ++i) {
			if (i + arr[i][0] <= n) {
				dfs(i+arr[i][0], n, benefit+arr[i][1]);
			}
			dfs(i+1, n, benefit);
		}
	}
}
