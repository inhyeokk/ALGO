package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-05-24
 * @author 	rkddlsgur983
 * @memory 	20144KB / 256MB
 * @time   	591ms / 2초
 * @idea   	왼쪽 저울의 무게가 항상 오른쪽 저울의 무게보다 크거나 같아야 하므로
 * 		DFS 가지를 두개로 나눈다.
 * 		다만 남은 경우를 모두 오른쪽 저울에 올려도 왼쪽보다 작은 경우
 * 		2^n * n!로 한번에 경우의 수를 구할 수 있다.
 * 		여기서 pow연산과 fac연산을 직접하게 되면 1487ms가 걸렸던 것에 비해
 * 		아래와 같이 경우에 따른 값을 저장해 쓰게되면 시간이 절반 이하로 줄어든다.
 */
public class SWEA_D4_3234_준환이의양팔저울 {
	private static int[] arr = new int[9];
	private static int n, cnt;
	private static int[] pow = {1,2,4,8,16,32,64,128,256,512};
	private static int[] fac = {1,1,2,6,24,120,720,5040,40320,362880};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			cnt = 0;
			dfs(0, 0, 0, 0, sum);
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static void dfs(int depth, int select, int left, int right, int sum) {
		if (depth == n) {
			++cnt;
			return;
		} else if (left >= right + sum) {
			cnt += pow[n-depth] * fac[n-depth];
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if ((select & 1 << i) == 0) {
				dfs(depth+1, select | 1 << i, left+arr[i], right, sum-arr[i]);
				if (left >= right + arr[i]) {
					dfs(depth+1, select | 1 << i, left, right+arr[i], sum-arr[i]);
				}
			}
		}
	}
}
