package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/13549
 * @date   	2020-03-18
 * @author 	rkddlsgur983
 * @memory 	18180KB / 512MB
 * @time   	176ms / 2초
 * @idea	우선순위 큐와 메모이제이션
 */
public class BOJ_G5_13549_숨바꼭질3 {
	private static final int N = 100001;
	private static final int[] memo = new int[N];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		bf.close();
		if (n == k) {
			System.out.print(0);
			return;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[n] = 0;
		pq.add(new int[] {n,0});
		while (!pq.isEmpty()) {
			int[] j = pq.poll();
			if (j[0] == k) {
				System.out.print(j[1]);
				return;
			}
			int next = j[0]*2;
			while (next < N && memo[next] > j[1]) {
				memo[next] = j[1];
				pq.add(new int[] {next,j[1]});
				next*=2;
			}
			next = j[0]+1;
			if (next < N && memo[next] > j[1]+1) {
				memo[next] = j[1]+1;
				pq.add(new int[] {next,j[1]+1});
			}
			next = j[0]-1;
			if (next >= 0 && memo[next] > j[1]+1) {
				memo[next] = j[1]+1;
				pq.add(new int[] {next,j[1]+1});
			}
		}
	}
}
