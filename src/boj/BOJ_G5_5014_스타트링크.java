package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/5014
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 150652KB /256MB
 * @time   376ms / 1초
 */
public class BOJ_G5_5014_스타트링크 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		/* BFS 탐색
		 * 범위가 1~1000000이기 때문에 방문 배열을 쓰지 않고
		 * HashSet으로 중복 체크 함
		 */
		HashSet<Integer> set = new HashSet<>();
		set.add(s);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		int step = 0;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int v = queue.poll();
				if (v == g) {
					System.out.print(step);
					return;
				}
				if (v+u <= f && !set.contains(v+u)) {
					set.add(v+u);
					queue.add(v+u);
				}
				if (v-d >= 1 && !set.contains(v-d)) {
					set.add(v-d);
					queue.add(v-d);
				}
			}
			++step;
		}
		System.out.print("use the stairs");
		bf.close();
	}
}
