package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-29
 * @author 	rkddlsgur983
 * @memory 	76584KB / 256MB
 * @time   	302ms / 2초
 * @idea	단순계산
 */
public class SWEA_D4_4050_재관이의대량할인 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine(), " ");
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int result = 0;
			for (int i = n-1, c = 0; i >= 0; --i) {
				++c;
				if (c == 3) c = 0;
				else result += arr[i];
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
