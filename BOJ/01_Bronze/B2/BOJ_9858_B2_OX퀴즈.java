import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9858_b2_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String result = br.readLine();
			int score = 0, cnt = 0;
			for (int j = 0, len = result.length(); j < len; j++) {
				if (result.charAt(j) == 'O') {
					score += ++cnt;
				} else {
					cnt = 0;
				}
			}
			sb.append(score).append("\n");
		}		
		System.out.print(sb);
		br.close();
	}
}
