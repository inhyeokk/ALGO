package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * {@link}  https://www.acmicpc.net/problem/1644
 * @date    2020-11-10
 * @author  lolol0705
 * @memory  28164KB / 128MB
 * @time    292ms / 2초
 */
class BOJ_1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>(); // 소수
        int result = 0;
        int sum = 0;
        boolean[] num = new boolean[n+1];
        for (int i = 2; i <= n; ++i) {
            if (!num[i]) {
                queue.add(i);
                sum += i;
                if (sum > n) {
                    while (!queue.isEmpty() && sum > n) {
                        sum -= queue.poll();
                    }
                }
                if (sum == n) ++result;
            }
            for (int j = i; j <= n; j+=i) {
                num[j] = true;
            }
        }
        System.out.print(result);
    }
}