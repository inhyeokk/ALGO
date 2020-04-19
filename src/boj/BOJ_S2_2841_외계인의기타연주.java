package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/2841
 * @date   	2020-04-19
 * @author 	rkddlsgur983
 * @memory 	132708KB / 256MB
 * @time   	680ms / 1초
 * @idea	스택
 * 			특정 줄에서 낮은 음을 연주하려면 누르고 있던 높은 음의 프렛의 손가락을 떼어야하므로
 * 			최소 손가락의 움직임을 위해 스택의 top과 비교하여 연산
 */
public class BOJ_S2_2841_외계인의기타연주 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int s = 6;
		Stack<Integer>[] stack = new Stack[s];
		for (int i = 0; i < s; ++i) {
			stack[i] = new Stack<>();
		}
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken());
			while (!stack[j].isEmpty() && stack[j].peek() > k) {
				stack[j].pop();
				++cnt;
			}
			if (stack[j].isEmpty() || stack[j].peek() < k) {
				stack[j].add(k);
				++cnt;
			}
		}
		System.out.print(cnt);
		br.close();
	}
}
