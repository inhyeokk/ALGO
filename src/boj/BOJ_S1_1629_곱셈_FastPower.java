package boj;

import java.util.Scanner;

public class BOJ_S1_1629_곱셈_FastPower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(fastPower(a,b,c));
		sc.close();
	}
	
	private static long fastPower(long a, int b, int c) {
		
		long result = 1L;
		while (b > 0) {
			// 홀수일 경우에만 곱해줌
			// power가 1이되는 경우가 반드시 있음
			if ((b & 1)==1) {
				result = (result * a) % c;
			}
			b >>= 1; // 나누기 2와 동일
			a = a * a % c;
		}
		return result;
	}
}
