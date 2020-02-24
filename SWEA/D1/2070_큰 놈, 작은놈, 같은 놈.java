package com.basic;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("#%d ", i);
			if (a < b) {
				System.out.println("<");
			} else if (a == b) {
				System.out.println("=");
			} else {
				System.out.println(">");
			}
		}
	}
}