package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/10972
 * @date   	2020-05-21
 * @author 	lolol0705
 * @memory 	14836KB / 256MB
 * @time   	120ms / 1초
 * @idea	nextPermutation 구현
 */
public class BOJ_S3_10972_다음순열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		if (nextPermutation(arr, n)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				sb.append(arr[i]).append(" ");
			}
			System.out.print(sb);
		} else {
			System.out.print(-1);
		}
	}
	
	private static boolean nextPermutation(int[] arr, int n) {
		int i = n-2;
		for (; i >= 0; --i) {
			if (arr[i] < arr[i+1]) {
				break;
			}
		}
		if (i < 0) return false;
		
		int j = n-1;
		for (; j >= 0; --j) {
			if (arr[i] < arr[j]) {
				break;
			}
		}
		if (j < 0) return false;
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		for (int k = i+1, l = n-1; k < l; ++k, --l) {
			tmp = arr[k];
			arr[k] = arr[l];
			arr[l] = tmp;
		}
		return true;
	}
}
