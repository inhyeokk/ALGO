import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D3_5603_건초더미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < n; ++j) {
				int s = sc.nextInt();
				sum += s;
				pq.add(s);
			}
			int avg = sum/n;
			int cnt = 0;
			while (!pq.isEmpty()) {
				int p = pq.poll();
				if (p > avg) {
					cnt += p-avg;
				} else {
					pq.clear();
				}
			}
			sb.append("#").append(i).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
