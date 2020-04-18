package swea;

import java.util.Scanner;

public class SWEA_D3_6808_규영이와인영이의카드게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			int[] arr = new int[9];
			boolean[] card = new boolean[19];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				card[arr[j]] = true;
			}
			int[] brr = new int[9];
			for (int j = 1, k = 0; j <= 18 && k < 9; j++) {
				if (!card[j]) brr[k++] = j;
			}
			
			int win = 0, lose = 0;
			do {
				int score = 0;
				for (int j = 0; j < 9; j++) {
					if (arr[j] > brr[j]) {
						score += arr[j] + brr[j];
					} else if (arr[j] < brr[j]) {
						score -= arr[j] + brr[j];
					}
				}
				if (score > 0) {
					win++;
				} else if (score < 0) {
					lose++;
				}
			} while (nextPermutation(brr));
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static boolean nextPermutation(int[] arr) {
		int i = arr.length-2;
		for (; i >= 0; i--) {
			if (arr[i] < arr[i+1]) {
				break;
			}
		}
		if (i < 0) return false;
		
		int j = arr.length-1;
		for (; j >= 0; j--) {
			if (arr[i] < arr[j]) {
				break;
			}
		}
		if (j < 0) return false;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		for (int k = i+1, o = arr.length-1; k < o; k++, o--) {
			temp = arr[k];
			arr[k] = arr[o];
			arr[o] = temp;
		}
		return true;
	}
}
