import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/2623
 * @date   	2020-03-24
 * @author 	rkddlsgur983
 * @memory 	15708KB / 128MB
 * @time   	128ms / 1초
 * @idea	위상정렬
 */
public class BOJ_G2_2623_음악프로그램 {
	private static int n, m;
	private static int[][] arr;
	private static List<Integer>[]graph;
	private static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][];
		graph = new LinkedList[n];
		cnt = new int[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			arr[i] = new int[Integer.parseInt(st.nextToken())];
			for (int j = 0, len = arr[i].length; j < len; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken())-1;
			}
		}
		bf.close();
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0, len = arr[i].length; j < len-1; ++j) {
				for (int k = j+1; k < len; ++k) {
					graph[arr[i][j]].add(arr[i][k]);
					++cnt[arr[i][k]];
				}
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			if (cnt[i] == 0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		while (!queue.isEmpty()) {
			int i = queue.poll();
			sb.append(i+1).append("\n");
			++ans;
			while (!graph[i].isEmpty()) {
				int j = graph[i].remove(0);
				--cnt[j];
				if (cnt[j] == 0) {
					queue.add(j);
				}
			}
		}
		if (ans == n) {
			System.out.print(sb);
		} else {
			System.out.print(0);
		}
	}
}
