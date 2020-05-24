package algo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 삽입정렬
 * i위치의 값을 i-1부터 0까지 역순으로 보면서 삽입될 위치를 찾는다.
 * arr[j]가 arr[i]보다 크다면 오른쪽으로 한칸씩 옮긴다.
 * 시간 복잡도는 O(N^2)이다.
 * O(N^2) 알고리즘 중 가장 빠르다.
 */
public class 삽입정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		insertionSort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void insertionSort(int[] arr) {
		for (int i = 1, len = arr.length; i < len; ++i) {
			int tmp = arr[i];
			for (int j = i-1; j >= 0; --j) {
				if (tmp < arr[j]) {
					arr[j+1] = arr[j];
					if (j == 0) arr[j] = tmp;
				} else {
					arr[j+1] = tmp;
					break;
				}
			}
		}
	}
}
