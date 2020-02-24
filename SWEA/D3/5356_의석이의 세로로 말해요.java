import java.util.Scanner;

class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			String[] strs = new String[5];
			int[] indexs = new int[5];
			for (int j = 0; j < 5; j++) {
				strs[j] = sc.next();
			}
			
			int complete = 0;
			while (complete < 5) {
				complete = 0;
				for (int j = 0; j < 5; j++) {
					if (indexs[j] < strs[j].length()) {
						sb.append(strs[j].charAt(indexs[j]++));
					} else {
						complete++;
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}