package swea;

import java.util.Scanner;

public class SWEA_D2_1204_최빈수구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			sb.append("#").append(n).append(" ");
			int[] count = new int[101];
			for (int j = 0; j < 1000; j++) {
				count[sc.nextInt()]++;
			}
			
			int max = 0;
			int index = 0;
			for (int j = 0; j < 101; j++) {
				if (max <= count[j]) {
					max = count[j];
					index = j;
				}
			}
			sb.append(index).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
