package jungol;

import java.util.Scanner;

public class JO_1523_별삼각형1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n > 0 && n <= 100 && m >= 1 && m <= 3) {
			switch (m) {
				case 1:
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < i+1; j++) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
				case 2:
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n-i; j++) {
							System.out.print("*");
						}
						System.out.println();
					}
					break;
				case 3:
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < 2*n; j++) {
							if (j >= n-1-i && j <=n-1+i) {
								System.out.print("*");
							} else {
								System.out.print(" ");
							}
						}
						System.out.println();
					}
					break;
			}
		} else {
			System.out.println("INPUT ERROR!");
		}
		sc.close();
	}
}
