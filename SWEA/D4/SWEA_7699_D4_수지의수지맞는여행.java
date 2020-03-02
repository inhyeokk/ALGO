import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory 27248KB / 262144KB
 * @time   132ms / 20초
 */
public class SWEA_7699_D4_수지의수지맞는여행 {
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static char[][] map = new char[20][20];
	private static int r, c;
	private static boolean[] visit = new boolean[26];
	private static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < r; ++j) {
				String s = bf.readLine();
				for (int k = 0; k < c; ++k) {
					map[j][k] = s.charAt(k);
				}
			}
			max = 0;
			visit[map[0][0]-'A'] = true;
			dfs(0, 0, 1);
			visit[map[0][0]-'A'] = false;
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void dfs(int row, int col, int landmark) {
		
		max = max < landmark ? landmark : max;
		if (max == 26) return;
		/* 백트래킹 - 알파벳 전부 방문한 경우 더이상 탐색하지 않아도됨
		 * 했을 경우: 132ms
		 * 안했을 경우: 2116ms
		 */

		for (int d = 0; d < di.length; ++d) {
			int nr = row + di[d][0];
			int nc = col + di[d][1];
			if (isInRange(nr,nc) && !visit[map[nr][nc]-'A']) {
				visit[map[nr][nc]-'A'] = true;
				dfs(nr, nc, landmark+1);
				visit[map[nr][nc]-'A'] = false;
			}
		}
	}
	
	private static boolean isInRange(int row, int col) {
		return row >= 0 && row < r && col >= 0 && col < c;
	}
}
