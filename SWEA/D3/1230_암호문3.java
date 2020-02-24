import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
    	for (int i = 1; i <= 10; i++) {
    		sb.append("#").append(i).append(" ");
    		int n = sc.nextInt();
    		List<String> strList = new ArrayList<>();
    		for (int j = 0; j < n; j++) {
    			String str = sc.next();
    			strList.add(str);
    		}
    		int c = sc.nextInt();
    		for (int j = 0; j < c; j++) {
    			char o = sc.next().charAt(0);
    			int x, y;
    			switch (o) {
    			case 'I':
    				x = sc.nextInt();
    				y = sc.nextInt();
    				for (int k = 0; k < y; k++) {
        				String str = sc.next();
        				strList.add(x+k, str);
        			}
    				break;
    			case 'D':
    				x = sc.nextInt();
    				y = sc.nextInt();
    				for (int k = 0; k < y; k++) {
        				strList.remove(x);
        			}
    				break;
    			case 'A':
    				y = sc.nextInt();
    				for (int k = 0; k < y; k++) {
        				String str = sc.next();
        				strList.add(str);
        			}
    				break;
    			}
    			
    		}
    		for (int j = 0; j < 10; j++) {
    			sb.append(strList.get(j)).append(" ");
    		}
    		sb.append("\n");
    	}
        System.out.println(sb);
        sc.close();
    }
}