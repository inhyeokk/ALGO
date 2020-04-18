package boj;

import java.util.Scanner;

public class BOJ_S1_14888_연산자끼워넣기 {
	private static int max = -1000000000, min = 1000000000; 
	private static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int mul = sc.nextInt();
		int div = sc.nextInt();
		bruteForce(1, plus, minus, mul, div, arr[0]);
		System.out.printf("%d\n%d",max,min);
		sc.close();
	}
	
	private static void bruteForce(int idx, int plus, int minus, int mul, int div, int value) {
		
		if (idx == arr.length) {
			max = max < value ? value : max;
			min = min > value ? value : min;
			return;
		}
		
		if (plus > 0) {
			bruteForce(idx+1, plus-1, minus, mul, div, value+arr[idx]);
		}
		if (minus > 0) {
			bruteForce(idx+1, plus, minus-1, mul, div, value-arr[idx]);
		}
		if (mul > 0) {
			bruteForce(idx+1, plus, minus, mul-1, div, value*arr[idx]);
		}
		if (div > 0) {
			if (value < 0) {
				value = value*-1;
				value /= arr[idx];
				value = value*-1;
			} else {
				value /= arr[idx];
			}
			bruteForce(idx+1, plus, minus, mul, div-1, value);
		}
	}
}
