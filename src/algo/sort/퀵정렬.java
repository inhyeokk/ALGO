package algo.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 오름차순 퀵정렬
 * 피봇 기준 오른쪽 범위에 대해 정렬하기 위해 a = pivot+1, b = e로 초기 위치를 설정한다.
 * a는 피봇보다 큰 값의 위치까지 오른쪽으로 이동하고
 * b는 피봇보다 작은 값의 위치까지 왼쪽으로 이동하는데
 * a와 b가 서로 엇갈리지 않아야한다.
 * 각 단계에서 엇갈리지 않는다면 a와 b를 swap하고 엇갈렸다면 b와 pivot을 swap하고 반복을 종료한다.
 * 여기서 결정된 b의 위치를 기준으로 범위를 분할하여 재귀적으로 정렬한다.
 * (내림차순은 부등호 방향을 반대로)
 * 
 * 퀵정렬은 분할정복을 기반으로하여 평균 O(NlogN)의 시간 복잡도를 가진다. 
 * 하지만 피봇이 분할을 적절히 해주지 못하는 경우에는
 * (정렬 범위 중 첫번째 위치를 피봇으로 가정하고 배열이 이미 정렬되어있는 경우)
 * 최악 O(N^2)의 시간 복잡도를 가진다.
 * 병합정렬의 단계별 n배열 만큼의 메모리를 생성하는 것과는 달리
 * 퀵정렬은 피봇을 기준으로 분할하기 때문에 추가 메모리는 사용하지 않는다.
 */
public class 퀵정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		quickSort(arr, 0, arr.length-1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void quickSort(int[] arr, int s, int e) {

		if (s >= e) return;
		
		int pivot = s;
		int a = s+1, b = e;
		while (a <= b) {
			while (a <= b && arr[pivot] >= arr[a]) ++a;
			while (a <= b && arr[pivot] <= arr[b]) --b;
			if (a <= b) {
				int tmp = arr[a];
				arr[a] = arr[b];
				arr[b] = tmp;
			} else {
				int tmp = arr[b];
				arr[b] = arr[pivot];
				arr[pivot] = tmp;
			}
		}
		
		quickSort(arr, s, b-1);
		quickSort(arr, b+1, e);
	}
}
