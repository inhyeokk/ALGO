import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * {@link} https://www.acmicpc.net/problem/1541
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 14248KB / 128MB
 * @time   100ms / 2초
 */
public class BOJ_1541_S2_잃어버린괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		List<Long> num = new LinkedList<>();
		List<Character> op = new LinkedList<>();
		/* 탐욕법
		 * '+'와 '-'로 이루어진 식에서 
		 * 괄호를 추가했을 때 최소가 되도록 하기 위해서는
		 * 더하기 연산을 먼저 다하고 빼기 연산을 마지막에 하면 됨
		 */
		long tmp = 0;
		for (char c: arr) {
			if (c == '+' || c == '-') {
				long before = 0;
				if (!op.isEmpty() && op.get(op.size()-1) == '+') {
					before = num.remove(num.size()-1);
					op.remove(op.size()-1);
				}
				num.add(before+tmp);
				op.add(c);
				tmp = 0;
			} else {
				tmp *= 10;
				tmp += c - '0';
			}
		}
		long before = 0;
		if (!op.isEmpty() && op.get(op.size()-1) == '+') {
			before = num.remove(num.size()-1);
			op.remove(op.size()-1);
		}
		num.add(before+tmp);
		long ans = num.remove(0);
		while (!num.isEmpty()) {
			ans -= num.remove(0);
		}
		System.out.print(ans); 
		sc.close();
	}
}