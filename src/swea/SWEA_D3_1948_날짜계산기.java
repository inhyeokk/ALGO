package swea;

import java.util.Scanner;

public class SWEA_D3_1948_날짜계산기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int mona = sc.nextInt();
			int daya = sc.nextInt();
			int monb = sc.nextInt();
			int dayb = sc.nextInt();
			int diff = 0;
			if (dayb < daya) {
				diff += dayb;
				monb--;
				if (monb == 0) monb = 12;
				dayb = getDays(monb);
			}
			while(mona != monb) {
				diff += getDays(mona++);
				if (mona == 13) mona = 1;
			}
			diff += dayb-daya+1;
			sb.append(diff).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	private static int getDays(int month) {
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 2:
				return 28;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			default:
				return 31;
		}
	}
}
