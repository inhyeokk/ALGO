package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/2579
 * @date   	2020-04-16
 * @author 	lolol0705
 * @memory 	249172KB / 256MB
 * @time   	904ms / 2초
 * @idea	병합정렬로만 가능 / Arrays.sort()는 시간초과
 */
public class BOJ_S5_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		int[] result = mergeSort(arr, 0, arr.length-1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(result[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int[] mergeSort(int[] arr, int s, int e) {
		if (s == e) {
			return new int[] {arr[s]};
		}
		
		int[] brr = mergeSort(arr, s, (s+e)/2);
		int[] crr = mergeSort(arr, (s+e)/2+1, e);
		int i = 0, b = 0, c = 0;
		int blen = brr.length, clen = crr.length, len = blen+clen;
		int[] result = new int[len];
		while (b < blen && c < clen) {
			result[i++] = brr[b] < crr[c] ? brr[b++] : crr[c++]; 
		}
		while (b < blen) {
			result[i++] = brr[b++];
		}
		while (c < clen) {
			result[i++] = crr[c++];
		}
		return result;
	}
}
