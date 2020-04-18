package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @date   2020-03-11
 * @author rkddlsgur983
 * @memory 150476KB / 256MB
 * @time   653ms / 10초
 */
public class SWEA_D4_7701_염라대왕의이름정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		// 우선순위 큐 + 해시 셋 = 트리 셋
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int l1 = o1.length();
				int l2 = o2.length();
				if (l1 < l2) {
					return -1;
				} else if (l1 == l2) {
					return o1.compareTo(o2);
				} else {
					return 1;
				}
			}
		});
		HashSet<String> set = new HashSet<>();
		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(bf.readLine());
			for (int j = 0; j < n; ++j) {
				String s = bf.readLine();
				if (!set.contains(s)) {
					set.add(s);
					pq.add(s);
				}
			}
			sb.append("#").append(i).append("\n");
			while (!pq.isEmpty()) {
				sb.append(pq.poll()).append("\n");
			}
			set.clear();
		}
		System.out.print(sb);
		bf.close();
	}
}
