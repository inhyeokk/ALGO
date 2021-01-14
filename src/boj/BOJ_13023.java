package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/13023
 * @date    2021-01-14
 * @author  lolol0705
 * @memory  19844KB / 512MB
 * @time    260ms / 2초
 */
public class BOJ_13023 {
    private static List<Integer>[] list;
    private static boolean[] visit;
    private static boolean isExist = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new List[n];
        for (int i = 0; i < n; ++i) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        br.close();

        visit = new boolean[n];
        for (int i = 0; i < n; ++i) {
            visit[i] = true;
            dfs(0, i);
            if (isExist) break;
            visit[i] = false;
        }
        System.out.print(isExist ? 1 : 0);
    }

    private static void dfs(int depth, int cur) {
        if (depth == 4) {
            isExist = true;
            return;
        }

        for (int i: list[cur]) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth+1, i);
                if (isExist) break;
                visit[i] = false;
            }
        }
    }
}
