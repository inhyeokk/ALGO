package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @date   	2020-03-17
 * @author 	rkddlsgur983
 * @memory 	37444KB / 256MB
 * @time   	142ms / 2초
 * @idea	입출력
 */
public class SWEA_D3_5431_민석이의과제체크하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean[] arr = new boolean[n];
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < k; ++i) {
				arr[Integer.parseInt(st.nextToken())-1] = true;
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < n; ++i) {
				if (!arr[i]) {
					sb.append(i+1).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
