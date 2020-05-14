package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1806
 * @date   	2020-05-14
 * @author 	rkddlsgur983
 * @memory 	23976KB / 128MB
 * @time   	924ms / 1초
 * @idea	1. 한 자리수만으로 m 이상인 경우는 1로 종료
 * 			2. 전체를 더했을 때 m보다 작으면 불가능 하므로 0
 * 			3. 1부터 n-1까지 i부터 n까지의 값들을 더해가면서 최소가되는 길이 len을 찾음
 * 			4. 이때 최소가 될 수 있는 길이는 2이고 2인 경우를 찾으면 종료
 */
public class BOJ_G3_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		int sum = 0;
		int len = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] >= m) {
				System.out.print(1);
				return;
			}
			sum += arr[i];
			if (sum <= m) ++len;
		}
		br.close();
		if (sum < m) {
			System.out.print(0);
			return;
		}
		for (int i = 1; i < n-1; ++i) {
			sum = arr[i];
			int l = 2;
			for (int j = i+1; j < n; ++j, ++l) {
				if (len <= l) break;
				sum += arr[j];
				if (sum >= m) {
					len = l;
					break;
				}
			}
			if (len == 2) break;
		}
		System.out.print(len);
	}
}
