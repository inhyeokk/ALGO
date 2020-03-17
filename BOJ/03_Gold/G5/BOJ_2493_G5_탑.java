import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @{link}	https://www.acmicpc.net/problem/2493
 * @date   	2020-03-16
 * @author 	rkddlsgur983
 * @memory 	109620KB / 128MB
 * @time   	608ms / 1.5초
 * @idea	스택에 현재보다 높은 탑의 정보를 유지, 맨위의 탑이 신호를 수신받음
 */
public class BOJ_2493_G5_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			int h = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek()[1] <= h) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0);
			} else {
				sb.append(stack.peek()[0]);
			}
			sb.append(" ");
			stack.add(new int[] {i+1,h});
		}
		System.out.println(sb);
		bf.close();
	}
}
