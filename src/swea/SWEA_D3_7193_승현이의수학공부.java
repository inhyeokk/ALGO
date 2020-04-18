package swea;

import java.util.Scanner;
 
public class SWEA_D3_7193_승현이의수학공부 {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            int n = sc.nextInt();
            String x = sc.next();
            sb.append(getNum(n, x)%(n-1)).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
    
    /* 0보다 크거나 같은 모든 k에 대해
     * n^(k) % (n-1) ≡ 1을 만족한다.
     */
    private static long getNum(int n, String x) {
    	long num = 0;
    	int len = x.length();
    	for (int i = 0; i < len; i++) {
    		num += (x.charAt(i)-'0');
    	}
    	return num;
    }
}