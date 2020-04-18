package swea;

import java.util.HashSet;
import java.util.Scanner;
 
  
public class SWEA_D4_3752_가능한시험점수 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
 
            set.clear();
            boolean[] dp = new boolean[10001];
            dp[0] = true;
            for (int j = 0; j < n; j++) {
                for (int k = 10000-arr[j]; k >= 0; k--) {
                    if (dp[k]) {
                        dp[k+arr[j]] = true;
                        set.add(k+arr[j]);
                    }
                }
            }
            sb.append(set.size()+1).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}