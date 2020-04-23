package algo.dp;

import java.util.Scanner;

public class 소금배달_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		sc.close();
		int[] memo = new int[M+1];
		for (int i = 0; i < memo.length; ++i) {
			if (i%3 == 0) {
				memo[i] = i/3;
			} else { // 배달 불가
				memo[i] = 10000;
			}
		}
		for (int i = 5; i < memo.length; ++i) { // 5kg 봉지 고려
			if (memo[i-5] != 10000 && memo[i] > memo[i-5]+1) {
				memo[i] = memo[i-5]+1;
			}
		}
		System.out.print(memo[M] == 10000 ? -1 : memo[M]);
	}
}
