package algo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 병합정렬
 * 각 재귀 단계의 배열 범위를 절반으로 나눈다.
 * 나누어진 두 배열의 길이만큼 새로운 배열을 생성한다.
 * 두 배열에서 오름차순인 경우 작은 값을 꺼내면서 새로운 배열에 저장한다.
 * 둘 중 한 배열이 끝까지 저장되었다면 나머지 배열을 마저 저장한다.
 * 
 * 병합정렬의 시간 복잡도는 O(NlogN)을 보장한다.
 * 하지만 각 재귀 단계에서 N길이 만큼의 배열을 추가로 생성하므로 메모리 공간이 소모되는 단점이 있다. * 
 */
public class 병합정렬 {
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
