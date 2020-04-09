import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @date   	2020-04-09
 * @author 	rkddlsgur983
 * @memory 	31972KB / 256MB
 * @time   	165ms / 2초
 * @idea	탐욕법
 */
public class SWEA_D3_4371_항구에들어오는배 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n-1];
			Map<Integer, Integer> map = new HashMap<>();
			br.readLine(); // 첫 날 제외
			for (int i = 0; i < n-1; ++i) {
				arr[i] = Integer.parseInt(br.readLine());
				map.put(arr[i], i); // 방문 표시를 위한 인덱스 저장
			}
			boolean[] visit = new boolean[n];
			int cnt = 0;
			for (int i = 0; i < n-1; ++i) {
				if (!visit[i]) { // 방문하지 않았다면 새로운 배
					visit[i] = true;
					int start = arr[i];
					int step = arr[i]-1; // 첫 날과의 차이가 이 배의 주기
					while (map.containsKey(start+step)) { // 주기만큼 늘려감
						start += step;
						visit[map.get(start)] = true; // 방문 표시
					}
					++cnt;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
