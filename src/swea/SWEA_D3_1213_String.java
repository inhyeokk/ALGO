package swea;

import java.util.Scanner;

public class SWEA_D3_1213_String {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 2; i++) {
			int t = sc.nextInt();
			char[] target = sc.next().toCharArray();
			char[] str = sc.next().toCharArray();
			int ans = 0;
			for (int j = 0; j < str.length-target.length+1;) {
				if (str[j] != target[0]) {
					j++;
				} else {
					int same = 0;
					for (int k = 0; k < target.length; k++, j++) {
						if (str[j] == target[k]) same++;
						else break;
					}
					if (same == target.length) ans++;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
		sc.close();
	}
}
