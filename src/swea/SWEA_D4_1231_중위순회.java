package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1231_중위순회 {
	private static Node[] tree;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 10; ++i) {
			sb.append("#").append(i).append(" ");
			int n = Integer.parseInt(bf.readLine());
			tree = new Node[n+1];
			for (int j = 0; j < n; ++j) {
				st = new StringTokenizer(bf.readLine());
				int v = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				int l = 0, r = 0;
				if (st.countTokens() > 0) {
					l = Integer.parseInt(st.nextToken());
				}
				if (st.countTokens() > 0) {
					r = Integer.parseInt(st.nextToken());
				}
				tree[v] = new Node(c, l, r);
			}
			inOrder(1);
			sb.append("\n");
		}
		System.out.print(sb);
		bf.close();
	}
	
	private static void inOrder(int v) {
		if (tree[v] != null) {
			inOrder(tree[v].l);
			sb.append(tree[v].c);
			inOrder(tree[v].r);
		}
	}
	
	static class Node {
		char c;
		int l, r;
		public Node(char c, int l, int r) {
			this.c = c;
			this.l = l;
			this.r = r;
		}
	}
}
