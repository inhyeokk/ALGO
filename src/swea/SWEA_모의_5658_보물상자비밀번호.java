package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @date   	2020-04-29
 * @author 	rkddlsgur983
 * @memory 	23736KB / 256MB
 * @time   	105ms / 3초
 * @idea	시뮬레이션
 * 			Integer.parseInt(str, radix) => str을 radix진수로 변환
 */
public class SWEA_모의_5658_보물상자비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			String s = bf.readLine();
			for (int i = 0, len = n/4; i < len; ++i) {
				for (int j = i; j < i+n; j+=len) {
					int m = 0;
					int cnt = len-1;
					for (int l = j; l < j+len; ++l, --cnt) {
						char c = s.charAt(l%n);
						int v = 0;
						if (Character.isDigit(c)) {
							v = c-'0';
						} else {
							v = c-'A'+10;
						}
						m += v*Math.pow(16, cnt);
					}
					set.add(m);
				}
			}
			int j = 1;
			for (Integer i: set) {
				if (j++==k) {
					sb.append("#").append(t).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
		bf.close();
	}
}
