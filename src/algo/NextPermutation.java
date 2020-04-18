package algo;
import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		do {
			System.out.println(Arrays.toString(arr));
		} while (nextPermutation(arr));
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
		
		for (int k=i+1, l=arr.length-1; k < l; ++k,--l) {
			tmp = arr[k];
			arr[k] = arr[l];
			arr[l] = tmp;
		}
		return true;
	}
}
