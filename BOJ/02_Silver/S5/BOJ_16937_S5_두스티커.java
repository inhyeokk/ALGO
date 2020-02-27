import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * {@link} https://www.acmicpc.net/problem/16937
 * @author rkddlsgur983
 * @memory 13444KB
 * @time   100ms
 */
public class BOJ_16937_S5_두스티커 {
	private static int h, w, n;
	private static List<Sticker> list;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(bf.readLine());
		list = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Sticker(r,c,i));
			if (r != c) {
				list.add(new Sticker(c,r,i)); // 길이가 다르면 반대 경우도 추가
			}
		}

		int max = 0;
		// 조합 - index가 다른 2개를 뽑음
		for (int i = 0, len = list.size(); i < len-1; ++i) {
			for (int j = i+1; j < len; ++j) {
				Sticker a = list.get(i);
				Sticker b = list.get(j);
				if (a.index != b.index) {
					if (a.row <= w && a.col <= h && b.row <= w && b.col <= h) {
						int sum = a.row*a.col + b.row*b.col;
						if (a.row + b.row <= w) {
							max = Math.max(sum, max);
						} else if (a.col + b.col <= h) {
							max = Math.max(sum, max);
						}
					}
				}
			}
		}
		System.out.print(max);
		bf.close();
	}
	
	static class Sticker {
		int row;
		int col;
		int index;
		public Sticker(int row, int col, int index) {
			this.row = row;
			this.col = col;
			this.index = index;
		}
	}
}
