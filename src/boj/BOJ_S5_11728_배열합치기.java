package boj;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_11728_배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int an = Integer.parseInt(st.nextToken());
		int bn = Integer.parseInt(st.nextToken());
		int[] arr = new int[an];
		int[] brr = new int[bn];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < an; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < bn; ++i) {
			brr[i] = Integer.parseInt(st.nextToken());
		}		
		for (int ci = 0, ai=0, bi=0; ci < an+bn; ++ci) {
			int c = 0;
			if (ai >= an) {
				c = brr[bi++];
			} else if (bi >= bn) {
				c = arr[ai++];
			} else {
				c = arr[ai] < brr[bi] ? arr[ai++] : brr[bi++];
			}
			sb.append(c).append(" ");
		}
		System.out.print(sb);
		bf.close();
	}
}
