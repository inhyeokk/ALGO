package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/12851
 * @date   	2020-03-18
 * @author 	rkddlsgur983
 * @memory 	31760KB / 512MB
 * @time   	152ms / 2초
 * @idea	BFS 탐색 시 가장 빠른 시간으로 찾는 방법이 
 * 			몇 가지 인지 구해야 하므로 방문 체크 위치가 이전과 다름
 * 			-> 동일 step에서 같은 위치를 다른 곳에서 방문해도 되기 때문에
 * 			   poll 될때 방문 체크 해주어야 함
 */
public class BOJ_G5_12851_숨바꼭질2 {
	private static final int N = 100001;
	private static final boolean[] visit = new boolean[N];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		bf.close();
		if (n == k) {
			System.out.printf("%d\n%d",0,1);
			return;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int step = 0;
		int find = 0;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int j = queue.poll();
				visit[j] = true;
				int next = j*2;
				if (next < N && !visit[next]) {
					if (next == k) {
						++find;
						continue;
					}
					queue.add(next);
				}
				next = j+1;
				if (next < N && !visit[next]) {
					if (next == k) {
						++find;
						continue;
					}
					queue.add(next);
				}
				next = j-1;
				if (next >= 0 && !visit[next]) {
					if (next == k) {
						++find;
						continue;
					}
					queue.add(next);
				}
			}
			++step;
			if (find > 0) {
				System.out.printf("%d\n%d",step,find);
				return;
			}
		}
	}
}
