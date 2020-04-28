package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-28
 * @author 	rkddlsgur983
 * @memory 	101028KB / 256MB
 * @time   	793ms / 3초
 * @idea	시뮬레이션
 */
public class SWEA_모의_5653_줄기세포배양 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Cell[][] map = new Cell[2*k+n][2*k+m];
			Queue<Cell> queue = new LinkedList<>();
			for (int i = k;  i < k+n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = k; j < k+m; ++j) {
					int v = Integer.parseInt(st.nextToken());
					if (v == 0) continue;
					map[i][j] = new Cell(i,j,v*2,v);
					queue.add(map[i][j]);
				}
			}

			for (int i = 0; i < k; ++i) {
				List<Cell> list = new LinkedList<>();
				for (int j = 0, size = queue.size(); j < size; ++j) {
					Cell c = queue.poll();
					--c.v;
					if (c.v == c.o-1) {
						for (int[] d: di) {
							int nr = c.r + d[0];
							int nc = c.c + d[1];
							if (map[nr][nc] == null) {
								map[nr][nc] = new Cell(nr,nc,c.o*2,c.o);
								list.add(map[nr][nc]);
							} else if (list.contains(map[nr][nc]) && map[nr][nc].o < c.o) {
								map[nr][nc].v = c.o*2;
								map[nr][nc].o = c.o;
							}
						}
					}
					if (c.v > 0) queue.add(c);
				}
				queue.addAll(list);
			}
			sb.append("#").append(t).append(" ").append(queue.size()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	static class Cell {
		int r;
		int c;
		int v;
		int o;
		public Cell(int r, int c, int v, int o) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.o = o;
		}
	}
}
