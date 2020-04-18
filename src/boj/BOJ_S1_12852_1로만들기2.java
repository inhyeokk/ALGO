package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S1_12852_1로만들기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Oper> queue = new LinkedList<>();
		List<Integer> tmp = new LinkedList<>();
		tmp.add(n);
		queue.add(new Oper(n, tmp));
		boolean[] visit = new boolean[n+1];
		visit[n] = true;
		while (!queue.isEmpty()) {
			Oper o = queue.poll();
			if (o.n == 1) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.order.size()-1).append("\n");
				for (Integer i: o.order) {
					sb.append(i).append(" ");
				}
				System.out.print(sb);
				break;
			}
			if (o.n % 3 == 0 && !visit[o.n/3]) {
				visit[o.n/3] = true;
				int x = o.n / 3;
				List<Integer> l = new LinkedList<>(o.order);
				l.add(x);
				queue.add(new Oper(x, l));
			}
			if (o.n % 2 == 0 && !visit[o.n/2]) {
				visit[o.n/2] = true;
				int x = o.n / 2;
				List<Integer> l = new LinkedList<>(o.order);
				l.add(x);
				queue.add(new Oper(x, l));
			}
			if (!visit[o.n-1]) {
				visit[o.n-1] = true;
				--o.n;
				o.order.add(o.n);
				queue.add(o);
			}
		}
		sc.close();
	}
	
	static class Oper {
		int n;
		List<Integer> order;
		public Oper(int n, List<Integer> order) {
			this.n = n;
			this.order = order;
		}
	}
}
