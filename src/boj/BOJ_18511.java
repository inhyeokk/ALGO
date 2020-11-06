package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/18511
 * @date    2020-11-06
 * @author  lolol0705
 * @memory  11508KB / 256MB
 * @time    104ms / 1초
 */
public class BOJ_18511 {
    private static int n, k;
    private static int[] num;
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        num = new int[k];
        for (int i = 0; i < k; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        dfs(0);
        System.out.print(max);
    }

    private static void dfs(int m) {
        if (m > n) return;
        max = Math.max(m, max);
        for (int i = 0; i < k; ++i) {
            dfs(m * 10 + num[i]);
        }
    }
}
