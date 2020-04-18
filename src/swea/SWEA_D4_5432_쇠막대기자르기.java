import java.util.Scanner;

public class D4_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			char[] str = sc.next().toCharArray();
			int ans = 0, cnt = 0;
			for (int j = 0, len = str.length; j < len; ++j) {
				if (str[j] == '(') {
					if (str[j+1] == ')') {
						ans+=cnt;
						++j;
					} else {
						++cnt;
					}
				} else {
					++ans;
					--cnt;
				}
			}
			sb.append("#").append(i).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
