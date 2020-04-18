package boj;

import java.util.Scanner;

public class BOJ_S1_9663_NQueen {
	private static int n;
	private static int[] arr;
	private static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		bruteForce(0);
		System.out.print(cnt);
		sc.close();
	}
	
	private static void bruteForce(int row) {
		
		if (row == n) {
			++cnt;
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (possible(i, row)) {
				arr[row] = i;
				bruteForce(row+1);
			}
		}
	}
	
	private static boolean possible(int idx, int row) {
		for (int i = 0; i < row; ++i) {
			if (arr[i] == idx) {
				return false;
			}
			if (Math.abs(idx-arr[i]) == Math.abs(i-row)) {
				return false;
			}
		}
		return true;
	}
}
