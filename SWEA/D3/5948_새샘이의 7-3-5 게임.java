import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    
	private static int N = 7;
	private static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
    	int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
    		sb.append("#").append(i).append(" ");
    		int[] arr = new int[N];
    		for (int j = 0; j < N; j++) {
    			arr[j] = sc.nextInt();
    		}
    		set.clear();
    		bruteForce(0, 0, arr, new boolean[N]);
    		int[] sum = new int[set.size()];
    		Iterator<Integer> it = set.descendingIterator();
    		for (int j = 0; it.hasNext(); j++) {
    			sum[j] = it.next();
    		}
    		sb.append(sum[4]).append("\n");
    	}
        System.out.println(sb);
        sc.close();
    }
    
    private static void bruteForce(int cnt, int sum, int[] arr, boolean[] visit) {
    	
    	if (cnt == 3) {
    		set.add(sum);
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (!visit[i]) {
    			visit[i] = true;
    			bruteForce(cnt+1, sum+arr[i], arr, visit);
    			visit[i] = false;
    		}
    	}
    }
}