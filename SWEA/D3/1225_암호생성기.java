import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			sb.append("#").append(t).append(" ");
			int[] arr = new int[8];
			for (int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}
			int cnt = 1, index = 0;
			while(true) {
				arr[index] -= cnt++;
				if (arr[index] <= 0) {
					arr[index++] = 0;
					break;
				}
				index++;
				if (index == 8) index = 0;
				if (cnt == 6) cnt = 1;
			}
			if (index == 8) index = 0;
			int add = 0;
			while (add < 8) {
				sb.append(arr[index++]).append(" ");
				if (index == 8) index = 0;
				add++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
