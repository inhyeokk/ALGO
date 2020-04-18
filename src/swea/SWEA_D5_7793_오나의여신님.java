package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-09
 * @author rkddlsgur983
 * @memory 26360KB / 256MB
 * @time   128ms / 2초
 */
public class SWEA_D5_7793_오나의여신님 {
	/* 1. static 변수로 선언
	 * 2. 전체 크기만큼 할당하기보다 각 케이스마다 입력된 크기로 할당
	 * 3. 큐 데이터 삽입 시 정수형 변수를 여러번 넣고 뺴는 것 보다
	 * 	    정수형 배열 or 클래스를 사용하는 것이 더 효율적임
	 */
	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int n, m;
	private static char[][] map;
	private static Queue<int[]> su, de;
	private static boolean[][] suvisit, devisit;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			su = new LinkedList<>();
			de = new LinkedList<>();
			suvisit = new boolean[n][m];
			devisit = new boolean[n][m];
			for (int j = 0; j < n; ++j) {
				String s = bf.readLine();
				for (int k = 0; k < m; ++k) {
					map[j][k] = s.charAt(k);
					if (map[j][k] == 'S') {
						suvisit[j][k] = true;
						map[j][k] = '.';
						su.add(new int[] {j,k});
					} else if (map[j][k] == '*') {
						devisit[j][k] = true;
						de.add(new int[] {j,k});
					} 
				}
			}
			
			int step = 0;
			boolean possible = false;
			while (!su.isEmpty()) {
				for (int j = 0, dsize = de.size(); j < dsize; ++j) {
					int[] tmp = de.poll();
					int r = tmp[0];
					int c = tmp[1];
					for (int d = 0; d < di.length; ++d) {
						int nr = r + di[d][0];
						int nc = c + di[d][1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < m && !devisit[nr][nc] && map[nr][nc] == '.') {
							devisit[nr][nc] = true;
							map[nr][nc] = '*';
							de.add(new int[] {nr,nc});
						}
					}
				}
				
				for (int j = 0, ssize = su.size(); j < ssize; ++j) {
					int[] tmp = su.poll();
					int r = tmp[0];
					int c = tmp[1];
					if (map[r][c] == 'D') {
						possible = true;
						break;
					}
					for (int d = 0; d < di.length; ++d) {
						int nr = r + di[d][0];
						int nc = c + di[d][1];
						if (nr >= 0 && nr < n && nc >= 0 && nc < m && !suvisit[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
							suvisit[nr][nc] = true;
							su.add(new int[] {nr,nc});
						}
					}
				}
				if (possible) break;
				++step;
			}
			sb.append("#").append(i).append(" ");
			if (possible) {
				sb.append(step);
			} else {
				sb.append("GAME OVER");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
