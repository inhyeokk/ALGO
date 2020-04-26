package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/9466
 * @date   	2020-04-27
 * @author 	rkddlsgur983
 * @memory 	293188KB / 256MB
 * @time   	1500ms / 3초
 * @idea	깊이우선탐색하면서 경로를 큐에 담는다.
 * 			현재 방문 위치(3)를 다시 방문한다면 싸이클이 형성되었으므로
 * 			싸이클 내부에 있는 학생(1)들은 그룹이 될 수 있다.
 * 			반대로 싸이클 외부에 있는 학생(2)들은 그룹이 될 수 없으며
 * 			아직 그룹이 가능한지 확인하지 않은 학생(0)은 
 * 			이미 그룹이거나 그룹이 될수 없는 학생을 선택하면 이 학생(2) 또한 그룹이 될 수 없다.
 */
public class BOJ_G5_9466_텀프로젝트 {
	private static int n;
	private static int[] arr = new int[100000], possible = new int[100000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken())-1;
				possible[i] = 0; // 0: 아직, 1: 그룹O, 2: 그룹X, 3: 현재 방문
			}
			
			int cnt = 0;
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < n; ++i) {
				if (possible[i] == 0) {
					possible[i] = 3;
					queue.add(i);
					int j = arr[i];
					while (possible[j] == 0) {
						possible[j] = 3;
						queue.add(j);
						j = arr[j];
					}
					if (possible[j] == 3) { // 그룹 가능
						boolean visit = false;
						while (!queue.isEmpty()) {
							int k = queue.poll();
							if (visit || j == k) {
								visit = true;
								possible[k] = 1;
							} else {
								possible[k] = 2;
								++cnt;
							}
						}
					} else { // queue 전부 그룹 불가능
						while (!queue.isEmpty()) {
							++cnt;
							possible[queue.poll()] = 2;
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
