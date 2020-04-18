package jungol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class JO_1863_종교 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] list = new ArrayList[n+1];
		for (int i = 0; i < m; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (list[a] == null) {
				list[a] = new ArrayList<>();
			}
			list[a].add(b);
			if (list[b] == null) {
				list[b] = new ArrayList<>();
			}
			list[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n+1];
		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			if (visit[i]) continue;
			visit[i] = true;
			queue.add(i);
			while (!queue.isEmpty()) {
				int stu = queue.poll();
				if (list[stu] == null) continue;
				for (int s: list[stu]) {
					if (!visit[s]) { // stu와 같은 s
						visit[s] = true;
						queue.add(s);
					}
				}
			}
			++ans;
		}
		System.out.print(ans);
		sc.close();
	}
}
