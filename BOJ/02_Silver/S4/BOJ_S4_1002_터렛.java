import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/1002
 * @date   	2020-04-02
 * @author 	rkddlsgur983
 * @memory 	13232KB / 128MB
 * @time   	76ms / 2초
 * @idea	두 원이 접하는 경우를 모두 찾음
 */
public class BOJ_S4_1002_터렛 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int v = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
			int cnt = 2;
			if (x1 == x2 && y1 == y2) { // 중심이 같을 때
				if (r1 == r2) { // 두 원이 일치
					cnt = -1;
				} else { // 반지름의 크기가 다른 원
					cnt = 0;
				}
			} else if ((r1+r2)*(r1+r2) == v) { // 두 원이 외접할 때
				cnt = 1;
			} else if ((r1+r2)*(r1+r2) < v) { // 두 원이 서로 범위 밖일 때
				cnt = 0;
			} else if ((r1-r2)*(r1-r2) == v) { // 두 원이 내접할 때
				cnt = 1;
			} else if ((r1-r2)*(r1-r2) > v) { // 작은 원이 큰 원의 안에 있을 때
				cnt = 0;
			} // 나머지 경우는 두 점에서 만남
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
