package boj;



import java.util.Scanner;

public class BOJ_S1_11047_동전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int start = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
			if (arr[i] <= k) start = i;
		}
		
		int ans = 0;
		for (int i = start; i >= 0; --i) {
			if (arr[i] <= k) {
				ans += k / arr[i];
				k %= arr[i];
			}
			if (k == 0) break;
		}
		System.out.println(ans);
		sc.close();
	}
}
