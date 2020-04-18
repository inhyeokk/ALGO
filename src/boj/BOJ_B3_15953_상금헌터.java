package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_15953_상금헌터 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(bf.readLine());
			int money = 0;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				money += 500;
			} else if (a >= 2 && a <= 3) {
				money += 300;
			} else if (a >= 4 && a <= 6) {
				money += 200;
			} else if (a >= 7 && a <= 10) {
				money += 50;
			} else if (a >= 11 && a <= 15) {
				money += 30;
			} else if (a >= 16 && a <= 21) {
				money += 10;
			}
			if (b == 1) {
				money += 512;
			} else if (b >= 2 && b <= 3) {
				money += 256;
			} else if (b >= 4 && b <= 7) {
				money += 128;
			} else if (b >= 8 && b <= 15) {
				money += 64;
			} else if (b >= 16 && b <= 31) {
				money += 32;
			}
			sb.append(money*10000).append("\n");
		}
		System.out.print(sb); 
		bf.close();
	}
}
