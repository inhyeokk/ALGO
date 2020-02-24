package day1;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_D1_중간값찾기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
		sc.close();
	}
}
