import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @memory 	24036KB / 256MB
 * @time   	134ms / 2초
 * @idea	큰 수일수록 나누기 연산을 적게해야
 * 			최종 값이 최대값이 될 수 있으므로
 * 			오름차순 정렬한 다음 k번 순차적으로 연산
 */
public class SWEA_D4_6719_성수의프로그래밍강좌시청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double ans = 0;
			for (int i = n-k; i < n; ++i) {
				ans = (ans+arr[i])/2;
			}
			sb.append("#").append(t).append(" ").append(String.format("%.6f", ans)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
