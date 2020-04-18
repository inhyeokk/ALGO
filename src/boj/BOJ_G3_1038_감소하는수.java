package boj;

import java.io.IOException;
import java.util.Scanner;

/**
 * @{link} https://www.acmicpc.net/problem/1038
 * @date   2020-03-12
 * @author rkddlsgur983
 * @memory 14268KB / 512MB
 * @time   112ms / 1초
 */
public class BOJ_G3_1038_감소하는수 {
	private static int n, cnt, len = 1;
	private static boolean find = false;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		if (n >= 1023) {
			System.out.println(-1);
			return;
		}
		while (cnt-1 < n) {
			for (long i = 0L; i < 10; ++i)
				dfs(1, i, i);
			++len;
		}
	}
	
	private static void dfs(int depth, long start, long num) {
		
		if (find) return;
		if (depth == len) {
			if (cnt++ == n) {
				find = true;
				System.out.print(num);
			}
			return;
		}
		
		for (long i = 0L; i < start; ++i) {
			if (find) return;
			dfs(depth+1, i, num*10L+i);
		}
	}
}
