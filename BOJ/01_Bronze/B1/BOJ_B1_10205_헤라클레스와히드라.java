import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @{link}	https://www.acmicpc.net/problem/10205
 * @date   	2020-04-12
 * @author 	rkddlsgur983
 * @memory 	13152KB / 256MB
 * @time   	76ms / 1초
 * @idea	단순계산
 */
public class BOJ_B1_10205_헤라클레스와히드라 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= k; ++i) {
			int h = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int j = 0, len = str.length(); j < len; ++j) {
				switch (str.charAt(j)) {
					case 'c':
						++h;
						break;
					case 'b':
						--h;
						break;
				}
				if (h == 0) break;
			}
			sb.append(String.format("Data Set %d:\n", i)).append(h).append("\n\n");
		}
		System.out.print(sb);
		br.close();
	}
}
