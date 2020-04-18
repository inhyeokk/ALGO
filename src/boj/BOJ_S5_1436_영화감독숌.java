package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S5_1436_영화감독숌 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int num = 666;
		int find = 1;
		while (find < n) {
			String s = "" + ++num;
			if (s.contains("666")) {
				++find;
			}
		}
		System.out.println(num);
		bf.close();
	}
}
