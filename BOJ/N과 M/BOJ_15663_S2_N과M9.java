import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class S2_15663_N과M9 {
	private static StringBuilder sb = new StringBuilder();
	private static int n, m;
	private static int[] arr;
	private static boolean[] visit;
	private static TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			for (int i = 0; i < o1.length; ++i) {
				if (o1[i] < o2[i]) {
					return -1;
				} else if (o1[i] > o2[i]) {
					return 1;
				}
			}
			return 0;
		}
	});
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permutation(0, new int[m]);
		for (int[] s: set) {
			for (int i = 0; i < s.length; ++i) {
				sb.append(s[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
	
	private static void permutation(int depth, int[] tmp) {
		
		if (depth == m) {
			int[] result = tmp.clone();
			set.add(result);
			return;
		}
		
		for (int i = 0; i < n; ++i) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[depth] = arr[i];
				permutation(depth+1, tmp);
				visit[i] = false;
			}
		}
	}
}
