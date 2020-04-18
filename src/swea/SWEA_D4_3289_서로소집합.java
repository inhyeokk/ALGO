package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-03-31
 * @author 	rkddlsgur983
 * @memory 	114476KB / 256MB
 * @time   	496ms / 4초
 * @idea	Union-Find
 */
public class SWEA_D4_3289_서로소집합 {
	private static int n, m;
	private static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n];
			for (int i = 1; i < n; ++i) {
				map[i] = i;
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;

				a = find(a);
				b = find(b);
				if (o == 0) {
					if (a != b) {
						map[b] = a;
					}
				} else {
					if (a == b) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	private static int find(int x) {
		if (map[x] == x) {
			return x;
		}
		return map[x] = find(map[x]);
	}
}
