package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/14567
 * @date    2020-11-12
 * @author  rkddlsgur983
 * @memory  134320KB / 256MB
 * @time    552ms / 5초
 */
public class BOJ_14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n];
        Queue<Integer>[] child = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            child[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            child[a].add(b);
            ++parent[b];
        }
        br.close();

        int[] result = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (parent[i] == 0) {
                queue.add(i);
            }
        }

        int cur = 1;
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; ++i) {
                int x = queue.poll();
                result[x] = cur;
                while (!child[x].isEmpty()) {
                    int y = child[x].poll();
                    if (--parent[y] == 0) {
                        queue.add(y);
                    }
                }
            }
            ++cur;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb);
    }
}
