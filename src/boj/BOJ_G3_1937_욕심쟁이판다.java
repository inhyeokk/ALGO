package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G3_1937_욕심쟁이판다 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n;
	private static int[][] map;
	private static int max = 1; // 최대 일수
	private static int[][] weight; // 이미 탐색한 최대 일수 저장
	private static PriorityQueue<Forest> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pq.add(new Forest(i,j,map[i][j])); // 우선순위 큐에 추가
			}
		}
		
		weight = new int[n][n];
		/* 대나무의 수가 많은 위치부터 낮은 위치까지 탐색
		 * 현재보다 높은 위치의 경우 이미 계산되어 있기 때문에
		 * 현재 위치 주변 4방향 중 현재 보다 높은 위치에서 가장 큰 값+1한 것이 현재의 값
		 */
		while (!pq.isEmpty()) {
			Forest f = pq.poll();
			int row = f.row;
			int col = f.col;
			weight[row][col] = 1;
			for (int d = 0; d < di.length; ++d) {
				int nr = row + di[d][0];
				int nc = col + di[d][1];
				if (isInRange(nr,nc,n) && map[row][col] < map[nr][nc]) {
					weight[row][col] = Math.max(weight[row][col], weight[nr][nc]+1);
					max = Math.max(weight[row][col], max);
				}
			}
		}
		System.out.print(max);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int n) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}
	
	// 대나무의 수가 많은 순서대로 우선순위 큐에 넣기 위함
	static class Forest implements Comparable<Forest>{
		int row;
		int col;
		int tree;
		
		public Forest(int row, int col, int tree) {
			this.row = row;
			this.col = col;
			this.tree = tree;
		}
		
		@Override
		public int compareTo(Forest o) {
			if (tree > o.tree) {
				return -1;
			} else if (tree == o.tree) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
