package swea;

import java.util.Scanner;

public class SWEA_D3_1234_비밀번호 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			String str = sc.next();
			boolean none = false;
			while (!none) {
				none = true;
				for (int j = 0; j < str.length()-1; j++) {
					if (str.charAt(j) == str.charAt(j+1)) {
						if (j+2 < str.length()) {
							str = str.substring(0,j) + str.substring(j+2);
						} else {
							str = str.substring(0,j);
						}
						none = false;
						break;
					}
				}
			}
			sb.append(str).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
