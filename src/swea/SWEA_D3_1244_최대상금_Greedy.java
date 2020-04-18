package swea;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D3_1244_최대상금_Greedy {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			char[] num = sc.next().toCharArray();
			int s = sc.nextInt();
			char[] temp = num.clone();
			Arrays.sort(temp);
			char[] tmp = new char[num.length];
			char[] copy = new char[num.length];
			boolean[] swit = new boolean[num.length];
			for (int j = 0; j < num.length; ++j) {
				tmp[j] = temp[num.length-1-j];
			}
			sb.append("#").append(i).append(" ");
			do {
				boolean same = false;
				int sw = 0;
				copy = tmp.clone();
				Arrays.fill(swit, false);
				for (int j = 0; j < num.length; ++j) {
					if (sw >= s) break;
					if (num[j] == copy[j]) {
						if (!swit[j])
							same = true;
					} else {
						for (int k = j+1; k < num.length; ++k) {
							if (num[j] == copy[k] && num[k] != copy[k]) {
								char tm = copy[j];
								copy[j] = copy[k];
								copy[k] = tm;
								++sw;
								swit[j] = true;
								swit[k] = true;
								break;
							}
						}
					}
				}
				if (Arrays.equals(num, copy)) {
					if (s == sw) {
						sb.append(tmp).append("\n");
						break;
					} else if ((s - sw)%2==0) {
						sb.append(tmp).append("\n");
						break;
					} else {
						if (same) {
							sb.append(tmp).append("\n");
							break;
						}
					}
				}
			} while (prevPermutation(tmp));
		}
		System.out.print(sb);
		sc.close();
	}
	
	private static boolean prevPermutation(char[] num) {
		int i = num.length-2;
		for (; i >= 0; --i) {
			if (num[i] > num[i+1]) {
				break;
			}
		}
		if (i < 0) return false;
		
		int j = num.length-1;
		for (; j >= 0; --j) {
			if (num[i] > num[j]) {
				break;
			}
		}
		if (j < 0) return false;
		
		char tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
		
		for (int k = i+1, o = num.length-1; k < o; ++k, --o) {
			tmp = num[k];
			num[k] = num[o];
			num[o] = tmp;
		}
		return true;
	}
}
