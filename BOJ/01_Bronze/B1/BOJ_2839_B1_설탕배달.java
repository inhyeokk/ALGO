import java.util.Scanner;

/**
 * @{link} https://www.acmicpc.net/problem/2839
 * @date   2020-03-10
 * @author rkddlsgur983
 * @memory 14272KB / 128MB
 * @time   104ms / 1초
 */
public class BOJ_2839_B1_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int a = n/5;
		while (a >= 0) {
			if ((n-5*a)%3 == 0) {
				System.out.print(a+(n-5*a)/3);
				return;
			}
			--a;
		}
		System.out.println(-1);
	}
}
