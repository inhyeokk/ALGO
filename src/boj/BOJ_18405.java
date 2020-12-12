package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * {@link}  https://www.acmicpc.net/problem/18405
 * @date    2020-12-12
 * @author  lolol0705
 * @memory  19592KB / 256MB
 * @time    212ms / 1초
 */
public class BOJ_18405 {
    private static int[][] di = {{0,-1},{0,1},{-1,0},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        LinkedList<Virus> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    list.add(new Virus(i, j, map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        br.close();

        Collections.sort(list);

        for (int i = 0; i < s; ++i) {
            for (int j = 0, size = list.size(); j < size; ++j) {
                Virus virus = list.removeFirst();
                for (int[] d: di) {
                    int nr = virus.r + d[0];
                    int nc = virus.c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                        map[nr][nc] = map[virus.r][virus.c];
                        list.add(new Virus(nr, nc, map[nr][nc]));
                    }
                }
            }
        }

        System.out.print(map[x][y]);
    }

    private static class Virus implements Comparable<Virus> {
        int r;
        int c;
        int v;

        public Virus(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(v, o.v);
        }
    }
}
