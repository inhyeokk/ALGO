import java.util.Scanner;
 
class Solution {
     
    private static int max = -1;
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = arr[j] + arr[k];
                    if (sum <= m)
                        max = Integer.max(sum, max);
                }
            }
            sb.append(max).append("\n");
            max = -1;
        }
        System.out.println(sb);
        sc.close();
    }
}