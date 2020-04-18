package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_D3_1224_계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
    		sb.append("#").append(i).append(" ");
        	int len = sc.nextInt();
        	String str = sc.next();
        	
        	Stack<Character> stack = new Stack<>();
        	List<Character> list = new ArrayList<>();
        	for (int j = 0; j < len; j++) {
        		Character c = str.charAt(j);
        		if (Character.isDigit(c)) {
        			list.add(c);
        		} else if (c == '('){
        			stack.push(c);
        		} else if (c == ')') {
        			while (!stack.isEmpty() && stack.peek() != '(') {
        				list.add(stack.pop());
        			}
        			if (!stack.isEmpty() && stack.peek() == '(') {
        				stack.pop();
        			}
        		} else {
        			while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
        				list.add(stack.pop());
    				}
    				stack.push(c);
        		}
        	}
        	while (!stack.isEmpty()) {
        		list.add(stack.pop());
        	}
        	
        	Stack<Integer> calcStack = new Stack<>();
    		for (Character c: list) {
    			if (Character.isDigit(c)) {
    				calcStack.push(c-'0');
    			} else {
    				Integer a = calcStack.pop();
    				Integer b = calcStack.pop();
    				calcStack.push(calc(b,a,c));
    			}
    		}
    		sb.append(calcStack.pop()).append("\n");
        }
        System.out.println(sb);
        sc.close();
	}
	
	private static int getPriority(Character c) {
		switch (c) {
			case '+':
				return 1;
			case '*':
				return 2;
			case '(':
				return 0;
			default:
				return 0;
		}
	}
	
	private static int calc(int a, int b, Character o) {
		switch(o) {
			case '+':
				return a+b;
			case '*':
				return a*b;
			default:
				return 0;
		}
	}
}
