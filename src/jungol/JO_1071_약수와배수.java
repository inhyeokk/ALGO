package jungol;

import java.util.Scanner;

public class JO_1071_약수와배수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		
		int suma = 0, sumb = 0;
		for (int i = 0; i < n; i++) {
			if (m >= arr[i] && m % arr[i] == 0) {
				suma += arr[i];
			}
			if (m <= arr[i] && arr[i] % m == 0) {
				sumb += arr[i];
			}
		}
		System.out.println(suma);
		System.out.println(sumb);
		sc.close();
	}
}
