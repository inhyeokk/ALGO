package day4;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			int avg = sum / n;
			int ans = 0;
			for (int j = 0; j < n; j++) {
				if (arr[j] > avg) {
					ans += arr[j] - avg;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
