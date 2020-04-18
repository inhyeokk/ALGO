package swea;

import java.util.Scanner;

public class SWEA_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			long sum = 0;
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int max = 0;
			for (int j = n-1; j >= 0; j--) {
				if (max < arr[j]) {
					max = arr[j];
				} else {
					sum += max - arr[j];
				}
			}
			System.out.printf("#%d %d\n", i, sum);
		}
		sc.close();
	}
}
