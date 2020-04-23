package algo.dp;

import java.util.Scanner;

/**
 * f(1) = 2
 * f(2) = 5
 * f(n) = f(n-1)*2 + f(n-2)
 * 현재 선택할 수 있는 막대 기준으로 가능한 경우 나열
 * 3cm 막대를 만드는 방법은 
 * 1. 1cm 파란 막대를 선택하고 2cm를 더함 -> f(2)
 * 2. 1cm 노란 막대를 선택하고 2cm를 더함 -> f(2)
 * 3. 2cm 빨간 막대를 선택하고 1cm를 더함 -> f(1)
 * => f(3) = f(2)*2 + f(1)
 */
public class 연습문제2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int[] memo = new int[N+1];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <= N; ++i) {
			memo[i] = memo[i-1]*2 + memo[i-2];
		}
		System.out.print(memo[N]);
	}
}
