package algo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 버블정렬
 * 0부터 len-i까지 보면서 arr[j]보다 arr[j+1]이 더 작을 경우 swap한다.
 * len-i ~ len(각 단계에서 배열의 뒷부분)은 오름차순 정렬되어 있음
 * 수행횟수: n + n-1 + n-2 ... 2 + 1 = n*(n+1)/2
 * 시간 복잡도는 O(N^2)이다.
 * 정렬 알고리즘 중 가장 느리다.
 */
public class 버블정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		bubbleSort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bubbleSort(int[] arr) {
		
		for (int i = 1, len = arr.length; i < len; ++i) {
			for (int j = 0; j < len-i; ++j) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
