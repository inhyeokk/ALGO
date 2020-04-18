package swea;

import java.util.Scanner;

public class SWEA_D3_1217_거듭제곱 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.printf("#%d %d\n", t, pow(n,m));
		}
		
		sc.close();
	}
	
	private static int pow(int n, int m) {
		if(m == 1) return n;
		return n*pow(n, m-1);
	}
}
