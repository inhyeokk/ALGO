package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {@link} 	https://www.acmicpc.net/problem/9372
 * @date   	2020-05-21
 * @author 	lolol0705
 * @memory 	24308KB / 256MB
 * @time   	164ms / 1초
 * @idea	n-1
 */
public class BOJ_S3_9372_상근이의여행2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; ++i) {
				br.readLine();
			}
			sb.append(n-1).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
