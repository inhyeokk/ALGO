package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-18
 * @author 	rkddlsgur983
 * @memory 	21620KB / 256MB
 * @time   	127ms / 2초
 * @idea	정렬 후 n부터 1까지 선택할 수 있는 다이아몬드 개수를 탐색
 * 			해당 범위에서 가장 큰 값과 작은 값의 차가 K보다 작거나 같으면
 * 			i개를 선택할 수 있으므로 탐색 종료
 */
public class SWEA_D4_9088_다이아몬드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			here:
			for (int i = n; i >= 1; --i) {
				for (int j = 0; j < n; ++j) {
					if (j+i > n) break;
					if (arr[j+i-1] - arr[j] <= k) {
						sb.append("#").append(t).append(" ").append(i).append("\n");
						break here;
					}
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}
