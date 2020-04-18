package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-03-17
 * @author 	rkddlsgur983
 * @memory 	22592KB / 256MB
 * @time   	110ms / 2초
 * @idea	단순 계산
 */
public class SWEA_D3_5515_2016년요일맞추기 {
	private static int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int ans = 3+d;
			for (int i = 0; i < m-1; ++i) {
				ans += day[i];
			}
			sb.append("#").append(t).append(" ").append(ans%7).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
