import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-16
 * @author 	rkddlsgur983
 * @memory 	18180KB / 64MB
 * @time   	263ms / 1000ms
 * @idea	플로이드 와샬
 */
public class JA_1108_페이지전환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(graph[i], 50000);
		}
		int max = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a][b] = 1;
			max = Math.max(Math.max(a, b), max);
		}
		br.close();
		
		for (int k = 0; k <= max; ++k) {
			for (int i = 0; i <= max; ++i) {
				if (k == i) continue;
				for (int j = 0; j <= max; ++j) {
					if (k == j || i == j) continue;
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		float sum = 0;
		for (int i = 0; i <= max; ++i) {
			for (int j = 0; j <= max; ++j) {
				if (i == j || graph[i][j] == 50000) continue;
				sum += graph[i][j];
			}
		}
		System.out.print(String.format("%.3f", sum / ((max+1)*max)));
	}
}
