package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-02
 * @author rkddlsgur983
 * @memory 21812KB / 128MB
 * @time   80ms / 2초
 */
public class BOJ_S1_2251_물통 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int[] bo = new int[3];
		for (int i = 0; i < 3; ++i) {
			bo[i] = Integer.parseInt(st.nextToken());
		}
		
		// A B C의 경우에 따른 방문 체크
		boolean[][][] visit = new boolean[bo[0]+1][bo[1]+1][bo[2]+1];
		boolean[] possible = new boolean[bo[2]+1];
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[0][0][bo[2]] = true;
		queue.add(new int[] {0,0,bo[2]});
		while (!queue.isEmpty()) {
			int[] b = queue.poll();
			if (b[0] == 0)
				possible[b[2]] = true;
	
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					if (i == j) continue;
					// b[i] -> b[j]
					if (b[i] > 0 && b[j] < bo[j]) {
						int ni=0, nj=0;
						if (bo[j]-b[j] >= b[i]) { // b[i]가 비워지는 경우
							ni = 0;
							nj = b[i] + b[j];
						} else { // b[j]가 가득 차는 경우
							ni = b[i] - (bo[j]-b[j]);
							nj = bo[j];
						}
						int na=0, nb=0, nc=0;
						if (i == 0) {
							na = ni;
							if (j == 1) {
								nb = nj;
								nc = b[2];
							} else if (j == 2) {
								nc = nj;
								nb = b[1];
							}
						} else if (i == 1) {
							nb = ni;
							if (j == 0) {
								na = nj;
								nc = b[2];
							} else if (j == 2) {
								nc = nj;
								na = b[0];
							}
						} else if (i == 2) {
							nc = ni;
							if (j == 0) {
								na = nj;
								nb = b[1];
							} else if (j == 1) {
								nb = nj;
								na = b[0];
							}
						}
						if (!visit[na][nb][nc]) {
							visit[na][nb][nc] = true;
							queue.add(new int[] {na,nb,nc});
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= bo[2]; ++i) {
			if (possible[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.print(sb);
		bf.close();
	}
}
