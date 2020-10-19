package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/1987
 * @date    2020-10-19
 * @author  lolol0705
 * @memory  13948KB / 256MB
 * @time    1004ms / 2초
 */
public class BOJ_1987 {
    private static int r, c;
    private static char[][] map;
    private static final boolean[] check = new boolean[26];
    private static int max = 0;
    private static final int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; ++i) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        check[map[0][0]-'A'] = true;
        dfs(1, 0, 0);
        System.out.print(max);
//        System.out.print(bfs(0,0));
    }

    private static void dfs(int depth, int x, int y) {
        if (max == 26) {
            return;
        } else if (depth == 26) {
            max = 26;
            return;
        }

        max = Math.max(depth, max);
        for (int[] d: di) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !check[map[nx][ny]-'A']) {
                check[map[nx][ny]-'A'] = true;
                dfs(depth+1, nx, ny);
                check[map[nx][ny]-'A'] = false;
            }
        }
    }

    // 메모리 초과
    private static int bfs(int x, int y) {
        int step = 0;
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(x,y,1 << (map[x][y]-'A')));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Move m = q.poll();
                for (int[] d: di) {
                    int nx = m.x + d[0];
                    int ny = m.y + d[1];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && (m.v & (1 << (map[nx][ny]-'A'))) == 0) {
                        q.add(new Move(nx, ny, m.v | (1 << (map[nx][ny]-'A'))));
                    }
                }
            }
            ++step;
        }
        return step;
    }

    private static class Move {
        int x;
        int y;
        int v; // 방문 체크 비트 마스킹
        public Move(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}
