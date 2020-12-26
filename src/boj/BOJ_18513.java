package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * {@link}  https://www.acmicpc.net/problem/18513
 * @date    2020-12-26
 * @author  lolol0705
 * @memory  18513KB / 256MB
 * @time    604ms / 1초
 */
public class BOJ_18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int x = Integer.parseInt(st.nextToken());
            set.add(x);
            queue.add(x);
        }
        br.close();

        int cur = 0;
        int step = 1;
        long sum = 0L;
        here:
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; ++i) {
                int x = queue.poll();
                if (!set.contains(x - 1)) {
                    set.add(x - 1);
                    queue.add(x - 1);
                    cur += 1;
                    sum += step;
                    if (cur == k) break here;
                }
                if (!set.contains(x + 1)) {
                    set.add(x + 1);
                    queue.add(x + 1);
                    cur += 1;
                    sum += step;
                    if (cur == k) break here;
                }
            }
            step += 1;
        }

        System.out.print(sum);
    }
}
