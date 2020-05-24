package algo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 선택정렬
 * i ~ n 범위에서 가장 작은 값을 i와 변경한다.
 * 0 ~ i-1(각 단계에서 배열의 앞부분)은 오름차순 정렬되어 있음
 * 수행횟수: n + n-1 + n-2 ... 2 + 1 = n*(n+1)/2
 * 시간 복잡도는 O(N^2)이다.
 * 버블정렬보다는 빠르다.
 */
public class 선택정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		selectionSort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void selectionSort(int[] arr) {
		
		for (int i = 0, len = arr.length; i < len-1; ++i) {
			int min = arr[i];
			int mini = i;
			for (int j = i+1; j < len; ++j) {
				if (min > arr[j]) {
					min = arr[j];
					mini = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[mini];
			arr[mini] = tmp;
		}
	}
}
