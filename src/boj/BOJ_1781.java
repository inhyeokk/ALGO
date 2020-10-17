package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * {@link}  https://www.acmicpc.net/problem/1781
 * @date    2020-10-17
 * @author  lolol0705
 * @memory  81520KB / 256MB
 * @time    1008ms / 2초
 */
public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int deadline = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            list.add(new int[] {deadline, cup});
        }
        list.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = n; i >= 1; --i) {
            while (!list.isEmpty() && i <= list.peek()[0]) {
                pq.add(list.poll()[1]);
            }
            if (!pq.isEmpty()) {
                cnt += pq.poll();
            }
        }
        System.out.print(cnt);
    }
}
