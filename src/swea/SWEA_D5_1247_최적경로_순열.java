package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   2020-02-29
 * @author rkddlsgur983
 * @memory 32560KB / 262144KB
 * @time   1035ms / 20초
 */
public class SWEA_D5_1247_최적경로_순열 {
    private static final int[][] arr = new int[12][2];
    private static int N;
    private static final int[] perm = new int[10];
    private static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= t; ++i) {
            N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N+2; ++j) {
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < N; ++j) {
                perm[j] = j+2; // 순열 초기화
            }
            min = Integer.MAX_VALUE;
            do {
                int route = Math.abs(arr[0][0]-arr[perm[0]][0])+Math.abs(arr[0][1]-arr[perm[0]][1]);
                if (min <= route) continue;
                for (int j = 1; j < N; ++j) {
                    route += Math.abs(arr[perm[j-1]][0]-arr[perm[j]][0])+Math.abs(arr[perm[j-1]][1]-arr[perm[j]][1]);
                    if (min <= route) break;
                }
                route += Math.abs(arr[perm[N-1]][0]-arr[1][0])+Math.abs(arr[perm[N-1]][1]-arr[1][1]);
                if (min <= route) continue;
                min = route;
            } while(nextPermutation(perm));
            sb.append("#").append(i).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
        bf.close();
    }

    private static boolean nextPermutation(int[] perm) {
        int i = N-2;
        for (; i >= 0; --i) {
            if (perm[i] < perm[i+1]) {
                break;
            }
        }
        if (i < 0) return false;

        int j = N-1;
        for (; j >= 0; --j) {
            if (perm[i] < perm[j]) {
                break;
            }
        }
        if (j < 0) return false;

        int tmp = perm[i];
        perm[i] = perm[j];
        perm[j] = tmp;

        for (int k = i+1, l = N-1; k < l; ++k, --l) {
            tmp = perm[k];
            perm[k] = perm[l];
            perm[l] = tmp;
        }
        return true;
    }
}
