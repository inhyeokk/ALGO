package swea;
import java.util.Scanner;

/**
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 115860KB / 262144KB
 * @time   647ms / 2초
 */
public class SWEA_D4_4796_의석이의우뚝선산 {
	public static void main(String[] args) {
		/* input의 수가 많아 BufferedReader로 입력받으면
		 * 런타임 에러 발생 -> Scanner로 해결
		 * 백준 14719 빗물과 유사
		 */
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[50000];
		int[] left = new int[50000];
		int[] right = new int[50000];
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			int before = Integer.MAX_VALUE;
			for (int j = 0; j < n; ++j) {
				arr[j] = sc.nextInt();
				// 왼쪽에서 현재 값보다 작은 값들의 수를 저장
				if (before < arr[j]) {
					left[j] = left[j-1]+1;
				} else {
					left[j] = 0;
				}
				before = arr[j];
			}
			before = Integer.MAX_VALUE;
			for (int j = n-1; j >= 0; --j) {
				// 오른쪽에서 현재 값보다 작은 값들의 수를 저장
				if (before < arr[j]) {
					right[j] = right[j+1]+1;
				} else {
					right[j] = 0;
				}
				before = arr[j];
			}
			long ans = 0;
			for (int j = 0; j < n; ++j) {
				// left[j]와 right[j]의 곱이 현재 기준 우뚝 선 산의 개수
				ans += left[j]*right[j];
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
