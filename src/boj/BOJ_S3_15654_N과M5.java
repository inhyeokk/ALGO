package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_15654_N과M5 {
	private static final StringBuilder sb = new StringBuilder();
	private static int n, m;
	private static int[] arr;
	private static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permutation(0, new int[n]);
		System.out.print(sb);
		sc.close();
	}
	
	private static void permutation(int depth, int[] tmp) {
		
		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[depth] = arr[i];
				permutation(depth+1, tmp);
				visit[i] = false;
			}
		}
	}
}
