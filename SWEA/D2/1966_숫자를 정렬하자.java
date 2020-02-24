import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int j = 0; j < n; j++) {
				sb.append(arr[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
