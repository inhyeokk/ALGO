package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1240_단순2진암호코드_char배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean append = false;
			char[][] strs = new char[n][m];
			for (int j = 0; j < n; ++j) {
				strs[j] = bf.readLine().toCharArray();
			}
			for (int j = 0; j < n; ++j) {
				int start = -1;
				for (int k = 0, len = strs[j].length; k < len; ++k) {
					if (strs[j][k] == '1') {
						start = k;
						break;
					}
				}
				if (start == -1) continue; // 찾을 수 없음
				int end = strs[j].length-1;
				for (int k = end; k >= 0; --k) {
					if (strs[j][k] == '1') {
						end = k;
						break;
					}
				}
				int diff = end - start + 1;
				if (diff == 56) {
					// valid
				} else if (start - (56 - diff) >= 0) {
					start -= 56 - diff;
				} else {
					continue;
				}
				int a = 0, b = 0;
				for (int k = 0; k < 8; ++k) {
					int tmp = getNum(new String(strs[j], start + 7*k, 7));
					if (k % 2 != 0) b += tmp;
					else a += tmp;
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
		System.out.print(sb);
		bf.close();
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
