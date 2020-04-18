package boj;

import java.util.Scanner;

public class BOJ_B3_10275_골드러시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			long a = sc.nextLong();
			long b = sc.nextLong();
			long nm = n;
			for (; nm >= 1; --nm) {
				if (a > 0 && 1L<<nm <= a) {
					a -= 1L<<nm;
				}
				if (b > 0 && 1L<<nm <= b) {
					b -= 1L<<nm;
				}
				if (a == 0 && b == 0) {
					break;
				}
			}
			sb.append(n-nm).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
