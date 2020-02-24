package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_10972_다음순열 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		if (nextPermutation(arr)) {
			for (int i = 0; i < n; ++i) {
				sb.append(arr[i]).append(" ");
			}
		} else {
			sb.append(-1);
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static boolean nextPermutation(int[] arr) {
		int i = arr.length-2;
		for (; i >= 0; --i) {
			if (arr[i] < arr[i+1]) {
				break;
			}
		}
		if (i < 0) return false;
		
		int j = arr.length-1;
		for (; j >= 0; --j) {
			if (arr[i] < arr[j]) {
				break;
			}
		}
		if (j < 0) return false;
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		for (int k = i+1, o = arr.length-1; k < o; ++k,--o) {
			tmp = arr[k];
			arr[k] = arr[o];
			arr[o] = tmp;
		}
		return true;
	}
}
