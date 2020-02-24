import java.util.Scanner;
import java.util.Stack;

public class 1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int n = sc.nextInt();
			char[] str = sc.next().toCharArray();
			Stack<Character> s = new Stack<>();
			for (int j = 0; j < str.length; j++) {
				if (s.isEmpty()) {
					s.push(str[j]);
				} else if (getPair(s.peek()) == str[j]) {
					s.pop();
				} else {
					s.push(str[j]);
				}
			}
			sb.append(s.isEmpty()?1:0).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static char getPair(char c) {
		switch(c) {
			case '(':
				return ')';
			case '[':
				return ']';
			case '{':
				return '}';
			case '<':
				return '>';
			default:
				return ' ';
		}
	}
}
