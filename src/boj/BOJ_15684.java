package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/15684
 * @date    2020-10-26
 * @author  lolol0705
 * @memory  16188KB / 512MB
 * @time    1300ms / 2초
 * @attempt 7회
 * @comment DFS 백트래킹 순열
 */
public class BOJ_15684 {
    private static int n, m, h;
    private static boolean[][] map;
    private static int min = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new boolean[h][n];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = true;
        }
        br.close();

        dfs(0, 0, 0);
        if (min < 4) {
            System.out.print(min);
        } else {
            System.out.print(-1);
        }
    }

    // 종료 조건 여부 판별
    private static boolean search() {
        for (int j = 0; j < n; ++j) {
            int cur = j;
            for (int i = 0; i < h; ++i) {
                if (map[i][cur]) {
                    ++cur;
                } else if (cur > 0 && map[i][cur - 1]) {
                    --cur;
                }
            }
            if (cur != j) return false;
        }
        return true;
    }

    // DFS + 행열에 대한 순열
    private static void dfs(int depth, int width, int height) {
        if (depth >= min) return; // 현재 최소값보다 크거나 같을 경우 탐색 종료
        if (search()) {
            min = depth;
            return;
        }
        if (depth == 3) return; // 최대 3개까지 사다리를 놓았지만 불가능할 경우 종료

        for (int i = height; i < h; ++i) {
            for (int j = width; j < n-1; ++j) {
                if (map[i][j]) continue;
                if (j > 0 && map[i][j-1]) continue;
                if (j < n-2 && map[i][j+1]) continue;
                map[i][j] = true;
                dfs(depth+1, width+1, height);
                map[i][j] = false;
            }
        }
    }
}
