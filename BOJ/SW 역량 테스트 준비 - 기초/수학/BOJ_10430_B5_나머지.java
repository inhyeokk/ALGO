package algo;

import java.util.Scanner;

public class BOJ_10430_B5_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.printf("%d\n%d\n%d\n%d", (a+b)%c, (a%c+b%c)%c, (a*b)%c, (a%c*b%c)%c);
		sc.close();
	}
}
