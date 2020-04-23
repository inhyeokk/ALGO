package algo.dp;

import java.util.Scanner;

/**
 * 월말평가 소금배달문제
 * 탐욕법
 * 한계: 만약 담을 수 있는 그릇의 수가 3kg 5kg 7kg 11kg으로 더 많다면
 * 		or 소금 봉지의 무게 종류가 정해지지 않았다면 탐욕법으로는 불가능하다.
 */
public class 소금배달1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		sc.close();
		/* 3kg 5kg
		 * cnt = M/5 + M%5 / 3; // 가설이 틀림
		 * 21kg
		 * 18
		 * 15
		 */
		int cnt = 0;
		while (M % 5 != 0) { // 5로 나누어 떨어지지 않는다면
			M -= 3;
			++cnt;
		}
		if (M < 0) { // 음수
			System.out.print(-1);
		} else {
			cnt += M/5;
			System.out.print(cnt);
		}
	}
}
