package boj;

import java.util.Scanner;

public class BOJ_B2_13458_시험감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long num = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] > b) {
				arr[i] -= b;
				num += Math.ceil(arr[i]/(double)c);
			}
			++num;
		}
		System.out.print(num);
		sc.close();
	}
}
