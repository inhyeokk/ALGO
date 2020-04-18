package jungol;

import java.util.Scanner;

public class JO_1175_주사위던지기2 {
	
	private static int[] dice = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		game(0, n, m, 0, new int[n]);
		sc.close();
	}
	
	private static void game(int cnt, int n, int m, int sum, int[] temp) {
		
		if (cnt == n) {
			StringBuilder sb = new StringBuilder();
			if (sum != m) return;
			for (int i = 0; i < temp.length; i++) {
				sb.append(temp[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i = 0; i < dice.length; i++) {
			temp[cnt] = dice[i];
			game(cnt+1, n, m, sum + temp[cnt], temp);
		}
	}
}
