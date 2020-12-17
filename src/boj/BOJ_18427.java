package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/18427
 * @date   2020-12-17
 * @author lolol0705
 * @memory 16240KB / 256MB
 * @time   144ms / 1초
 */
public class BOJ_18427 {
    private static int n;
    private static int h;
    private static List<Integer>[] lists;
    private static final int DIV = 10007;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        lists = new List[n];
        dp = new int[n][h];
        for (int i = 0; i < n; ++i) {
            lists[i] = new ArrayList<>(m);
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                lists[i].add(Integer.parseInt(st.nextToken()));
            }
            Arrays.fill(dp[i], -1); // 초기화
        }
        br.close();

        System.out.print(dfs(0, 0));
    }

    private static int dfs(int depth, int cur) {
        if (cur > h) {
            return 0;
        } else if (cur == h) {
            return 1;
        } else if (depth == n) {
            return 0;
        }
        if (dp[depth][cur] != -1) {
            return dp[depth][cur];
        }

        int sum = dfs(depth + 1, cur); // 블록 사용하지 않는 경우
        for (Integer value: lists[depth]) { // 블록 사용하는 경우
            sum += dfs(depth + 1, cur + value);
            sum %= DIV;
        }
        dp[depth][cur] = sum;
        return dp[depth][cur];
    }
}
