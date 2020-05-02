package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/15686
 * @date   	2020-05-01
 * @author 	rkddlsgur983
 * @memory 	15272KB / 512MB
 * @time   	148ms / 1초
 * @idea	완전탐색
 * 			s(1개부터 m)개만큼의 치킨집을 남기기 위해
 * 			k(치킨집 개수)-s개의 치킨집을 0으로 만들고
 * 			최소 거리 측정
 */
public class BOJ_G5_15686_치킨배달 {
	private static int n, m, k, h, s, min = Integer.MAX_VALUE;
	private static int[][] ho, ch;
	private static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ho = new int[2*n][2];
		ch = new int[13][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				int m = Integer.parseInt(st.nextToken());
				if (m == 1) {
					ho[h][0] = i;
					ho[h++][1] = j;
				} else if (m == 2) {
					ch[k][0] = i;
					ch[k++][1] = j;
				}
			}
		}
		bf.close();
		
		select = new boolean[k];
		for (s = 1; s <= m; ++s) {
			dfs(0,0);
		}
		System.out.print(min);
	}
	
	private static void dfs(int depth, int sel) {
		if (sel == k-s) {
			int sum = 0;
			for (int i = 0; i < h; ++i) {
				int m = Integer.MAX_VALUE;
				for (int j = 0; j < k; ++j) {
					if (select[j]) continue;
					int a = Math.abs(ho[i][0]-ch[j][0]);
					int b = Math.abs(ho[i][1]-ch[j][1]);
					m = Math.min(a+b, m);
				}
				sum += m;
				if (min <= sum) return;
			}
			min = sum;
			return;
		} else if (depth == k) {
			return;
		}
		select[depth] = true;
		dfs(depth+1, sel+1);

		select[depth] = false;
		dfs(depth+1, sel);
	}
}
