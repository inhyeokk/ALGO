package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/16390
 * @date   2020-03-09
 * @author rkddlsgur983
 * @memory 13260KB / 512MB
 * @time   80ms / 2초
 */
public class BOJ_S2_16390_ShebasAmoebas {
	private static int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char[][] map = new char[m][n];
		for (int i = 0; i < m; ++i) {
			map[i] = bf.readLine().toCharArray();
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j] == '#') {
					++ans;
					map[i][j] = '.';
					queue.add(i);
					queue.add(j);
					while(!queue.isEmpty()) {
						int row = queue.poll();
						int col = queue.poll();
						for (int d = 0; d < di.length; ++d) {
							int nr = row + di[d][0];
							int nc = col + di[d][1];
							if (nr >= 0 && nr < m && nc >= 0 && nc < n && map[nr][nc] == '#') {
								map[nr][nc] = '.';
								queue.add(nr);
								queue.add(nc);
							}
						}
						
					}
				}
			}
		}
		System.out.print(ans);
		bf.close();
	}
}
