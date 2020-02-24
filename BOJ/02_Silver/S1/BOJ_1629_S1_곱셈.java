package algo;

import java.util.Scanner;

public class S1_1629_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.print(getPower(a%c,b,c)%c);
		sc.close();
	}
	
	private static long getPower(int a, int b, int c) {
		if (b == 1) {
			return a%c;
		} else if (b%2==0) {
			long p = getPower(a, b/2, c);
			p %= c;
			return p*p%c;
		} else {
			long p = getPower(a, b/2, c);
			p %= c;
			return p*p*a%c;
		}
	}
}
