package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-18
 * @author 	rkddlsgur983
 * @memory 	259332KB / 256MB
 * @time   	8142ms / 15초
 * @idea	우선순위 큐
 * 			과제 제출 일자가 day보다 작으면 day는 di-ti일이 되고
 * 			반대의 경우는 day에서 ti만큼 빼주어야 가능한 최대 값이 된다.
 */
public class SWEA_D4_8998_세운이는내일할거야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o2[1], o1[1]);
				}
			});
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int t1 = Integer.parseInt(st.nextToken());
				int d1 = Integer.parseInt(st.nextToken());
				pq.add(new int[] {t1,d1});
			}
			int day = Integer.MAX_VALUE;
			while (!pq.isEmpty()) {
				int[] i = pq.poll();
				if (day > i[1]) {
					day = i[1] - i[0];
				} else {
					day -= i[0];
				}
			}
			sb.append("#").append(t).append(" ").append(day).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
