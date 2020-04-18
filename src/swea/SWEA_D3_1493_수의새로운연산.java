package swea;

import java.util.Scanner;
 
public class SWEA_D3_1493_수의새로운연산 {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            int p = sc.nextInt();
            int q = sc.nextInt();
            int n = getWidth(40000);
            int[][] map = new int[n][n]; // 1~n
             
            int cnt = 1;
            int ax = 0, ay = 0, bx = 0, by = 0;
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    if (cnt == p) {
                        ax = j-k;
                        ay = k+1;
                    } else if (cnt == q) {
                        bx = j-k;
                        by = k+1;
                    }
                    map[j-k][k+1] = cnt++;
                }
            }
            sb.append(map[ax+bx][ay+by]).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
     
    private static int getWidth(int num) {
        int idx = 1;
        for (int n = 0; n < num;) {
            n += idx++;
        }
        return idx;
    }
}