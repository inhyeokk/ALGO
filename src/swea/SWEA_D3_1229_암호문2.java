package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D3_1229_암호문2 {
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i <= 10; ++i) {
    		int n = Integer.parseInt(bf.readLine());
    		List<String> strList = new ArrayList<>(n);
			st = new StringTokenizer(bf.readLine());
    		for (int j = 0; j < n; j++) {
    			strList.add(st.nextToken());
    		}
    		int c = Integer.parseInt(bf.readLine());
    		st = new StringTokenizer(bf.readLine());
    		for (int j = 0; j < c; ++j) {
    			char o = st.nextToken().charAt(0);
    			int x, y;
    			switch (o) {
    			case 'I':
    				x = Integer.parseInt(st.nextToken());
    				y = Integer.parseInt(st.nextToken());
    				for (int k = 0; k < y; k++) {
        				strList.add(x+k, st.nextToken());
        			}
    				break;
    			case 'D':
    				x = Integer.parseInt(st.nextToken());
    				y = Integer.parseInt(st.nextToken());
    				for (int k = 0; k < y; k++) {
        				strList.remove(x);
        			}
    				break;
    			}
    			
    		}
    		sb.append("#").append(i).append(" ");
    		for (int j = 0; j < 10; ++j) {
    			sb.append(strList.get(j)).append(" ");
    		}
    		sb.append("\n");
    	}
        System.out.println(sb);
        bf.close();
    }
}