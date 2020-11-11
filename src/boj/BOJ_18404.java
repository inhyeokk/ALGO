package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * {@link}  https://www.acmicpc.net/problem/18404
 * @date    2020-11-12
 * @author  lolol0705
 * @memory  27180KB / 256MB
 * @time    288ms / 1초
 */
public class BOJ_18404 {
    private static final int[][] di = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        map[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        List<int[]> list = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            list.add(new int[] {x,y});
        }
        br.close();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d: di) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    queue.add(new int[] {nr,nc});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] pos: list) {
            sb.append(map[pos[0]][pos[1]]-1).append(" ");
        }
        System.out.print(sb);
    }
}
