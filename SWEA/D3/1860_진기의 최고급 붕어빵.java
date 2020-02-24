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
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] arr= new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			if (arr[0] == 0) {
				sb.append("Impossible").append("\n");
				continue;
			}
			
			int time = 1;
			int bread = 0;
			int index = 0;
			boolean possible = true;
			while (index < arr.length && time <= arr[arr.length-1]) {
				bread += (time >= m && time % m == 0) ? k : 0;
				if (arr[index] == time) {
					if (bread > 0) {
						bread--;
						index++;
					} else {
						possible = false;
						break;
					}
				}
				time++;
			}
			if (possible) {
				sb.append("Possible").append("\n");
			} else {
				sb.append("Impossible").append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
