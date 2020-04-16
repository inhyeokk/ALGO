import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @{link}	https://www.acmicpc.net/problem/1463
 * @date   	2020-04-16
 * @author 	rkddlsgur983
 * @memory 	18212KB / 128MB
 * @time   	112ms / 2초
 * @idea	동적 계획법
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
