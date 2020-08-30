package boj;

import java.util.Scanner;

/**
 * {@link} https://www.acmicpc.net/problem/13458
 * @author rkddlsgur983
 */
public class BOJ_13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();

        long num = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > b) {
                arr[i] -= b;
                num += Math.ceil(arr[i]/(double)c);
            }
            ++num;
        }
        System.out.print(num);
        sc.close();
    }
}
