import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] sum = new int[n];
			int max = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					int s = sc.nextInt();
					sum[j] += s;
				}
				max = max < sum[j] ? sum[j] : max;
			}
			int num = 0;
			for (int j = 0; j < n; j++) {
				if (max == sum[j]) num++;
			}
			sb.append(num).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
