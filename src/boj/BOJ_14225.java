package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/14225
 * @date    2021-01-14
 * @author  lolol0705
 * @memory  13516KB / 512MB
 * @time    96ms / 2초
 */
public class BOJ_14225 {
    private static final int MAX = 2000001;
    private static int n;
    private static int[] arr;
    private static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        check = new boolean[MAX];
        dfs(0,0);
        for (int i = 1; i < MAX; ++i) {
            if (!check[i]) {
                System.out.print(i);
                break;
            }
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            check[sum] = true;
            return;
        }
        dfs(depth+1, sum);
        dfs(depth+1, sum + arr[depth]);
    }
}
