package swea;

import java.util.Scanner;

public class SWEA_D3_1240_단순2진암호코드 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean append = false;
			String[] strs = new String[n];
			for (int j = 0; j < n; j++) {
				strs[j] = sc.next();
			}
			for (int j = 0; j < n; j++) {
				if (!strs[j].contains("1")) continue;
				int start = 0;
				for (int k = 0; k < strs[j].length(); k++) {
					if (strs[j].charAt(k) == '1') {
						start = k;
						break;
					}
				}
				int end = strs[j].length()-1;
				for (int k = end; k >= 0; k--) {
					if (strs[j].charAt(k) == '1') {
						end = k;
						break;
					}
				}
				int diff = end - start + 1;
				if (diff == 56) {
					
				} else if (start - (56 - diff) >= 0) {
					start -= 56 - diff;
				} else {
					continue;
				}
				int[] arr = new int[8];
				int a = 0, b = 0;
				for (int k = 0; k < 8; k++) {
					arr[k] = getNum(strs[j].substring(start + 7*k, start + 7*(k+1)));
					if (k % 2 != 0) b += arr[k];
					else a += arr[k];
				}
				int code = a*3 + b;
				int sum = a + b;
				if (code % 10 == 0) {
					sb.append(sum).append("\n");
					append = true;
					break;
				}
			}
			if (!append) {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static int getNum(String num) {
		
		switch (num) {
			case "0001101":
				return 0;
			case "0011001":
				return 1;
			case "0010011":
				return 2;
			case "0111101":
				return 3;
			case "0100011":
				return 4;
			case "0110001":
				return 5;
			case "0101111":
				return 6;
			case "0111011":
				return 7;
			case "0110111":
				return 8;
			case "0001011":
				return 9;
			default:
				return 0;
		}
	}
}
