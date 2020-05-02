package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @date   	2020-05-01
 * @author 	rkddlsgur983
 * @memory 	22008KB / 256MB
 * @time   	107ms / 2초
 * @idea	진수계산
 */
public class SWEA_D4_4366_정식이의은행업무 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			String ns = bf.readLine();
			String ms = bf.readLine();
			int n = Integer.parseInt(ns, 2);
			int m = Integer.parseInt(ms, 3);
			here:
			for (int i = 1, nlen = ns.length(); i < nlen; ++i) {
				int x = ns.charAt(i)-'0';
				int xi = (int) Math.pow(2, nlen-1-i);
				if (x == 0) n += xi;
				else n -= xi;
				for (int j = 0, mlen = ms.length(); j < mlen; ++j) {
					int y = ms.charAt(j)-'0';
					int yj = (int) Math.pow(3, mlen-1-j)*y;
					m -= yj;
					for (int k = 0; k < 3; ++k) {
						if (j==0 && k==0) continue;
						if (k == y) continue;
						int yk = 0;
						if (k > 0) {
							yk = (int) Math.pow(3, mlen-1-j)*k;
						}
						m += yk;
						if (n == m) {
							sb.append("#").append(t).append(" ").append(n).append("\n");
							break here;
						}
						m -= yk;
					}
					m += yj;
				}
				if (x == 0) n -= xi;
				else n += xi;
			}
		}
		System.out.print(sb);
		bf.close();
	}
}
