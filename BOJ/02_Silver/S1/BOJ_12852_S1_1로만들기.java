import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12852_S1_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Oper> queue = new LinkedList<>();
		List<Integer> tmp = new LinkedList<>();
		tmp.add(n);
		queue.add(new Oper(n, tmp));
		int[] weight = new int[n+1];
		weight[n] = 0;
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
			if (o.n % 3 == 0 && (weight[o.n / 3]==0 || weight[o.n / 3] > o.order.size())) {
				weight[o.n / 3] = o.order.size();
				int x = o.n / 3;
				List<Integer> l = new LinkedList<>(o.order);
				l.add(x);
				queue.add(new Oper(x, l));
			}
			if (o.n % 2 == 0 && (weight[o.n / 2]==0 || weight[o.n / 2] > o.order.size())) {
				weight[o.n / 2] = o.order.size();
				int x = o.n / 2;
				List<Integer> l = new LinkedList<>(o.order);
				l.add(x);
				queue.add(new Oper(x, l));
			}
			if (weight[o.n-1]==0 || weight[o.n-1] > o.order.size()) {
				weight[o.n-1] = o.order.size();
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
