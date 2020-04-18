package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @date   	2020-04-18
 * @author 	rkddlsgur983
 * @memory 	17940KB / 256MB
 * @time   	111ms / 2초
 * @idea	3*n+3 = 3(n+1) 이므로 어떤 수를 나누어도 나머지는 3이된다.
 * 			문제에서 3의 경우 결과는 NO이므로 추가 연산을 하지 않아도 NO임을 알 수 있다.
 */
public class SWEA_D4_8993_하지추측 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			sb.append("#").append(t).append(" ");
			long n = Long.parseLong(br.readLine());
			String answer = "YES";
			while (n > 1) {
				if (n % 2 == 0) {
					n /= 2;
				} else {
					answer = "NO";
					break;
				}
			}
			sb.append(answer).append("\n");			
		}
		System.out.print(sb);
		br.close();
	}
}
