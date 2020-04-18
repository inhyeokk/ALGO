package jungol;

import java.util.Scanner;
import java.util.Stack;
 
public class JO_1809_탑 {
	
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[n];
        for (int i = n-1; i >= 0; i--) {
        	// top���� ū ���� ������ ����
        	while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
    			result[stack.pop()] = i+1;
    		}
    		stack.push(i);
        }
        for (int i = 0; i < n; i++) {
        	sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
        sc.close();
    }
}