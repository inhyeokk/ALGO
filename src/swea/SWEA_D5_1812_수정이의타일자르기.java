package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @date   	2020-03-17
 * @author 	rkddlsgur983
 * @memory 	67160KB / 256MB
 * @time   	218ms / 2초
 * @idea	n개의 정사각형 타일 중 큰 타일 먼저 붙인다. (내림차순)
 * 			m크기의 정사각형에서 i번째 정사각형 크기(size)만큼 잘라내면
 * 			(m-size)*size인 직사각형과 (m-size)*m인 직사각형이 남게된다.
 * 			이를 직사각형의 두 변 중 짧은 변의 내림차순으로 정렬하는 우선순위 큐에 넣게되면
 * 			n개의 정사각형이 만들어질 수 있는 최소의 타일 개수를 구할 수 있다.
 * 			-> 직사각형에서 만들 수 있는 가장 큰 정사각형은 둘 중 짧은 변의 길이를 갖는 정사각형이다.
 */
public class SWEA_D5_1812_수정이의타일자르기 {
	private static int n, m;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; ++tc) {
			st = new StringTokenizer(bf.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			PriorityQueue<Rectangle> pq = new PriorityQueue<>();
			int ans = 0;
			for (int i = n-1; i >= 0; --i) {
				int size = 1 << arr[i];
				if (pq.isEmpty() || pq.peek().min < size) {
					if (m-size > 0) {
						pq.add(new Rectangle(m-size, size));
						pq.add(new Rectangle(m-size, m));
					}
					++ans;
				} else if (pq.peek().min == size) {
					Rectangle r = pq.poll();
					if (r.min == r.max) {
						continue;
					} else {
						r.max -= size;
						if (r.max < r.min) {
							int tmp = r.max;
							r.max = r.min;
							r.min = tmp;
						}
						pq.add(r);
					}
				} else {
					Rectangle r = pq.poll();
					pq.add(new Rectangle(r.min-size, size));
					r.max -= size;
					if (r.max < r.min) {
						int tmp = r.max;
						r.max = r.min;
						r.min = tmp;
					}
					pq.add(r);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	static class Rectangle implements Comparable<Rectangle> {
		int min;
		int max;
		public Rectangle(int w, int h) {
			this.min = w < h ? w : h;
			this.max = w < h ? h : w;
		}
		@Override
		public int compareTo(Rectangle o) {
			// 직사각형의 작은 변이 큰 내림차순
			return Integer.compare(o.min, min);
		}
	}
}
