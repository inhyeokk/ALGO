package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @memory 	29200KB / 262144KB
 * @time   	151ms / 2초
 * @idea	제곱근의 경우는 그냥 구하돼,
 * 			1씩 더하는 경우 n과 가장 가까운 제곱수까지 
 * 			cnt를 한번에 더한다면 시간을 대폭 줄일 수 있다.
 */
public class SWEA_D5_6782_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			long n = Long.parseLong(br.readLine());
			int cnt = 0;
			while (n != 2) {
				double m = Math.sqrt(n);
				if (Math.floor(m) == Math.ceil(m)) {
					n = (long) m;
					++cnt;
				} else {
					int k = (int)m;
					cnt += (k+1)*(k+1)-n+1;
					n = k+1;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
