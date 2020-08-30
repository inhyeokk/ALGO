package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_D3_1225_암호생성기_Queue {

	private static final int N = 8;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int t = sc.nextInt();
			sb.append("#").append(t).append(" ");
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int j = 0; j < N; j++) {
				int n = sc.nextInt();
				queue.offer(n);
			}
			
			int cnt = 1;
			while (queue.peek()-cnt > 0) {
				int tmp = queue.poll() - cnt++;
				queue.offer(tmp);
				if (cnt == 6) cnt = 1;
			}
			queue.poll();
			queue.offer(0);
			
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
