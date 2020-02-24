import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			long l = sc.nextLong();
			long u = sc.nextLong();
			long x = sc.nextLong();
			if (x > u) {
				sb.append(-1);
			} else if (x >= l && x <= u){
				sb.append(0);
			} else {
				sb.append(l-x);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
