import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@link} https://www.acmicpc.net/problem/1100
 * @date   2020-03-07
 * @author rkddlsgur983
 * @memory 12924KB / 128MB
 * @time   72ms / 2초
 */
public class BOJ_1100_B2_하얀칸 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = 8;
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			String s = bf.readLine();
			for (int j = 0; j < n; ++j) {
				ans += i%2 == j%2 && s.charAt(j) == 'F' ? 1 : 0;
			}
		}
		System.out.print(ans);
		bf.close();
	}
}
