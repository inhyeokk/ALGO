package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서울_13반_강인혁 {
	private static final int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine().trim());
		int n = 10;
		boolean[][] map = new boolean[n][n];
		for (int t = 1; t <= tc; ++t) {
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken()) == 1;
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			int cnt = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (map[i][j]) {
						map[i][j] = false;
						++cnt;
						queue.add(new int[] {i,j});
						while (!queue.isEmpty()) {
							int[] k = queue.poll();
							for (int[] d: di) {
								int nr = k[0] + d[0];
								int nc = k[1] + d[1];
								if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc]) {
									map[nr][nc] = false;
									queue.add(new int[] {nr,nc});
								}
							}
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
