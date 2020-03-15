import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/3055
 * @date	2020-03-15
 * @author	rkddlsgur983
 * @memory	13224KB / 128MB
 * @time	80ms / 1초
 * @idea	BFS
 */
public class BOJ_3055_G5_탈출 {
	private static int r, c;
	private static char[][] map;
	private static boolean[][] wvisit, mvisit;
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		wvisit = new boolean[r][c];
		mvisit = new boolean[r][c];
		Queue<int[]> move = new LinkedList<>();
		Queue<int[]> water = new LinkedList<>();
		for (int i = 0; i < r; ++i) {
			String s = bf.readLine();
			for (int j = 0; j < c; ++j) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.') {
					continue;
				} else if (map[i][j] == '*') {
					wvisit[i][j] = true;
					water.add(new int[] {i,j});
				} else if (map[i][j] == 'S') {
					mvisit[i][j] = true;
					map[i][j] = '.';
					move.add(new int[] {i,j});
				}
			}
		}
		bf.close();
		
		int step = 0;
		while (!move.isEmpty()) {
			++step;
			for (int i = 0, size = move.size(); i < size; ++i) {
				int[] tmp = move.poll();
				if (map[tmp[0]][tmp[1]] == '*') {
					continue;
				}
				for (int[] d: di) {
					int nr = tmp[0] + d[0];
					int nc = tmp[1] + d[1];
					if (nr >= 0 && nr < r && nc >= 0 && nc < c && !mvisit[nr][nc]) {
						if (map[nr][nc] == '.') {
							mvisit[nr][nc] = true;
							move.add(new int[] {nr,nc});
						} else if (map[nr][nc] == 'D') {
							System.out.println(step);
							return;
						}
					}
				}
			}
			for (int i = 0, size = water.size(); i < size; ++i) {
				int[] tmp = water.poll();
				for (int[] d: di) {
					int nr = tmp[0] + d[0];
					int nc = tmp[1] + d[1];
					if (nr >= 0 && nr < r && nc >= 0 && nc < c && !wvisit[nr][nc] && map[nr][nc] == '.') {
						wvisit[nr][nc] = true;
						map[nr][nc] = '*';
						water.add(new int[] {nr,nc});
					}
				}
			}
		}
		System.out.print("KAKTUS");
	}
}
