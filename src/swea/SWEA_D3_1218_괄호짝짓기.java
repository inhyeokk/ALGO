package swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_D3_1218_괄호짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append("#").append(i).append(" ");
            int n = sc.nextInt();
            char[] str = sc.next().toCharArray();
            Stack<Character> s = new Stack<>();
            for (char c : str) {
                if (s.isEmpty()) {
                    s.push(c);
                } else if (getPair(s.peek()) == c) {
                    s.pop();
                } else {
                    s.push(c);
                }
            }
            sb.append(s.isEmpty()?1:0).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }

    private static char getPair(char c) {
        return switch (c) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            case '<' -> '>';
            default -> ' ';
        };
    }
}
