import java.util.Scanner;

/**
 * @{link} https://www.acmicpc.net/problem/2023
 * @date   2020-03-14
 * @author rkddlsgur983
 * @memory 14264KB / 4MB
 * @time   108ms / 2초
 */
public class BOJ_2023_G5_신기한소수 {
	private static int n;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		for (int i = 2; i < 10; ++i) {
			if (isPrime(i))
				dfs(1, i);
		}
		System.out.print(sb);
	}
	
	private static boolean isPrime(int num) {
		
		// 2부터 num의 제곱근까지의 숫자가 n과 나누어 떨어지면 소수가 아님
		for (int i = 2; i <= Math.sqrt(num); ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void dfs(int depth, int num) {
		
		if (depth == n) {
			sb.append(num).append("\n");
			return;
		}
		
		for (int i = 1; i < 10; ++i) {
			if (isPrime(num*10+i))
				dfs(depth+1, num*10+i);
		}
	}
}
