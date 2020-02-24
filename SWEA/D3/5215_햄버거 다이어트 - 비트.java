import java.util.Scanner;

public class Solution {
	
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
			
			int max = 0;
			for (int j = 1; j < (1<<arr.length); j++) {
				int sumN = 0, sumL = 0;
				for (int k = 0; k < arr.length; k++) {
					if ((j & (1<<k))>0) {
						if (sumL + arr[k][1] <= l) {
							sumL += arr[k][1];
							sumN += arr[k][0];
						}
					}
				}
				max = max < sumN ? sumN : max;
			}
			sb.append(max).append("\n");
			max = 0;
		}
		System.out.println(sb);
		sc.close();
	}
}