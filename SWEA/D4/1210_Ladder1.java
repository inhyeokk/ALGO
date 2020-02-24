import java.util.Scanner;
 
public class Solution {
     
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            int t = sc.nextInt();
            sb.append("#").append(t).append(" ");
            int[][] arr = new int[100][100];
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
             
            int target = 0;
            for (int j = 0; j < 100; j++) {
                if (arr[99][j] == 2) {
                    target = j;
                    break;
                }
            }
             
            int row = 99, col = target;
            int direction = 0;
            while (row > 0) {
                if ((direction == 0 || direction == 1) && isValid(row, col-1) && arr[row][col-1] == 1) { // 좌
                    direction = 1;
                    col -= 1;
                } else if ((direction == 0 || direction == 2) && isValid(row, col+1) && arr[row][col+1] == 1) { // 우
                    direction = 2;
                    col += 1;
                } else { // 상
                    direction = 0;
                    row -= 1;
                }
            }
            sb.append(col).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
     
    private static boolean isValid(int row, int col) {
        return row >= 0 && row < 100 && col >= 0 && col < 100;
    }
}