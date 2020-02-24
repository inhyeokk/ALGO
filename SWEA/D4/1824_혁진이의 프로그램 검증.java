import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	private static int[][] di = {{0,1},{1,0},{0,-1},{-1,0}};
    private static boolean possible;
    private static boolean[][][][] visit;
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
        	sb.append("#").append(i).append(" ");
        	int r = sc.nextInt();
        	int c = sc.nextInt();
        	char[][] order = new char[r][c];
        	for (int j = 0; j < r; j++) {
        		order[j] = sc.next().toCharArray();
        	}
        	possible = false;
        	visit = new boolean[16][4][r][c];
        	Queue<Integer> queue = new LinkedList<>();
        	queue.offer(0); // mem
        	queue.offer(0); // d
        	queue.offer(0); // row
        	queue.offer(0); // col
        	visit[0][0][0][0] = true;
        	while (!queue.isEmpty() && queue.size()<40000) {
        		int mem = queue.poll();
        		int d = queue.poll();
        		int row = queue.poll();
        		int col = queue.poll();
        		char o = order[row][col];
            	if (o == '?') {
            		for (int j = 0; j < 4; j++) {
                		int tr = row + di[j][0];
                		int tc = col + di[j][1];
        	    		if (tr < 0) tr = r-1;
        	    		else if (tr > r-1) tr = 0;
        	    		if (tc < 0) tc = c-1;
        	    		else if (tc > c-1) tc = 0;
        	    		if (order[tr][tc] == '@') {
        	    			possible = true;
        	    			queue.clear();
        	    			break;
        	    		} else if (!visit[mem][j][tr][tc]) {
        	    			visit[mem][j][tr][tc] = true;
        	    			queue.offer(mem);
        	    			queue.offer(j);
        	    			queue.offer(tr);
        	    			queue.offer(tc);
        	    		}
            		}
            		continue;
            	} 
            	if (Character.isDigit(o)) {
            		row += di[d][0];
            		col += di[d][1];
            		if (row < 0) row = r-1;
            		else if (row > r-1) row = 0;
            		if (col < 0) col = c-1;
            		else if (col > c-1) col = 0;
            		mem = o - '0';
            		if (order[row][col] == '@') {
    	    			possible = true;
    	    			queue.clear();
    	    		} else if (!visit[mem][d][row][col]) {
    	    			visit[mem][d][row][col] = true;
            			queue.offer(mem);
    	    			queue.offer(d);
    	    			queue.offer(row);
    	    			queue.offer(col);
            		}
            		continue;
            	} 
            	
            	switch (o) {
    	    	case '<':
    	    		if (col == 0) col = c-1;
    	    		else col--;
    	    		d = 2;
    	    		break;
    	    	case '>':
    	    		if (col == c-1) col = 0;
    	    		else col++;
    	    		d = 0;
    	    		break;
    	    	case '^':
    	    		if (row == 0) row = r-1;
    	    		else row--;
    	    		d = 3;
    	    		break;
    	    	case 'v':
    	    		if (row == r-1) row = 0;
    	    		else row++;
    	    		d = 1;
	    			break;
    	    	case '_':
    	    		if (mem == 0) {
    	    			if (col == c-1) col = 0;
        	    		else col++;
        	    		d = 0;
    	    		} else {
    	    			if (col == 0) col = c-1;
        	    		else col--;
        	    		d = 2;
    	    		}
    	    		break;
    	    	case '|':
    	    		if (mem == 0) {
    	    			if (row == r-1) row = 0;
        	    		else row++;
        	    		d = 1;
    	    		} else {
    	    			if (row == 0) row = r-1;
        	    		else row--;
        	    		d = 3;
    	    		}
    	    		break;
    	    	case '.':
    	    		row += di[d][0];
    	    		col += di[d][1];
    	    		if (row < 0) row = r-1;
    	    		else if (row > r-1) row = 0;
    	    		if (col < 0) col = c-1;
    	    		else if (col > c-1) col = 0;
	    			break;
    	    	case '+':
    	    		if (mem == 15) mem = 0;
    	    		else mem++;
    	    		row += di[d][0];
    	    		col += di[d][1];
    	    		if (row < 0) row = r-1;
    	    		else if (row > r-1) row = 0;
    	    		if (col < 0) col = c-1;
    	    		else if (col > c-1) col = 0;
	    			break;
    	    	case '-':
    	    		if (mem == 0) mem = 15;
    	    		else mem--;
    	    		row += di[d][0];
    	    		col += di[d][1];
    	    		if (row < 0) row = r-1;
    	    		else if (row > r-1) row = 0;
    	    		if (col < 0) col = c-1;
    	    		else if (col > c-1) col = 0;
	    			break;
        		}
            	if (order[row][col] == '@') {
	    			possible = true;
	    			queue.clear();
	    		} else if (!visit[mem][d][row][col]) {
	    			visit[mem][d][row][col] = true;
        			queue.offer(mem);
	    			queue.offer(d);
	    			queue.offer(row);
	    			queue.offer(col);
        		}
        	}
        	String result = possible ? "YES" : "NO";
        	sb.append(result).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}