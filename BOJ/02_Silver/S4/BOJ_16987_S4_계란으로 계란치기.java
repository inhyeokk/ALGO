import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_s4_계란으로계란치기 {
	
	private static int max = 0;	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][2];
		StringTokenizer st;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			arr[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		dfs(arr, 0, n, 0); // 가장 왼쪽부터 시작
		System.out.print(max);
		bf.close();
	}
	
	private static void dfs(int[][] arr, int loc, int n, int cnt) {
		
		// 가장 오른쪽의 경우 종료
		if (loc == n) {
			max = max < cnt ? cnt : max;
			return;
		}
		// 손에 든 계란이 깨졌으면 넘어감
		if (arr[loc][0] == 0) {
			dfs(arr, loc+1, n, cnt);
			return;
		}
		
		boolean exist = false;
		for (int i = 0; i < n; ++i) {
			// 계란 치기
			if (loc != i && arr[i][0] > 0) {
				exist = true;
				int tmpa = arr[loc][0];
				int tmpc = cnt;
				arr[loc][0] -= arr[i][1];
				if (arr[loc][0] <= 0) {
					arr[loc][0] = 0;
					++cnt;
				}
				int tmpb = arr[i][0];
				arr[i][0] -= arr[loc][1];
				if (arr[i][0] <= 0) {
					arr[i][0] = 0;
					++cnt;
				}
				dfs(arr, loc+1, n, cnt);
				arr[loc][0] = tmpa;
				arr[i][0] = tmpb;
				cnt = tmpc;
			}
		}
		// 깨지지 않은 다른 계란이 없으면 넘어감
		if (!exist) {
			dfs(arr, loc+1, n, cnt);
			return;
		}
	}
}
