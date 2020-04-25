package algo.dp;

import java.util.Arrays;

/**
 * LIS 최장 증가 수열
 * O[NlogN]
 * - 8 다음에 2가 올 경우 버리지 않고, LIS를 구성할 수 있는 위치에 저장해둔다.
 */
public class LIS_2 {
	public static void main(String[] args) {
		int[] a = {8,2,4,3,6,11,7,10,14,5};
		int[] C = new int[a.length];
		int size = 0; // LIS 개수 관리할 변수
		
		C[size++] = a[0]; // 첫번째 숫자는 바로 반영
		for (int i = 1; i < a.length; ++i) {
			// C배열의 마지막 숫자와 수열값을 비교
			if (C[size-1] < a[i]) {
				C[size++] = a[i]; // 맨 뒤에 뭍임
			} else { // LIS 마지막 숫자보다 크지 않으면 LIS의 값을 업데이트 (이진탐색)
				int temp = Arrays.binarySearch(C, 0, size, a[i]);
				if (temp < 0) temp = -temp -1;
				C[temp] = a[i]; // 수열의 값을 LIS에 삽입할 위치에 덮어쓰기
			}
		}
		System.out.println("C: " + Arrays.toString(C));
		System.out.println("LIS 개수: " + size);
	}
	
	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];
			
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1);  // key not found.
	}
}
