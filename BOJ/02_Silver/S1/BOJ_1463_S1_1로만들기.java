import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * {@link} https://www.acmicpc.net/problem/1463
 * @author rkddlsgur983
 * @memory 18240KB
 * @time   112ms
 */
public class BOJ_1463_S1_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		queue.add(0);
		while (!queue.isEmpty()) {
			int x = queue.poll();
			int step = queue.poll();
			if (x == 1) {
				System.out.print(step);
				break;
			}
			if (x%3 == 0 && arr[x/3] == 0) {
				arr[x/3] = step+1;
				queue.add(x/3);
				queue.add(step+1);
			}
			if (x%2 == 0 && arr[x/2] == 0) {
				arr[x/2] = step+1;
				queue.add(x/2);
				queue.add(step+1);
			}
			if (arr[x-1] == 0) {
				arr[x-1] = step+1;
				queue.add(x-1);
				queue.add(step+1);
			}
		}
		sc.close();
	}
}
