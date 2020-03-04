import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7988_D4_내전경기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String[][] input = new String[100][2];
		Queue<Integer> queue = new LinkedList<>();
		int t = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= t; ++i) {
			int k = Integer.parseInt(bf.readLine());
			
			/* 몇 명이 입력되는지 모르기때문에
             * 입력을 input배열에 저장하면서
             * HashMap에 입력되는 input과 해당 인덱스를 매핑
             */
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < k; ++j) {
				st = new StringTokenizer(bf.readLine(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				if (!map.containsKey(a)) {
					map.put(a, map.size());
				}
				if (!map.containsKey(b)) {
					map.put(b, map.size());
				}
				input[j][0] = a;
				input[j][1] = b;
			}
			
			/* 시너지 관계를 저장하기 위한 인접 그래프에
             * input에 해당하는 인덱스로 추가
             */
			int size = map.size();
			List<Integer>[] graph = new LinkedList[size];
			for (int j = 0; j < k; ++j) {
				int a = map.get(input[j][0]);
				int b = map.get(input[j][1]);
				if (graph[a] == null) {
					graph[a] = new LinkedList<>();
				}
				if (graph[b] == null) {
					graph[b] = new LinkedList<>();
				}
				graph[a].add(b);
				graph[b].add(a);
			}
			
			/* 시너지 효과를 내지 않고 
             * 2개의 팀으로 분리할 수 있는지 확인
             */
			int[] team = new int[size];
			boolean possible = true;
			for (int j = 0; j < size; ++j) {
				if (team[j] == 0) {
					team[j] = 1;
					queue.add(j);
				}
				while(!queue.isEmpty()) {
					int idx = queue.poll();
					for (Integer l: graph[idx]) {
						if (team[l] == 0) {
							if (team[idx] == 1) {
								team[l] = 2;
							} else {
								team[l] = 1;
							}
							queue.add(l);
						} else if (team[l] == team[idx]){
							possible = false;
							queue.clear();
							break;
						}
					}
				}
				if(!possible) break;
			}
			sb.append("#").append(i).append(" ");
			if (possible) {
				sb.append("Yes");
			} else {
				sb.append("No");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
}
