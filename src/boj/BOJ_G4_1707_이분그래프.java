package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1707
 * @date   	2020-03-27
 * @author 	rkddlsgur983
 * @memory 	295092KB / 256MB
 * @time   	1164ms / 2초
 * @idea	이분 그래프
 */
public class BOJ_G4_1707_이분그래프 {
	public static void main(String[] args) throws IOException {
		// 입력을 위한 br 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 한줄로 입력받은 문자열을 띄어쓰기로 구분하기 위한 st객체
		StringTokenizer st;
		// 출력문 추가를 위한 sb 객체 생성
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스의 수를 t에 입력
		int t = Integer.parseInt(br.readLine());
		// 입력받은 테스트 케이스만큼 반복
		for (int tc = 0; tc < t; ++tc) {
			// 문자열 입력
			st = new StringTokenizer(br.readLine(), " ");
			// 정점의 개수 v 입력
			int v = Integer.parseInt(st.nextToken());
			// 간선의 개수 e 입력
			int e = Integer.parseInt(st.nextToken());
			// 그래프를 연결리스트 배열로 관리
			List<Integer>[] graph = new LinkedList[v];
			// 연결리스트 배열 초기화
			for (int i = 0; i < v; ++i) {
				graph[i] = new LinkedList<>();
			}
			// 두 정점을 입력받고 그래프에 양방향 연결
			for (int i = 0; i < e; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				graph[a].add(b);
				graph[b].add(a);
			}
			// 이분 그래프 방문 처리를 위한 배열
			int[] visit = new int[v];
			// BFS 탐색을 위한 큐 생성
			Queue<Integer> queue = new LinkedList<>();
			// 이분그래프인지 여부를 담는 boolean 값
			boolean possible = true;
			here: // 반복문 전체 종료를 위한 here
			for (int i = 0; i < v; ++i) {
				// 방문하지 않았다면 1로 변경하고 BFS 시작
				if (visit[i] == 0) {
					visit[i] = 1;
					queue.add(i);
					/* BFS 탐색하면서 
					 * 현재 정점의 값과 같다면 
					 * 이분 그래프가 아니므로 반복문 종료
					 * 인접 정점이 방문되어있지 않다면 
					 * 현재 정점의 값과 반대로(*-1) 설정
					 */
					while (!queue.isEmpty()) {
						int j = queue.poll();
						for (Integer k: graph[j]) { // j와 연결된 인접정점 순회
							if (visit[j] == visit[k]) {
								possible = false;
								break here; // 반복문 전체(here까지) 종료
							} else if (visit[k] == 0) {
								visit[k] = visit[j]*-1;
								queue.add(k);
							}
						}
					}
				}
			}
			// 가능 여부에 따른 출력
			if (possible) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
