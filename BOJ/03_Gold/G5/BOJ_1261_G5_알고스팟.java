import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_G5_알고스팟 {
	private static int[][] di = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char[][] map = new char[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; ++i) {
			map[i] = bf.readLine().toCharArray();
		}
		bf.close();
		
		// 벽을 최소로 부순 횟수 오름차순
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] < o2[2]) {
					return -1;
				} else if (o1[2] == o2[2]) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		queue.add(new int[] {0,0,0});
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			int[] spot = queue.poll();
			if (spot[0] == n-1 && spot[1] == m-1) {
				System.out.print(spot[2]);
				break;
			}
			for (int d = 0; d < di.length; ++d) {
				int nr = spot[0] + di[d][0];
				int nc = spot[1] + di[d][1];
				if (isInRange(nr,nc,n,m)) {
					int twei = spot[2];
					// 벽을 부숨
					if (map[nr][nc] == '1') {
						++twei;
					}
					if (!visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.add(new int[] {nr,nc,twei});
					}
				}
			}
		}
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
