import java.util.Scanner;

public class G4_17281_야구 {
	private static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] play = new int[n][9];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 9; ++j) {
				play[i][j] = sc.nextInt();
			}
		}
		// 2 ~ 9번
		int[] tmp = new int[8];
		for (int i = 0, cnt = 1; i < 8;) {
			tmp[i++] = cnt++;
		}
		// nextPermutation으로 타선 바꾸고
		// 4번타자 추가
		int[] hit = new int[9];
		do {
			for (int i = 0; i < 3; ++i) {
				hit[i] = tmp[i];
			}
			hit[3] = 0;
			for (int i = 4; i < 9; ++i) {
				hit[i] = tmp[i-1];
			}
			dfs(0, 0, 0, n, play, hit);
		} while (nextPermutation(tmp));
		System.out.println(max);
		sc.close();
	}
	
	private static void dfs(int i, int score, int ining, int n, int[][] play, int[] hit) {
		if (ining == n) {
			max = max < score ? score : max;
			return;
		}

		int a=0, b=0, c=0;
		int out = 0;
		while (out < 3) {
			int result = play[ining][hit[i++]];
			if (i == 9) i = 0;
			switch (result) {
				case 0:
					++out;
					break;
				case 1:
					if (c == 1) {
						++score;
						c = 0;
					}
					if (b == 1) {
						c = 1;
						b = 0;
					}
					if (a == 1) {
						b = 1;
						a = 0;
					}
					a = 1;
					break;
				case 2:
					if (c == 1) {
						++score;
						c = 0;
					}
					if (b == 1) {
						++score;
						b = 0;
					}
					if (a == 1) {
						c = 1;
						a = 0;
					}
					b = 1;
					break;
				case 3:
					if (c == 1) {
						++score;
						c = 0;
					}
					if (b == 1) {
						++score;
						b = 0;
					}
					if (a == 1) {
						++score;
						a = 0;
					}
					c = 1;
					break;
				case 4:
					if (c == 1) {
						++score;
						c = 0;
					}
					if (b == 1) {
						++score;
						b = 0;
					}
					if (a == 1) {
						++score;
						a = 0;
					}
					++score;
					break;
				}
		}
		dfs(i, score, ining+1, n, play, hit);
	}
	
	private static boolean nextPermutation(int[] arr) {
		int i=6;
		for (; i >= 0; --i) {
			if (arr[i] < arr[i+1]) {
				break;
			}
		}
		if (i < 0)
			return false;
		int j=7;
		for (; j >= 0; --j) {
			if (arr[i] < arr[j]) {
				break;
			}
		}
		if (j < 0) {
			return false;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		for (int k = i+1, l = 7; k < l; ++k,--l) {
			temp = arr[k];
			arr[k] = arr[l];
			arr[l] = temp;
		}
		return true;
	}
}
