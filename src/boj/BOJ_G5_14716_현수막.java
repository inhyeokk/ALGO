package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/14716
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 25588KB /512MB
 * @time   228ms / 1초
 */
public class BOJ_G5_14716_현수막 {
	private static int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[m][n];
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		
		/* 단순 BFS 탐색
		 * 글자 그룹이 몇개 있는지 알아보면 됨
		 */
		int ans = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j]) {
					map[i][j] = false;
					queue.add(i);
					queue.add(j);
					while(!queue.isEmpty()) {
						int r = queue.poll();
						int c = queue.poll();
						for (int d = 0; d < di.length; ++d) {
							int nr = r + di[d][0];
							int nc = c + di[d][1];
							if (nr >= 0 && nr < m && nc >= 0 && nc < n && map[nr][nc]) {
								map[nr][nc] = false;
								queue.add(nr);
								queue.add(nc);
							}
						}
					}
					++ans;
				}
			}
		}
		System.out.print(ans);
		bf.close();
	}
}
