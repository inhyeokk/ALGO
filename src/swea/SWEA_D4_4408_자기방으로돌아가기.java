package swea;

import java.io.IOException;
import java.util.Scanner;
 
public class SWEA_D4_4408_자기방으로돌아가기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] map = new int[201];
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            sb.append("#").append(i).append(" ");
            int n = sc.nextInt();
            for (int j = 0; j < n; ++j) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a > b) {
                	int temp = a;
                	a = b;
                	b = temp;
                }
                for (int k = (int)Math.ceil(a/2.0); k <= Math.ceil(b/2.0); ++k) {
                	++map[k];
                }
            }
            int max = 0;
            for (int j = 0; j < 201; ++j) {
            	max = max < map[j] ? map[j] : max;
            	map[j] = 0;
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}