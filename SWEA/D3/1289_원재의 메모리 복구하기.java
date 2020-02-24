package day1;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리복구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			String input = sc.next();
			int change = 0;
			boolean isOne = false;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '1') {
					isOne = true;
				} else if (isOne) {
					change += 2;
					isOne = false;
				}
			}
			if (isOne) change += 1;
			sb.append(change).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
