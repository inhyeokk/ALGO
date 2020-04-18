package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_1120_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		int min = Integer.MAX_VALUE;
		for (int i = 0, blen = b.length-a.length+1; i < blen; ++i) {
			int diff = 0;
			for (int j = 0, alen = a.length; j < alen; ++j) {
				if (a[j] != b[j+i]) {
					++diff;
				}
			}
			min = min > diff ? diff : min;
		}
		System.out.print(min);
		bf.close();
	}
}
