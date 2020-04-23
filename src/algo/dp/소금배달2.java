package algo.dp;

import java.util.Scanner;

/**
 * 월말평가 소금배달문제
 * 백트래킹
 * 한계: 매 경우마다 반복적인 재귀가 호출되므로 O(k^n) k: 봉지의 종류
 */
public class 소금배달2 {
	public static int min = Integer.MAX_VALUE; // 최소 봉지 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		sc.close();
		dfs(M, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	/**
	 * @param M		남은무게
	 * @param cnt	지금까지 사용한 봉지 개수
	 */
	private static void dfs(int M, int cnt) {
		if (M < 0 || min <= cnt) { // 해가 없다
			return;
		} else if (M == 0) { // 해
			min = cnt;
			return;
		}
		dfs(M-5, cnt+1);
		dfs(M-3, cnt+1);
	}
}
