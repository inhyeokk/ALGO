import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int i = 0; i < T; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int temp = sc.nextInt();
				sum += (temp % 2 != 0) ? temp : 0;
			}
		}
	}
}