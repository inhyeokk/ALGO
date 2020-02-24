package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1247_D5_최적경로 {
	private static int[][] arr = new int[12][2];
	private static int N;
	private static int min;
	private static boolean[] visit = new boolean[10];
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
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; ++j) {
				visit[j] = true;
				bruteForce(j+2, 1, Math.abs(arr[0][0]-arr[j+2][0])+Math.abs(arr[0][1]-arr[j+2][1]));
				visit[j] = false;
			}
			sb.append("#").append(i).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void bruteForce(int start, int depth, int route) {
		if (depth == N) {
			route += Math.abs(arr[1][0]-arr[start][0]) + Math.abs(arr[1][1]-arr[start][1]);
			min = min > route ? route : min;
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			if (!visit[i]) {
				visit[i] = true;
				bruteForce(i+2, depth+1, 
						route+Math.abs(arr[start][0]-arr[i+2][0])+Math.abs(arr[start][1]-arr[i+2][1]));
				visit[i] = false;
			}
		}
	}
}
