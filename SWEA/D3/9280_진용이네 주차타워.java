import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= t; ++i) {
        	sb.append("#").append(i).append(" ");
    		StringTokenizer st = new StringTokenizer(bf.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int[] fee = new int[n];
        	for (int j = 0; j < n; ++j) {
        		fee[j] = Integer.parseInt(bf.readLine());
        	}
        	int[] weight = new int[m+1];
        	for (int j = 1; j <= m; ++j) {
        		weight[j] = Integer.parseInt(bf.readLine());
        	}
        	int answer = 0;
        	int park = 0;
        	int[] possible = new int[n];
        	Queue<Integer> queue = new LinkedList<>();
        	for (int j = 0; j < 2*m; ++j) {
        		int car = Integer.parseInt(bf.readLine());
        		if (car > 0) {
        			if (park < n) {
        				for (int k = 0; k < n; k++) {
            				if (possible[k] == 0) {
            					possible[k] = car;
            					++park;
            					break;
            				}
            			}
        			} else {
        				queue.add(car);
        			}
        		} else {
        			for (int k = 0; k < n; k++) {
        				if (possible[k] == -car) {
        					answer += fee[k]*weight[-car];
        					if (!queue.isEmpty()) {
        						possible[k] = queue.poll();
        					} else {
            					possible[k] = 0;
            					--park;
        					}
        					break;
        				}
        			}
        		}
        	}
    		sb.append(answer).append("\n");
    	}
        System.out.println(sb);
    }
}