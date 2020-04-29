package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link} 	https://www.acmicpc.net/problem/1967
 * @date   	2020-04-29
 * @author 	rkddlsgur983
 * @memory 	21996KB / 128MB
 * @time   	208ms / 2초
 * @idea	1. 루트부터 최대 거리의 노드(maxi)를 구한다.
 * 			2. maxi로부터 최대 거리의 노드를 구한다.
 * 			3. 이 두 노드 사이의 거리가 지름이다.
 */
public class BOJ_G4_1967_트리의지름 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		List<int[]>[] graph = new List[n];
		for (int i = 0; i < n; ++i) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < n-1; ++i) {
			st = new StringTokenizer(bf.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		bf.close();
		
		int max = 1;
		int maxi = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		int[] arr = new int[n];
		arr[0] = 1;
		while (!q.isEmpty()) {
			int i = q.poll();
			for (int[] j: graph[i]) {
				if (arr[j[0]] == 0) {
					arr[j[0]] = arr[i]+j[1];
					if (max < arr[j[0]]) {
						max = arr[j[0]];
						maxi = j[0];
					}
					q.add(j[0]);
				}
			}
		}
		
		max = 1;
		q.add(maxi);
		Arrays.fill(arr, 0);
		arr[maxi] = 1;
		while (!q.isEmpty()) {
			int i = q.poll();
			for (int[] j: graph[i]) {
				if (arr[j[0]] == 0) {
					arr[j[0]] = arr[i]+j[1];
					if (max < arr[j[0]]) {
						max = arr[j[0]];
					}
					q.add(j[0]);
				}
			}
		}
		System.out.print(max-1);
	}
}
