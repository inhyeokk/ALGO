package swea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_D3_5215_햄버거다이어트 {

	private static int max = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int l = sc.nextInt();
			Integer[][] arr = new Integer[n][2];
			for (int j = 0; j < n; j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = sc.nextInt();
			}
			Arrays.sort(arr, comparator);
			for (int j = 0; j < n; j++) {
				bruteForce(arr[j][0], arr[j][1], l, j+1, n, arr);
			}
			sb.append(max).append("\n");
			max = 0;
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static void bruteForce(int score, int cal, int l, int index, int n, Integer[][] arr) {
		
		if (index == n) return;
		
		for (int i = index; i < n; i++) {
			if (cal + arr[i][1] <= l) {
				int temp = score + arr[i][0];
				max = max < temp ? temp : max;
				bruteForce(temp, cal + arr[i][1], l, i+1, n, arr);
			}
		}
	}
	
	private static final Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
		
		@Override
		public int compare(Integer[] o1, Integer[] o2) {
			if (o1[0] == o2[0]) return o2[1].compareTo(o1[1]);
			else return o2[0].compareTo(o1[0]);
		}
	};
}
