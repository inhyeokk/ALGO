package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @date   2020-03-11
 * @author rkddlsgur983
 * @memory 26984KB / 33344KB / 256MB
 * @time   125ms / 134ms / 2초
 * @comment 1차 / 2차 (괄호 맵핑과 개수를 담는 배열 초기화로 인함)
 */
public class SWEA_D4_3378_스타일리쉬들여쓰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		int[] v = new int[6];
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 0); // 괄호 값 맵핑
		map.put(')', 1);
		map.put('{', 2);
		map.put('}', 3);
		map.put('[', 4);
		map.put(']', 5);
		
		for (int i = 1; i <= t; ++i) {
			st = new StringTokenizer(bf.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			Queue<Equation> queue = new LinkedList<>(); // 가능한 방정식의 해
			boolean add = false; // 중간에 큐가 비었을 때 다시 넣지 않기 위함
			Arrays.fill(v, 0); // a ~ f
			for (int j = 0; j < p; ++j) {
				String s = bf.readLine();
				int dot = 0;
				int start = 0, len = s.length();
				if (s.charAt(0) == '.') { // 들여쓰기로 시작하는 경우
					++dot; // 점 개수를 셈
					while (start+1 < len && s.charAt(start+1) == '.') {
						++dot;
						++start;
					}
					// 처음 큐에 방정식이  성립하는 조합을 넣음
					if (!add && queue.isEmpty()) {
						add = true;
						for (int k = 1; k <= 20; ++k) {
							for (int l = 1; l <= 20; ++l) {
								for (int m = 1; m <= 20; ++m) {
									if (dot == k*(v[0]-v[1]) + l*(v[2]-v[3]) + m*(v[4]-v[5])) {
										queue.add(new Equation(k,l,m));
									}
								}
							}
						}
					} else if (!queue.isEmpty()) {
						// 큐 내의 가능한 조합과 현재 a~f값을 비교하여 성립하는 조합을 거름
						for (int k = 0, size = queue.size(); k < size; ++k) {
							Equation eq = queue.poll();
							if (dot == eq.r*(v[0]-v[1]) + eq.c*(v[2]-v[3]) + eq.s*(v[4]-v[5])) {
								queue.add(eq);
							}
						}
					}
				}
				for (int k = start; k < len; ++k) {
					int val = map.getOrDefault(s.charAt(k), 6);
					if (val < 6) ++v[val]; // 맵핑된 괄호 개수 증가
				}
			}
			
			sb.append("#").append(i).append(" ");
			Arrays.fill(v, 0);
			for (int j = 0; j < q; ++j) {
				String s = bf.readLine();
				int dot = 0;
				boolean diff = false;
				if (!queue.isEmpty()) {
					/* 가능한 방정식 조합과 현재 괄호 개수를 매칭
					 * 값이 유일하게 결정되지 않는경우 불가능
					 */
					Equation eq = queue.peek();
					dot = eq.r*(v[0]-v[1]) + eq.c*(v[2]-v[3]) + eq.s*(v[4]-v[5]);
					for (int k = 0, size = queue.size(); k < size; ++k) {
						eq = queue.poll();
						queue.add(eq);
						if (dot != eq.r*(v[0]-v[1]) + eq.c*(v[2]-v[3]) + eq.s*(v[4]-v[5])) {
							diff = true;
							break;
						}
					}
				}
				/* or
				 * 큐가 비어있을 때(p 줄에서 가능한 조합을 찾지 못했을 때)
				 * q 줄에서 괄호의 개수가 남는 경우 불가능
				 */
				if (diff || (dot == 0 && (v[0]-v[1] != 0 || v[2]-v[3] != 0 || v[4]-v[5] != 0))) {
					sb.append(-1);
				} else {
					sb.append(dot);
				}
				sb.append(" ");
				for (int k = 0, len = s.length(); k < len; ++k) {
					int val = map.getOrDefault(s.charAt(k), 6);
					if (val < 6) ++v[val]; // 괄호 개수 증가
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Equation {
		int r;
		int c;
		int s;
		
		public Equation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
