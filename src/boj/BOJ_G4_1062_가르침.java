package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/1062
 * @date   	2020-05-21
 * @author 	rkddlsgur983
 * @memory 	13512KB / 128MB
 * @time   	120ms / 1초
 * @idea	비트마스킹, 백트래킹, 완전 탐색
 * 		1. 공통 문자 antic 제외하고 시작
 * 		1-1. arr[i]에 a~z에 해당하는 비트마스킹
 * 		1-2. range에 arr[i]의 합집합 표시
 * 		2. k가 5보다 작으면 antic를 포함할 수 없으므로 0 종료
 * 		3. 순서가 관계없으므로 문자 조합에 대한 완전탐색
 * 		3-1. 최대 개수 max가 단어 개수 n과 동일하면 탐색 종료
 * 		3-2. depth가 k 또는 arr[i]의 합집합에 속한 문자 개수와 동일하면 종료 하고 가능한 단어를 셈
 * 		3-3. 마스킹된 비트로 &연산하여 하기 전과 후가 동일하면 배울 수 있는 단어이므로 증가
 * 		4. 구해진 최대값 출력
 */
public class BOJ_G4_1062_가르침 {
	private static int n, k, max, range, maxlen;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; ++i) {
			String s = br.readLine(); // antic 제외
			for (int j = 0, len = s.length(); j < len; ++j) {
				int v = s.charAt(j) - 'a';
				if (v == 0 || v == 2 || v == 8 || v == 13 || v == 19) continue;
				arr[i] |= 1 << v;
				if ((range & 1 << v) == 0) ++maxlen;
				range |= 1 << v;
			}
		}
		br.close();
		
		if (k < 5) {
			System.out.print(0);
			return;
		}
		k -= 5;
		dfs(0,0,0);
		System.out.println(max);
	}
	
	private static void dfs(int depth, int start, int v) {
		if (max == n) {
			return;
		} else if (depth == k || depth == maxlen) {
			int cnt = 0;
			for (int j = 0; j < n; ++j) {
				if ((arr[j] & v) == arr[j]) {
					++cnt;
				}
			}
			max = Math.max(cnt, max);
			return;
		}
		
		for (int i = start; i < 26; ++i) {
			if (((range & 1 << i) > 0) && (v & 1 << i) == 0) {
				dfs(depth+1, i+1, v | (1 << i));
			}
		}
	}
}
