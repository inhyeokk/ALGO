import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-03-15
 * @author 	rkddlsgur983
 * @memory 	20228KB / 256MB
 * @time   	93ms / 2초
 * @idea	b까지 구간합 - a-1까지 구간합
 * 			입력 범위가 0 ~ 10^15이므로 합을 구할 때 범위가 넘어가지 않도록 주의할 것.
 * 			0~9: 	45*1
 * 			0~99:	45*20
 * 			0~999:	45*300
 * 			0~9999:	45*4000
 */
public class SWEA_5604_D4_구간합 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; ++tc) {
			st = new StringTokenizer(bf.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long ans = 0L;
			int len = b == 0 ? 1 : (int)Math.log10(b)+1;
			while (len > 1) {
				long divide = (long)Math.pow(10, len-1);
				long end = b / divide;
				ans += len > 1 ? (long)(45*(len-1)*Math.pow(10, len-2)*end) : 0;
				for (long i = 1L; i < end; ++i) {
					ans += i * divide; // 35000일때 29999까지 구간합
				}
				b %= divide; // 5000
				ans += end * (b+1);
				--len;
			}
			for (long i = 1L; i <= b; ++i) {
				ans += i;
			}
			
			--a;
			len = a == 0 ? 1 : (int)Math.log10(a)+1;
			while (len > 1) {
				long divide = (long)Math.pow(10, len-1);
				long end = a / divide;
				ans -= len > 1 ? (long)(45*(len-1)*Math.pow(10, len-2)*end) : 0;
				for (long i = 1L; i < end; ++i) {
					ans -= i * divide;
				}
				a %= divide;
				ans -= end * (a+1);
				--len;
			}
			for (long i = 1L; i <= a; ++i) {
				ans -= i;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
