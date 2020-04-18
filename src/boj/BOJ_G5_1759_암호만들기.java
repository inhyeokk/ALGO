package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_1759_암호만들기 {
	private static int l, c;
	private static char[] arr;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < c; ++i) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(0, 0, new char[l], 0, 0);
		System.out.print(sb);
		bf.close();
	}
	
	private static void combination(int depth, int idx, char[] tmp, int a, int b) {
		
		if (depth == l) {
			if (a >= 1 && b >= 2) {
				sb.append(tmp).append("\n");
			}
			return;
		}
		
		for (int i = idx; i < c; ++i) {
			tmp[depth] = arr[i];
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				combination(depth+1, i+1, tmp, a+1, b);
			} else {
				combination(depth+1, i+1, tmp, a, b+1);
			}
		}
	}
}
