package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_D4_8998_세운이는내일할거야 {
	
	public static void main(String[] args) throws IOException {
		
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        for (int i = 1; i <= t; ++i) {
        	sb.append("#").append(i).append(" ");
    		int n = Integer.parseInt(bf.readLine());
    		pq.clear();
    		for (int j = 0; j < n; ++j) {
    			st = new StringTokenizer(bf.readLine());
    			int ti = Integer.parseInt(st.nextToken());
    			int di = Integer.parseInt(st.nextToken());
    			pq.add(new Pair(ti, di));
    		}
    		Pair tmp = pq.peek();
    		int day = tmp.d;
    		while (!pq.isEmpty()) {
    			tmp = pq.poll();
    			if (day > tmp.d) {
    				day = tmp.d - tmp.t;
    			} else {
    				day -= tmp.t;
    			}
    		}
    		sb.append(day).append("\n");
    	}
        System.out.print(sb);
    }
	static class Pair {
		int t;
		int d; // day
		public Pair(int t, int d) {
			this.t = t;
			this.d = d;
		}
	}
	static Comparator<Pair> comparator = new Comparator<Pair>() {
		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.d > o2.d) {
				return -1;
			}
			return 1;
		}
	};
}