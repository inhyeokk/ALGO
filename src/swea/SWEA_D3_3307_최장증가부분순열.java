package swea;

import java.util.Scanner;

public class SWEA_D3_3307_최장증가부분순열 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] max = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			max[0] = 1;
			int max_value = 1;
			for (int j = 1; j < n; j++) {
				int m = 0;
				for (int k = 0; k < j; k++) {
					if (arr[j] > arr[k]) {
						m = m < max[k] ? max[k] : m;
					}
				}
				max[j] = m+1;
				max_value = max_value < max[j] ? max[j] : max_value;
			}
			sb.append(max_value).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
