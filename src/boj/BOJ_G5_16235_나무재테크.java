package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/16235
 * @date   	2020-03-25
 * @author 	rkddlsgur983
 * @memory 	282596KB / 512MB
 * @time   	1144ms / 0.3초
 * @idea	시뮬레이션
 */
public class BOJ_G5_16235_나무재테크 {
	private static int n, m, k, x, y, z;
	private static int[][] map, feed;
	private static final int[][] di = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		feed = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				feed[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			pq.add(new int[] {x,y,z});
		}
		br.close();
		
		Queue<int[]> tmp = new LinkedList<>();
		Queue<int[]> dead = new LinkedList<>();
		for (int year = 0; year < k; ++year) {
			for (int i = 0, size = pq.size(); i < size; ++i) {
				int[] t = pq.poll();
				if (map[t[0]][t[1]] >= t[2]) {
					map[t[0]][t[1]] -= t[2];
					++t[2];
					tmp.add(t);
					if (t[2] % 5 == 0) {
						for (int[] d: di) {
							int nr = t[0] + d[0];
							int nc = t[1] + d[1];
							if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
								tmp.add(new int[] {nr,nc,1});
							}
						}
					}
				} else {
					dead.add(t);
				}
			}
			while (!dead.isEmpty()) {
				int[] t = dead.poll();
				map[t[0]][t[1]] += t[2]/2;
			}
			while (!tmp.isEmpty()) {
				int[] t = tmp.poll();
				pq.add(t);
			}
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					map[i][j] += feed[i][j];
				}
			}
		}
		System.out.println(pq.size());
	}
}
