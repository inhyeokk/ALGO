import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_G5_주사위굴리기 {
	private static int[][] di = {{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int[7]; // 주사위에 쓰여진 숫자
		int[][] dice = new int[4][3]; // 주사위 전개도
		dice[0][1] = 2;
		dice[1][1] = 1;
		dice[2][1] = 5;
		dice[3][1] = 6;
		dice[1][0] = 4;
		dice[1][2] = 3;
		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < k; ++i) {
			int d = Integer.parseInt(st.nextToken());
			int nr = row + di[d][0];
			int nc = col + di[d][1];
			if (isInRange(nr, nc, n, m)) {
				row = nr;
				col = nc;
				if (d == 1) {
					int tmp = dice[1][2];
					dice[1][2] = dice[1][1];
					dice[1][1] = dice[1][0];
					dice[1][0] = dice[3][1];
					dice[3][1] = tmp;
				} else if (d == 2) {
					int tmp = dice[1][0];
					dice[1][0] = dice[1][1];
					dice[1][1] = dice[1][2];
					dice[1][2] = dice[3][1];
					dice[3][1] = tmp;
				} else if (d == 3) {
					int tmp = dice[0][1];
					dice[0][1] = dice[1][1];
					dice[1][1] = dice[2][1];
					dice[2][1] = dice[3][1];
					dice[3][1] = tmp;
				} else if (d == 4) {
					int tmp = dice[3][1];
					dice[3][1] = dice[2][1];
					dice[2][1] = dice[1][1];
					dice[1][1] = dice[0][1];
					dice[0][1] = tmp;
				}
				if (map[nr][nc] == 0) {
					map[nr][nc] = num[dice[3][1]];
				} else {
					num[dice[3][1]] = map[nr][nc];
					map[nr][nc] = 0;
				}
				sb.append(num[dice[1][1]]).append("\n");
			}
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static boolean isInRange(int row, int col, int n, int m) {
		return row >= 0 && row < n && col >= 0 && col < m;
	}
}
