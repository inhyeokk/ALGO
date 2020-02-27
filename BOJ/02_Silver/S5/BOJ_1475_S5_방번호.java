import java.util.Scanner;

/**
 * {@link} https://www.acmicpc.net/problem/1475
 * @author rkddlsgur983
 * @memory 14176KB
 * @time   104ms
 */
public class BOJ_1475_S5_방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.next().toCharArray();
		int[] set = new int[10];
		int max = 0;
		for (int i = 0, len = num.length; i < len; ++i) {
			if (num[i] == '6' || num[i] == '9') {
				if (set[6] < set[9]) {
					max = Math.max(++set[6], max);
				} else {
					max = Math.max(++set[9], max);
				}
			} else {
				max = Math.max(++set[num[i]-'0'], max);
			}
		}
		System.out.print(max);
		sc.close();
	}
}
