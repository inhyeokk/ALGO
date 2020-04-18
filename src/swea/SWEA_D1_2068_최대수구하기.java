package swea;

import java.util.Scanner;

public class SWEA_D1_2068_최대수구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		int input;
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int max = 0;
			for (int j = 0; j < 10; j++) {
				input = sc.nextInt();
				max = max < input ? input : max;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
