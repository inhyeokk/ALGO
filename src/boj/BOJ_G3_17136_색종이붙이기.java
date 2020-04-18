package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date   2020-03-10
 * @author rkddlsgur983
 * @memory 20284KB / 512MB
 * @time   312ms / 1초
 */
public class BOJ_G3_17136_색종이붙이기 {
	private static int n = 10;
	private static boolean[][] map = new boolean[n][n];
	private static int min = 26;
	private static List<Paper> list = new LinkedList<>();
	private static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		bf.close();
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!map[i][j]) continue;
				int range = 1;
				here: // 최대 크기 5, i,j 위치에서 붙일 수 있는 가장 큰 색종이를 구함
				while (range < 5 && i+range < n && j+range < n) {
					for (int k = i; k <= i+range; ++k) {
						if (!map[k][j+range]) {
							break here;
						}
					}
					for (int k = j; k <= j+range-1; ++k) {
						if (!map[i+range][k]) {
							break here;
						}
					}
					++range;
				}
				list.add(new Paper(i,j,range));
			}
		}
		
		size = list.size();
		dfs(0, 0, new int[5]);
		if (min == 26) {
			System.out.print(-1);
		} else {
			System.out.print(min);
		}
	}
	
	private static void dfs(int depth, int total, int[] cnt) {
		
		if (min <= total) {
			return;
		} else if (depth == size) {
			min = total;
			return;
		}
		
		Paper p = list.get(depth);
		// 이미 붙여진 상태이면 다음 위치
		if (!map[p.r][p.c]) {
			dfs(depth+1, total, cnt);
			return;
		}
		
		for (int s = p.s; s >= 1; --s) {
			if (cnt[s-1] == 5) continue; // 각 색종이 당 5개를 넘을 수 없음
			boolean possible = true;
			here: // s크기의 색종이를 현재 위치에 붙일 수 있는지 확인
			for (int i = 0; i < s; ++i) {
				for (int j = 0; j < s; ++j) {
					if (!map[p.r+i][p.c+j]) {
						possible = false;
						break here;
					}
				}
			}
			if (!possible) continue;
			
			// s크기의 색종이를 붙임
			for (int i = 0; i < s; ++i) {
				for (int j = 0; j < s; ++j) {
					map[p.r+i][p.c+j] = false;
				}
			}
			++cnt[s-1];
			dfs(depth+1, total+1, cnt);
			--cnt[s-1];
			// 떼어냄
			for (int i = 0; i < s; ++i) {
				for (int j = 0; j < s; ++j) {
					map[p.r+i][p.c+j] = true;
				}
			}
		}
	}
	
	static class Paper {
		int r;
		int c;
		int s;
		
		public Paper(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
