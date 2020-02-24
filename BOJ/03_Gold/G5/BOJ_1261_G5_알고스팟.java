import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
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
		int[][] weight = new int[n][m];
		for (int i = 0; i < n; ++i) {
			map[i] = bf.readLine().toCharArray();
			Arrays.fill(weight[i], -1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(0);
		queue.add(0);
		weight[0][0] = 0;
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			int row = queue.poll();
			int col = queue.poll();
			int wei = queue.poll();
			if (row == n-1 && col == m-1) {
				min = min > wei ? wei : min;
				continue;
			}
			for (int d = 0; d < di.length; ++d) {
				int nr = row + di[d][0];
				int nc = col + di[d][1];
				if (isInRange(nr,nc,n,m)) {
					int twei = wei;
					if (map[nr][nc] == '1') {
						++twei;
					}
					if (weight[nr][nc] == -1 || weight[nr][nc] > twei) {
						weight[nr][nc] = twei;
						queue.add(nr);
						queue.add(nc);
						queue.add(twei);
					}
				}
			}
		}
		System.out.print(min);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
