import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16943_S1_숫자재배치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		int bnum = Integer.parseInt(String.valueOf(b));
		sc.close();
		
		// a가 b보다 작으면 불가능
		if (a.length > b.length) {
			System.out.print(-1);
			return;
		}
		char[] tmp = a.clone();
		Arrays.sort(tmp);
		// 가장 작은 a가 b보다 크면 불가능
		if (Integer.parseInt(String.valueOf(tmp)) > bnum) {
			System.out.print(-1);
			return;
		}
		for (int i = 0; i < a.length; ++i) {
			a[a.length-1-i] = tmp[i];
		}
		do {
			if (a[0] == '0') {
				System.out.print(-1);
				break;
			}
			if (Integer.parseInt(String.valueOf(a)) <= bnum) {
				System.out.print(a);
				break;
			}
		} while(prevPermutation(a));
		return;
	}
	
	private static boolean prevPermutation(char[] arr) {
		int i = arr.length-2;
		for (; i >= 0; --i) {
			if (arr[i] > arr[i+1]) {
				break;
			}
		}
		if (i < 0) return false;
		
		int j = arr.length-1;
		for (; j >= 0; --j) {
			if (arr[i] > arr[j]) {
				break;
			}
		}
		if (j < 0) return false;
		
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		for (int k = i+1, o = arr.length-1; k < o; ++k, --o) {
			tmp = arr[k];
			arr[k] = arr[o];
			arr[o] = tmp;
		}		
		return true;
	}
}
