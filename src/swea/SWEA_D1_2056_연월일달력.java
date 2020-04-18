package swea;

import java.util.Scanner;

public class SWEA_D1_2056_연월일달력 {

	private static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sb.append("#").append(i).append(" ");
			String date = sc.next();
			String year = date.substring(0,4);
			String month = date.substring(4,6);
			String day = date.substring(6);
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			if (monthInt > 0 && monthInt < 13 && dayInt > 0 && dayInt <= days[monthInt]) {
				sb.append(year).append("/").append(month).append("/").append(day).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
