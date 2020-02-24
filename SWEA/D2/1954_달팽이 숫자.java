import java.util.Scanner;
 
public class Solution {
     
    private static int size;
    private static int[][] arr;
    private static int[][] di = {{0,1}, {1,0}, {0,-1}, {-1,0}};
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append("\n");
            size = sc.nextInt();
            arr = new int[size][size];
             
            int cnt = 1, max = size * size;
            int direction = 0, row = 0, col = -1;
            while (cnt <= max) {
                int nr = row + di[direction][0];
                int nc = col + di[direction][1];
                if (isValid(nr, nc)) {
                    arr[nr][nc] = cnt++;
                    row = nr;
                    col = nc;
                } else {
                    if (++direction == 4) 
                        direction = 0;
                }
            }
             
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    sb.append(arr[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
        sc.close();
    }
     
    private static boolean isValid(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && arr[row][col] == 0;
    }
}