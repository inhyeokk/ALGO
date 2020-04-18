package boj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @date   2020-03-06
 * @author rkddlsgur983
 * @memory 25828KB / 512MB
 * @time   204ms / 2초
 */
public class BOJ_G5_16953_AB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		/* 1~10^9까지가 a와 b의 범위이기 때문에
		 * "2를 곱한다 or 1을 수의 가장 오른쪽에 추가한다"의
		 * 연산에서 Integer 범위를 넘어갈 수 있으므로 
		 * Long 타입으로 연산
		 */
		HashSet<Long> set = new HashSet<>();
		set.add(a);
		Queue<Long> queue = new LinkedList<>();
		queue.add(a);
		int step = 0;
		while (!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				long c = queue.poll();
				if (c == b) {
					System.out.println(step+1);
					return;
				}
				if (c*10+1 <= b && !set.contains(c*10+1)) {
					set.add(c*10+1);
					queue.add(c*10+1);
				}
				if (c*2 <= b && !set.contains(c*2)) {
					set.add(c*2);
					queue.add(c*2);
				}
			}
			++step;
		}
		System.out.print(-1);
	}
}
