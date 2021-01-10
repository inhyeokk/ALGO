package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/16197
 * @date    2021-01-10
 * @author  lolol0705
 * @memory  13276KB / 512MB
 * @time    160ms / 2초
 */
public class BOJ_16197 {
    private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
    private static int n, m;
    private static char[][] map;
    private static int min = 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int cnt = 0;
        int[][] coin = new int[2][2];
        for (int i = 0; i < n; ++i) {
            String s = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    coin[cnt][0] = i;
                    coin[cnt++][1] = j;
                    map[i][j] = '.';
                }
            }
        }
        br.close();

        dfs(0, coin[0][0], coin[0][1], coin[1][0], coin[1][1]);
        System.out.print(min < 11 ? min : -1);
    }

    private static void dfs(int depth, int r1, int c1, int r2, int c2) {
        if (depth >= min) {
            return;
        } else if (r1 == r2 && c1 == c2) {
            // 두 동전의 위치가 같아지면 -1
            return;
        }

        for (int[] d: di) {
            int nr1 = r1 + d[0];
            int nc1 = c1 + d[1];
            int nr2 = r2 + d[0];
            int nc2 = c2 + d[1];
            boolean isDropFirst = isDrop(nr1, nc1);
            boolean isDropSecond = isDrop(nr2, nc2);
            if (isDropFirst && isDropSecond) continue; // 둘 다 떨어지면 종료
            if (isDropFirst || isDropSecond) { // 한 개만 떨어지면 성공
                min = depth + 1;
                return;
            }
            if (map[nr1][nc1] == '#') { // 벽으로 이동한 경우 원위치
                nr1 -= d[0];
                nc1 -= d[1];
            }
            if (map[nr2][nc2] == '#') {
                nr2 -= d[0];
                nc2 -= d[1];
            }
            dfs(depth+1, nr1, nc1, nr2, nc2);
        }
    }

    private static boolean isDrop(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }
}
