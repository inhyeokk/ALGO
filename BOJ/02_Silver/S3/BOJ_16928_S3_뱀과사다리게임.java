import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_S3_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[101];
		for (int i = 0; i < n+m; ++i) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}
		bf.close();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		int roll = 0; // 몇 번 굴리는지
		boolean[] visit = new boolean[101];
		while(!queue.isEmpty()) {
			for (int i = 0, size = queue.size(); i < size; ++i) {
				int loc = queue.poll();
				if (loc == 100) {
					System.out.print(roll);
					return;
				}
				for (int j = 1; j <= 6; ++j) {
					if (loc + j <= 100) { // 범위 체크
						if (arr[loc+j] == 0 && !visit[loc+j]) {
							queue.add(loc+j);
							visit[loc+j] = true;
						} else if (arr[loc+j] != 0 && !visit[arr[loc+j]]){
							queue.add(arr[loc+j]);
							visit[arr[loc+j]] = true;
						}
					}
				}
			}
			++roll;
		}
	}
}
