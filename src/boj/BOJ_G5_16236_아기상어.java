package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-05
 * @author rkddlsgur983
 * @memory 13552KB / 512MB
 * @time   92ms / 2초
 */
public class BOJ_G5_16236_아기상어 {
	private static int[][] di = {{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int[][] map = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		List<Integer> fishes = new LinkedList<>();
		int babyr=0, babyc=0, babys=2, eat=0; // 아기상어
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 6) {
					fishes.add(map[i][j]); // 물고기 리스트에 추가
				} else if (map[i][j] == 9) {
					babyr = i;
					babyc = j;
					map[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		Queue<Integer> queue = new LinkedList<>();
		List<Shark> targets = new LinkedList<>();;
		while (true) {
			boolean possible = false;
			for (Integer f: fishes) {
				if (f < babys) {
					possible = true;
					break;
				}
			}
			if (!possible) {
				break;
			}
			// 잡아 먹을 수 있는 물고기가 있는 경우
			visit[babyr][babyc] = true;
			queue.add(babyr); // 아기상어 위치부터 탐색
			queue.add(babyc);
			queue.add(0); // 이동거리
			int step = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				int r = queue.poll();
				int c = queue.poll();
				int s = queue.poll();
				if (step < s) { // 잡아 먹을 수 있는 물고기의 이동거리보다 멀어지면 종료
					queue.clear();
					break; 
				}
				if (map[r][c] > 0 && map[r][c] < babys) {
					step = s;
					targets.add(new Shark(r,c,map[r][c],s)); // 잡아 먹을 수 있는 물고기 추가
					continue;
				}
				for (int d = 0; d < 4; ++d) {
					int nr = r + di[d][0];
					int nc = c + di[d][1];
					if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] <= babys) {
						visit[nr][nc] = true;
						queue.add(nr);
						queue.add(nc);
						queue.add(s+1);
					}
				}
			}
			if (targets.size() == 0) {
				/* 작은 물고기가 큰 물고기들 사이에 껴있으면
				 * 아기상어가 갈 수 없음
				 */
				break;
			}
			
			Collections.sort(targets);
			Shark t = targets.get(0);
			// 물고기 잡아먹음
			time += t.step;
			fishes.remove(Integer.valueOf(t.size));
			map[t.row][t.col] = 0;
			babyr = t.row;
			babyc = t.col;
			targets.clear();
			++eat;
			if (eat == babys) {
				++babys;
				eat = 0;
			}
			for (int i = 0; i < n; ++i) {
				Arrays.fill(visit[i], false);
			}
		}
		System.out.print(time);
		bf.close();
	}
	
	static class Shark implements Comparable<Shark> {
		int row;
		int col;
		int size;
		int step;
		public Shark(int row, int col, int size, int step) {
			this.row = row;
			this.col = col;
			this.size = size;
			this.step = step;
		}
		@Override
		public int compareTo(Shark o) {
			/* 가장 위에 있는 물고기
			 * 여러마리라면 가장 왼쪽에 있는 물고기
			 */
			if (row < o.row) {
				return -1;
			} else if (row == o.row) {
				if (col < o.col) {
					return -1;
				} else if (col == o.col) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}
