package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/2580
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 93048KB / 256MB
 * @time   420ms / 1초
 */
public class BOJ_G4_2580_스도쿠 {
	private static int n = 9;
	private static int[][] map;
	private static List<Node> zero = new LinkedList<>();
	private static boolean end = false;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero.add(new Node(i,j));
				}
			}
		}
		bf.close();
		dfs(0);
	}
	
	private static void dfs(int depth) {
		
		if (end) {
			return;
		} else if (depth == zero.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			end = true;
			return;
		}
		
		boolean[] num = new boolean[10];
		Node node = zero.get(depth);
		for (int i = 0; i < n; ++i) {
			num[map[node.r][i]] = true;
			num[map[i][node.c]] = true;
		}
		for (int i = 0, sr = node.r/3*3; i < 3; ++i) {
			for (int j = 0, sc = node.c/3*3; j < 3; ++j) {
				num[map[sr+i][sc+j]] = true;
			}
		}
		
		for (int i = 1; i <= 9; ++i) {
			if (end) return;
			if (!num[i]) {
				map[node.r][node.c] = i;
				dfs(depth+1);
				map[node.r][node.c] = 0;
			}
		}
	}
	
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
