import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@link} https://www.acmicpc.net/problem/1992
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 13104KB / 128MB
 * @time   80ms / 2초
 */
public class BOJ_1992_S1_쿼드트리 {
	private static int n;
	private static boolean[][] map;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			String s = bf.readLine();
			for (int j = 0; j < n; ++j) {
				map[i][j] = s.charAt(j) == '1';
			}
		}
		compress(0, 0, n, n);
		System.out.print(sb);
		bf.close();
	}
	
	// 분할 정복
	private static void compress(int sr, int sc, int rlen, int clen) {
		
		if (rlen == 0 || clen == 0) {
			return;
		}
		boolean dot = map[sr][sc];
		boolean possible = true;
		for (int i = 0; i < rlen; ++i) {
			for (int j = 0; j < clen; ++j) {
				if (map[sr+i][sc+j] != dot) {
					possible = false;
					break;
				}
			}
			if (!possible) break;
		}
		
		if (possible) {
			sb.append(dot ? 1 : 0);
			return;
		} else {
			sb.append("(");
			compress(sr, sc, rlen/2, clen/2);
			compress(sr, sc+clen/2, rlen/2, clen/2);
			compress(sr+rlen/2, sc, rlen/2, clen/2);
			compress(sr+rlen/2, sc+clen/2, rlen/2, clen/2);
			sb.append(")");
		}
	}
}
