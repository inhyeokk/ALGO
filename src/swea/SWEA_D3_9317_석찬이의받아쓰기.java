package swea;

import java.util.Scanner;

public class SWEA_D3_9317_석찬이의받아쓰기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int len = sc.nextInt();
			char[] str1 = sc.next().toCharArray();
			char[] str2 = sc.next().toCharArray();
			
			int ans = 0;
			for (int j = 0; j < len; j++) {
				if (str1[j] == str2[j]) ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
