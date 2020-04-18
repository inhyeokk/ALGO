package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D1_2063_중간값찾기 {

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
