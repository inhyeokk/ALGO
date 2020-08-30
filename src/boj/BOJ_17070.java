package boj;

import java.util.Scanner;

public class BOJ_17070 {
    private static final int[][][] di = {{{0,1},{1,1}}, {{0,1},{1,1},{1,0}}, {{0,0}, {1,1}, {1,0}}};
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 1, 0, n, map);
        System.out.print(count);
        sc.close();
    }

    private static void dfs(int row, int col, int d, int n, int[][] map) {

        if (row == n-1 && col == n-1) {
            ++count;
            return;
        }

        for (int i = 0; i < di[d].length; i++) {
            int nr = row + di[d][i][0];
            int nc = col + di[d][i][1];
            if (nr == row && nc == col) continue;
            if (i == 0 && nr < n-1 && nc == n-1) continue;
            if (i == 2 && nr == n-1 && nc < n-1) continue;
            if (i == 1) {
                boolean possible = true;
                for (int j = 0; j < di[1].length; j++) {
                    int tr = row + di[1][j][0];
                    int tc = col + di[1][j][1];
                    if (!isInRange(tr,tc,n) || map[tr][tc] == 1) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) continue;
            }
            if (isInRange(nr,nc,n) && map[nr][nc] == 0) {
                dfs(nr, nc, i, n, map);
            }
        }
    }

    private static boolean isInRange(int row, int col, int n) {
        return row >= 0 && row < n && col >= 1 && col < n;
    }
}
