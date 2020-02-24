import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append("\n");
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			arr[0][0] = 1;
			sb.append(1).append("\n");
			for (int j = 1; j < n; j++) {
				for (int k = 0; k < j+1; k++) {
					arr[j][k] = k-1 >= 0 ? arr[j-1][k-1] : 0;
					arr[j][k] += arr[j-1][k];
					sb.append(arr[j][k]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
