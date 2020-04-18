package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/9251
 * @date   	2020-04-13
 * @author 	rkddlsgur983
 * @memory 	18444KB / 256MB
 * @time   	108ms / 1초
 * @idea	https://youtu.be/P-mMvhfJhu8 참고
 */
public class BOJ_G5_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		br.close();
		int alen = a.length();
		int blen = b.length();
		int[][] map = new int[alen+1][blen+1];
		for (int i = 0; i < alen; ++i) {
			for (int j = 0; j < blen; ++j) {
				if (a.charAt(i) == b.charAt(j)) {
					map[i+1][j+1] = map[i][j]+1;
				} else {
					map[i+1][j+1] = map[i][j+1] > map[i+1][j] ? map[i][j+1] : map[i+1][j];
				}
			}
		}
		System.out.print(map[alen][blen]);
	}
}
