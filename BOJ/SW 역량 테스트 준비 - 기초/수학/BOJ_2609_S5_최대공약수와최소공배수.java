package algo;

import java.util.Scanner;

public class BOJ_2609_S5_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.printf("%d\n%d", gcd(a,b), lcm(a,b));
		sc.close();
	}
	
	private static int gcd(int a, int b) {
		while (b > 0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	private static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
}
