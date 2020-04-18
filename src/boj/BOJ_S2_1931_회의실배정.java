package boj;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_S2_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; ++i) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					if (o1[0] < o2[0]) {
						return -1;
					} else if (o1[0] == o2[0]) {
						return 0;
					} else {
						return 1;
					}
				} else if (o1[1] < o2[1]) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		int cnt = 0;
		int now = 0;
		for (int i = 0; i < n; ++i) {
			if (now <= arr[i][0]) {
				now = arr[i][1];
				++cnt;
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}
