package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; ++i) {
            int n = Integer.parseInt(bf.readLine());
            int possible = 1;
            for (int j = 0; j < n; ++j) {
                st = new StringTokenizer(bf.readLine());
                st.nextToken();
                char o = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) {
                    st.nextToken();
                    if (st.hasMoreTokens()) {
                        // 숫자가 자식이 두명있는 경우
                        if (Character.isDigit(o)) {
                            possible = 0;
                        }
                    } else {
                        // 자식이 한명 있는 경우
                        possible = 0;
                    }
                } else if (!Character.isDigit(o)) {
                    // 연산자가 자식이 없는 경우
                    possible = 0;
                }
                 
            }
            sb.append("#").append(i).append(" ").append(possible).append("\n");
        }
        System.out.print(sb);
        bf.close();
    }
}
