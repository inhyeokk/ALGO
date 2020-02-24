/**************************************************************
Problem: 1828
User: rkddlsgur983
Language: Java
Result: Success
Time:269 ms
Memory:10248 kb
****************************************************************/


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JA_1828_냉장고 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
        arr[i][0] = sc.nextInt();
        arr[i][1] = sc.nextInt();
    }
    Arrays.sort(arr, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]){
                return 0;
            } else {
                return 1;
            }
        }
    });
    int in = arr[0][0], out = arr[0][1];
    int ans = 0;
    for (int i = 1; i < n; i++) {
        // 범위 좁힘
        if (in < arr[i][0]) {
            in = arr[i][0];
        }
        if (out > arr[i][1]) {
            out = arr[i][1];
        }
        if (in > out) {
            ++ans;
            in = arr[i][0];
            out = arr[i][1];
        }
    }
    System.out.println(ans+1);
    sc.close();
}
}