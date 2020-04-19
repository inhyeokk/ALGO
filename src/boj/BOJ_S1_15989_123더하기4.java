package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link} 	https://www.acmicpc.net/problem/15989
 * @date   	2020-04-19
 * @author 	rkddlsgur983
 * @memory 	14076KB / 128MB
 * @time   	108ms / 1초
 * @idea	1. 1만 선택하는 경우 1개
 * 			2. 2와 3을 선택하는 경우(나머지는 1로 채움) 2의 선택 개수에 따른 3의 가능 개수+1
 * 			3. 3을 선택하는 경우(나머지는 1로 채움) 3의 선택 가능 개수를 더함
 */
public class BOJ_S1_15989_123더하기4 {
	private static int n, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			n = Integer.parseInt(br.readLine());
			cnt = 1; // 1만 선택
			for (int i = n-2; i >= 0; i-=2) { // 2와 3을 선택 (나머지는 1로 채움)
				int j = i/3;
				cnt += j+1;
			}
			cnt += n/3; // 3을 선택 (나머지는 1로 채움)
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
