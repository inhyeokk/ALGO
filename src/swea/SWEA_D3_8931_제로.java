package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_D3_8931_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int k = sc.nextInt();
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < k; j++) {
                int input = sc.nextInt();
                if (input == 0) {
                    s.pop();
                } else {
                    s.push(input);
                }
            }
            int sum = 0;
            while (!s.isEmpty()) {
                sum += s.pop();
            }
            System.out.printf("#%d %d", i, sum);
        }
        sc.close();
    }
}
