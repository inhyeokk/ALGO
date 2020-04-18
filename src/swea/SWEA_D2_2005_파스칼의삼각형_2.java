package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D2_2005_파스칼의삼각형_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		int[] arr = new int[56];
		arr[0] = 1;
		for (int j = 1; j < 10; ++j) {
			int start = j*(j+1)/2;
			int end = (j+1)*(j+2)/2-1;
			arr[start] = 1;
			arr[end] = 1;
			int up = (j-1)*j/2;
			for (int k = start+1; k < end; ++k, ++up) {
				arr[k] = arr[up] + arr[up+1];
			}
		}
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			sb.append("#").append(i).append("\n");
			for (int j = 1, cnt = 0; j <= n; ++j) {
				for (int k = 0; k < j; ++k) {
					sb.append(arr[cnt++]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		bf.close();
	}
}
